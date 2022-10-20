public class Pessoa {
    String nome;
    String cpf;
    byte idade;

    public Pessoa(String nome, String cpf, byte idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public byte getIdade() {
        return idade;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }
    @Override

    public String toString(){
        return String.format("Nome: " + getNome()  + "\n" + "CPF: " + getCpf() + "\n" + "Idade: " + getIdade());
    }
}
