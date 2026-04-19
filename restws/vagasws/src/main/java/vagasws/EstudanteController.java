package vagasws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstudanteController {

    @Autowired
    private EstudanteRepo estudanteRepo;

    @GetMapping("/fci/api/estudantes")
    public List<Estudante> getEstudantes() {
        return estudanteRepo.findAll();
    }

    @GetMapping("/fci/api/estudantes/{id}")
    public Estudante getEstudante(@PathVariable long id) {
        return estudanteRepo.findById(id).orElse(null);
    }

    @PostMapping("/fci/api/estudantes")
    public Estudante createEstudante(@RequestBody Estudante novoEstudante) {
        return estudanteRepo.save(novoEstudante);
    }

    @PutMapping("/fci/api/estudantes/{id}")
    public Estudante updateEstudante(@PathVariable long id, @RequestBody Estudante estudanteAtualizado) {
        if (estudanteRepo.existsById(id)) {
            estudanteAtualizado.setId(id);
            return estudanteRepo.save(estudanteAtualizado);
        }
        return null;
    }

    @DeleteMapping("/fci/api/estudantes/{id}")
    public Estudante deleteEstudante(@PathVariable long id) {
        var estudante = estudanteRepo.findById(id);
        if (estudante.isPresent()) {
            estudanteRepo.deleteById(id);
            return estudante.get();
        }
        return null;
    }
}