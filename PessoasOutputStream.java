import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.net.*;
import java.io.*;


public class PessoasOutputStream extends OutputStream {

    private OutputStream op;
    private Pessoa[] pessoas;


    public PessoasOutputStream(Pessoa[] p, OutputStream os) {
        this.pessoas = p;
        this.op = os;
    }

    public void writeSystem() {

        PrintStream opLocal = new PrintStream(op);

        //envia quantidade de pessoas;
        int qtdpessoa = pessoas.length;
        opLocal.println("Quantidade de pessoas: "+qtdpessoa);

        //envia os dados de um conjunto (array) de Pessoas
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                int tamanhoNomePessoa = pessoa.getNome().getBytes().length;
                String nome = pessoa.getNome();
                String cpf = pessoa.getCpf();
                byte idade = pessoa.getIdade();

                opLocal.println("tamanhoNomePessoa: "+tamanhoNomePessoa+ "\n"+
                        "nomePessoa: "+nome+ "\n"+
                        "cpf: "+cpf+ "\n"+
                        "idade: "+idade);
            }
        }
    }

    public void writeFile() {
        try{
            FileOutputStream arquivo =new FileOutputStream("D:\\Workspace\\Java\\sockets_e_stream\\src\\pessoas.txt");

            String pessoaInfo = info(pessoas[0].getNome(), pessoas[0].getCpf(), pessoas[0].getIdade());

            byte[] pessoaInfoBytes=pessoaInfo.getBytes();

            arquivo.write(pessoaInfoBytes);
            arquivo.close();
            System.out.println("Salvo com sucesso!");

        } catch(Exception e){
            System.out.println(e);
        }
    }

    public String info(String nome, String cpf, byte idade) {
        String info = "";
        info = "Nome: " + nome + "\n" + "CPF: " + cpf + "\n" + "Idade: " + idade + "\n";
        return info;
    }

    public void writeTCP() {
        Socket socket = null;

        try {
            int serverPort = 7896;
            socket = new Socket("localhost", serverPort);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String envio = info(pessoas[0].getNome(), pessoas[0].getCpf(), pessoas[0].getIdade());
            System.out.println("Sent:\n" + envio);

            out.writeUTF(envio); // UTF is a string encoding see Sn. 4.4

            String data = in.readUTF(); // read a line of data from the stream
            System.out.println("Received:\n" + data);
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
    }

    @Override
    public void write(int b) throws IOException {
        // TODO Auto-generated method stub
    }

    @Override
    public String toString() {
        return "Ola, mundo! Estamos sobrescrevendo o método toString()!\n"
                + " PessoasOutputStream [ \n"
                + " getClass()=" + getClass() +",\n"
                + " hashCode()=" + hashCode() +",\n"
                + " toString()="+ super.toString() + "]";
    }
}


