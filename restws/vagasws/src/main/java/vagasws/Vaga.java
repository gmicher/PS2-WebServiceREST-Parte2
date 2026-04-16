package vagasws;

public class Vaga {
    private long id;
    private String titulo;
    private String descricao;
    private String publicacao;
    private boolean ativo;
    private long idEmpresa;

    public Vaga() {
    }

    public Vaga(long id, String titulo, String descricao, String publicacao, boolean ativo, long idEmpresa) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.publicacao = publicacao;
        this.ativo = ativo;
        this.idEmpresa = idEmpresa;
    }

    public Vaga(String titulo, String descricao, String publicacao, boolean ativo, long idEmpresa) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.publicacao = publicacao;
        this.ativo = ativo;
        this.idEmpresa = idEmpresa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(String publicacao) {
        this.publicacao = publicacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}