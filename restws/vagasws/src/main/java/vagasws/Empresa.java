package vagasws;

public class Empresa {
    private long id;
    private String nome;
    private String cnpj;
    private String emailContato;

    public Empresa() {
    }

    public Empresa(long id, String nome, String cnpj, String emailContato) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.emailContato = emailContato;
    }

    public Empresa(String nome, String cnpj, String emailContato) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.emailContato = emailContato;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }
}