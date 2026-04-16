package vagasws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController {

    private List<Empresa> empresas = new ArrayList<>();

    public EmpresaController() {
        empresas.add(new Empresa(1, "Empresa Alfa LTDA", "12.345.678/0001-90", "contato@empresa-alfa.com"));
        empresas.add(new Empresa(2, "Beta Comércio ME", "98.765.432/0001-10", "beta@comercio.com"));
        empresas.add(new Empresa(3, "Gamma Serviços S. A.", "11.222.333/0001-44", "servicos@gamma.com"));
        empresas.add(new Empresa(4, "Delta Engenharia", "22.333.444/0001-55", "contato@deltaeng.com"));
        empresas.add(new Empresa(5, "Epsilon Digital", "33.444.555/0001-66", "email@epsilondigital.com"));
    }

    @GetMapping("/fci/api/empresas")
    public List<Empresa> getEmpresas() {
        return empresas;
    }

    @GetMapping("/fci/api/empresas/{id}")
    public Empresa getEmpresa(@PathVariable long id) {
        for (Empresa e : empresas) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @PostMapping("/fci/api/empresas")
    public Empresa createEmpresa(@RequestBody Empresa novaEmpresa) {
        long maiorId = 0;

        for (Empresa e : empresas) {
            if (e.getId() > maiorId) {
                maiorId = e.getId();
            }
        }

        novaEmpresa.setId(maiorId + 1);
        empresas.add(novaEmpresa);
        return novaEmpresa;
    }

    @PutMapping("/fci/api/empresas/{id}")
    public Empresa updateEmpresa(@PathVariable long id, @RequestBody Empresa empresaAtualizada) {
        for (int i = 0; i < empresas.size(); i++) {
            if (empresas.get(i).getId() == id) {
                empresaAtualizada.setId(id);
                empresas.set(i, empresaAtualizada);
                return empresaAtualizada;
            }
        }
        return null;
    }

    @DeleteMapping("/fci/api/empresas/{id}")
    public Empresa deleteEmpresa(@PathVariable long id) {
        for (int i = 0; i < empresas.size(); i++) {
            if (empresas.get(i).getId() == id) {
                return empresas.remove(i);
            }
        }
        return null;
    }
}