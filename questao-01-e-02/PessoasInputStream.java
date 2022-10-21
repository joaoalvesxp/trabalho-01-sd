import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PessoasInputStream extends InputStream {

    private InputStream is;
    private Pessoa[] pessoas;

    public PessoasInputStream(Pessoa[] p, InputStream is) {
        this.pessoas = p;
        this.is = is;
    }

    public Pessoa[] readSystem() {

        Scanner sc = new Scanner(is);

        System.out.println("Teste pelo (System.in)\nInforma o nome da pessoa:");
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
        System.out.println("Teste lendo o arquivo");
        int i;
        String nomedoarquivo = "D:\\Workspace\\Java\\sockets_e_stream\\src\\pessoas.txt";

        try (FileInputStream fin = new FileInputStream(nomedoarquivo)) {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

        return pessoas;
    }

    public Pessoa[] readTCP() {
        Socket socket = null;

        try {
            int serverPort = 7896;
            socket = new Socket("localhost", serverPort);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String envio = pessoas[0].toString();
            System.out.println("Enviando para o Servidor:\n" + envio);

            out.writeUTF(envio); // UTF is a string encoding see Sn. 4.4

            String data = in.readUTF(); // read a line of data from the stream
            System.out.println("Recebido do Sevidor:\n" + data);
        } catch (UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            if (socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("close:" + e.getMessage());
                }
        }

        return pessoas;
    }

    @Override
    public int read() throws IOException {
        // TODO Auto-generated method stub
        return 0;
    }

}