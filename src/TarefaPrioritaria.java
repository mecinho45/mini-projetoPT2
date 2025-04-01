public class TarefaPrioritaria extends Tarefa {
    private final int prioridade;

    public TarefaPrioritaria(String descricao, int prioridade) {
        super(descricao);
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return super.toString() + " (Prioridade: " + prioridade + ")";
    }
}