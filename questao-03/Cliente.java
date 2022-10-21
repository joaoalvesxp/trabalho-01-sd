import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Cliente {
    public static void main(String[] args) {
        Deposito deposito = new Deposito("Deposito 1");

        TV tvSamsung = new TV("TV Samsung 4k",1550.60, 2, true);
        tvSamsung.tranferivel(tvSamsung.isTransferivel());
        if (tvSamsung.isTransferivel()) {
            System.out.println("tv é");
        }
        Celular iphone = new Celular("IPhone X",2000.00,10, true);
        tvSamsung.tranferivel(tvSamsung.isTransferivel());
        if (iphone.isTransferivel()){
            System.out.println("iphone é");
        }
        deposito.adicionarAparelho(tvSamsung);
        deposito.adicionarAparelho(iphone);
        deposito.listarAparelhos();
        deposito.removerPorUnidade("IPhone X",2);
        deposito.removerAparelho(iphone);
        deposito.listarAparelhos();

        ObjectOutputStream obj = new ObjectOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(obj);
        out.writeObject(tvSamsung);
        out.flush();
        out.close();

        ArrayList<Object> objetos = new ArrayList<>();
        objetos.add(tvSamsung);
        Empacotamento.gravarArquivoBinario(objetos,"objetos");
        Desempacotamento.lerArquivoBinario("objetos");


        /*Socket socket = null; // Socket Cliente

        try {
            int serverPort = 7896; // Porta do Servidor

            socket = new Socket("localhost", serverPort);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String envio = "";
            System.out.println("Enviando:\n" + envio);

            out.writeUTF(envio); // UTF is a string encoding see Sn. 4.4

            String data = in.readUTF(); // read a line of data from the stream
            System.out.println("Recebendo:\n" + data);
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
        }*/

    }


}