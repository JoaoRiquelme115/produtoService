import java.sql.Date;

public class Produto {
    private Long id;
    private String nome;
    private Integer qtde;
    private Date dtValidade;
    private Double valor;

    public Produto() {
    }

    public Produto(Long id, String nome, Integer qtde, Date dtValidade, Double valor) {
        this.id = id;
        this.nome = nome;
        this.qtde = qtde;
        this.dtValidade = dtValidade;
        this.valor = valor;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public Integer getQtde() {
        return qtde;
    }
    public double getValor() {
        return valor;
    }
    public void setDtValidade(Date date) {
        this.dtValidade = date;
    }
    public Date getDtValidade() {
        return dtValidade;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", qtde=" + qtde + ", valor="
                + valor + "]";
    }
    
}
