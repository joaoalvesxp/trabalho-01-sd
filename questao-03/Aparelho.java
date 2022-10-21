public class Aparelho {
    private String nome;
    private Double preço;
    private int quantidadeNoEstoque;
    private Double precoTotal;

    public Aparelho(String nome, Double preço, int quantidadeNoEstoque) {
        this.nome = nome;
        this.preço = preço;
        this.quantidadeNoEstoque = quantidadeNoEstoque;
        this.precoTotal = getPrecoTotal();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreço() {
        return preço;
    }

    public Double getPrecoTotal() {
        precoTotal = getPreço() * getQuantidadeNoEstoque();
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {

        this.precoTotal = precoTotal;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }

    public int getQuantidadeNoEstoque() {
        return quantidadeNoEstoque;
    }

    public void setQuantidadeNoEstoque(int quantidadeNoEstoque) {
        this.quantidadeNoEstoque = quantidadeNoEstoque;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                ", Preço: R$ " + preço +
                ", Quantidade: " + quantidadeNoEstoque +
                ", Preço Total: R$ " + precoTotal;
    }
}

