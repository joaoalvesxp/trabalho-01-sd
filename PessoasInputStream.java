import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.FileInputStream;

public class PessoasInputStream extends InputStream {

    private InputStream is;
    private Pessoa[] pessoas;

    public PessoasInputStream(Pessoa[] p, InputStream is) {
        this.pessoas = p;
        this.is = is;
    }

    public Pessoa[] readSystem() {

        Scanner sc = new Scanner(is);

        System.out.println("Informa o nome da pessoa:");
        String nome = sc.nextLine();
        System.out.println("Informe o cpf da pessoa:");
        String cpf = sc.nextLine();
        System.out.println("Informe a idade do pessoa:");
        byte idade = sc.nextByte();

        pessoas[0] = new Pessoa(nome, cpf, idade);

        sc.close();

        return pessoas;
    }

    public Pessoa[] readFile() {

        return pessoas;
    }

    public Pessoa[] readTCP() {

        return pessoas;
    }

    @Override
    public int read() throws IOException {
        // TODO Auto-generated method stub
        return 0;
    }

}