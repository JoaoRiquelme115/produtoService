import java.time.LocalDate;

public class Produto {
    private Long id;
    private String nome;
    private Integer qtd;
    private LocalDate dtValidade;
    private double valor;

    public Produto(Long id, String nome, Integer qtd, LocalDate dtValidade, double valor) {
        this.id = id;
        this.nome = nome;
        this.qtd = qtd;
        this.dtValidade = dtValidade;
        this.valor = valor;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
    public void setDtValidade(LocalDate dtValidade) {
        this.dtValidade = dtValidade;
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
    public Integer getQtd() {
        return qtd;
    }
    public LocalDate getDtValidade() {
        return dtValidade;
    }
    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", qtd=" + qtd + ", dtValidade=" + dtValidade + ", valor="
                + valor + "]";
    }
    
}
