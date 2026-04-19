package vagasws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VagaController {

    @Autowired
    private VagaRepo vagaRepo;

    @GetMapping("/fci/api/vagas")
    public List<Vaga> getVagas() {
        return vagaRepo.findAll();
    }

    @GetMapping("/fci/api/vagas/{id}")
    public Vaga getVaga(@PathVariable long id) {
        return vagaRepo.findById(id).orElse(null);
    }

    @PostMapping("/fci/api/vagas")
    public Vaga createVaga(@RequestBody Vaga novaVaga) {
        return vagaRepo.save(novaVaga);
    }

    @PutMapping("/fci/api/vagas/{id}")
    public Vaga updateVaga(@PathVariable long id, @RequestBody Vaga vagaAtualizada) {
        if (vagaRepo.existsById(id)) {
            vagaAtualizada.setId(id);
            return vagaRepo.save(vagaAtualizada);
        }
        return null;
    }

    @DeleteMapping("/fci/api/vagas/{id}")
    public Vaga deleteVaga(@PathVariable long id) {
        var vaga = vagaRepo.findById(id);
        if (vaga.isPresent()) {
            vagaRepo.deleteById(id);
            return vaga.get();
        }
        return null;
    }
}