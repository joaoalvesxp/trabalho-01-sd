
import java.io.IOException;


public class TestStreams {
    public static void main(String[] args) throws IOException {

        Pessoa[] pessoas = new Pessoa[1];
        PessoasInputStream pis = new PessoasInputStream(pessoas, System.in);
        pessoas = pis.readSystem();
        pis.close();

        PessoasOutputStream pos = new PessoasOutputStream(pessoas, System.out);
        pos.writeFile();
        pos.writeTCP();
        pos.writeSystem();
        pos.close();
    }
}