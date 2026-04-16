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
public class EstudanteController {

    private List<Estudante> estudantes = new ArrayList<>();

    public EstudanteController() {
        estudantes.add(new Estudante(1, "Ana Paula Souza", "ana.souza@email.com", "2002-03-15", 2020));
        estudantes.add(new Estudante(2, "Carlos Henrique Lima", "carlos.lima@email.com", "2001-10-22", 2019));
        estudantes.add(new Estudante(3, "Fernanda Oliveira", "fernanda.oliveira@email.com", "2003-07-05", 2021));
        estudantes.add(new Estudante(4, "Lucas Pereira", "lucas.pereira@email.com", "2002-04-11", 2020));
        estudantes.add(new Estudante(5, "Gabriela Martins", "gabriela.martins@email.com", "2001-12-25", 2019));
        estudantes.add(new Estudante(6, "Rafael Costa", "rafael.costa@email.com", "2000-09-13", 2018));
        estudantes.add(new Estudante(7, "Juliana Silva", "juliana.silva@email.com", "2002-06-18", 2020));
        estudantes.add(new Estudante(8, "Marcos Vinícius", "marcos.vinicius@email.com", "2003-01-30", 2021));
        estudantes.add(new Estudante(9, "Camila Azevedo", "camila.azevedo@email.com", "2001-11-08", 2019));
        estudantes.add(new Estudante(10, "Felipe Cardoso", "felipe.cardoso@email.com", "2000-08-27", 2018));
    }

    @GetMapping("/fci/api/estudantes")
    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    @GetMapping("/fci/api/estudantes/{id}")
    public Estudante getEstudante(@PathVariable long id) {
        for (Estudante e : estudantes) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @PostMapping("/fci/api/estudantes")
    public Estudante createEstudante(@RequestBody Estudante novoEstudante) {
        long maiorId = 0;

        for (Estudante e : estudantes) {
            if (e.getId() > maiorId) {
                maiorId = e.getId();
            }
        }

        novoEstudante.setId(maiorId + 1);
        estudantes.add(novoEstudante);
        return novoEstudante;
    }

    @PutMapping("/fci/api/estudantes/{id}")
    public Estudante updateEstudante(@PathVariable long id, @RequestBody Estudante estudanteAtualizado) {
        for (int i = 0; i < estudantes.size(); i++) {
            if (estudantes.get(i).getId() == id) {
                estudanteAtualizado.setId(id);
                estudantes.set(i, estudanteAtualizado);
                return estudanteAtualizado;
            }
        }
        return null;
    }

    @DeleteMapping("/fci/api/estudantes/{id}")
    public Estudante deleteEstudante(@PathVariable long id) {
        for (int i = 0; i < estudantes.size(); i++) {
            if (estudantes.get(i).getId() == id) {
                return estudantes.remove(i);
            }
        }
        return null;
    }
}