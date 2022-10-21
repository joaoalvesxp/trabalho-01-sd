public class Main {
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
    }
}