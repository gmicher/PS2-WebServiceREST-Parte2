package vagasws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {

    @Autowired
    private EmpresaRepo empresaRepo;

    @GetMapping("/fci/api/empresas")
    public List<Empresa> getEmpresas() {
        return empresaRepo.findAll();
    }

    @GetMapping("/fci/api/empresas/{id}")
    public Empresa getEmpresa(@PathVariable long id) {
        return empresaRepo.findById(id).orElse(null);
    }

    @PostMapping("/fci/api/empresas")
    public Empresa createEmpresa(@RequestBody Empresa novaEmpresa) {
        return empresaRepo.save(novaEmpresa);
    }

    @PutMapping("/fci/api/empresas/{id}")
    public Empresa updateEmpresa(@PathVariable long id, @RequestBody Empresa empresaAtualizada) {
        if (empresaRepo.existsById(id)) {
            empresaAtualizada.setId(id);
            return empresaRepo.save(empresaAtualizada);
        }
        return null;
    }

    @DeleteMapping("/fci/api/empresas/{id}")
    public Empresa deleteEmpresa(@PathVariable long id) {
        var empresa = empresaRepo.findById(id);
        if (empresa.isPresent()) {
            empresaRepo.deleteById(id);
            return empresa.get();
        }
        return null;
    }
}