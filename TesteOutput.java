import java.io.IOException;

public class TesteOutput {
        public static void main(String[] args) throws IOException {

                Pessoa[] pessoas = new Pessoa[1];

                System.out.println("- Questão 1 -");
                String nome = "João";
                String cpf = "000.000.00-00";
                byte idade = 20;

                pessoas[0] = new Pessoa(nome, cpf, idade);

                PessoasOutputStream pessoaOut = new PessoasOutputStream(pessoas, System.out);
                pessoaOut.writeSystem();
                pessoaOut.writeFile();
                pessoaOut.writeTCP();
                pessoaOut.close();
        }
}