import java.util.ArrayList;

public class Urna {
    private ArrayList<Candidato> candidatos;
    private ArrayList<Usuario> eleitores;
    private int numeroDeIdentificacao;
    private int tempoDeVotacao;
    private int totalDeVotacoes;

    public Urna(ArrayList<Candidato> candidatos, ArrayList<Usuario> eleitores, int numeroDeIdentificacao) {
        this.candidatos = candidatos;
        this.eleitores = eleitores;
        this.numeroDeIdentificacao = numeroDeIdentificacao;
    }

    public void inicializarVotacao() {

    }

    public void encerrarVotacao() {

    }

    public boolean verificaEleitor () {
        return true;
    }

    public void resultadoVotação () {

    }

}
