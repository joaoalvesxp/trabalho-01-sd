import java.io.IOException;

public class TesteInput {
    public static void main(String[] args) throws IOException {
        Pessoa[] pessoas = new Pessoa[1];
        PessoasInputStream pessoaIn = new PessoasInputStream(pessoas, System.in);
        pessoaIn.readSystem();
        pessoaIn.readFile();
        pessoaIn.readTCP();
        pessoaIn.close();
    }
}