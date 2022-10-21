public class Main {
    public static void main(String[] args) {
        Deposito deposito = new Deposito("Deposito 1");
        TV tvSamsung = new TV("TV Samsung 4k",1550.60, 2);
        Celular iphone = new Celular("IPhone X",2000.00,10);
        deposito.adicionarAparelho(tvSamsung);
        deposito.adicionarAparelho(iphone);
        deposito.listarAparelhos();
        deposito.removerPorUnidade("IPhone X",2);
        deposito.removerAparelho(iphone);
        deposito.listarAparelhos();
    }
}