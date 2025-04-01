import java.util.ArrayList;
import java.util.List;

public class TarefaRepository implements ITarefaRepository {
    private final List<ITarefa> tarefas = new ArrayList<>();

    @Override
    public void adicionarTarefa(ITarefa tarefa) {
        tarefas.add(tarefa);
    }

    @Override
    public void removerTarefa(int indice) {
        if (indice < 0 || indice >= tarefas.size()) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        tarefas.remove(indice);
    }

    @Override
    public ITarefa getTarefa(int indice) {
        return tarefas.get(indice);
    }

    @Override
    public List<ITarefa> listarTarefas() {
        return new ArrayList<>(tarefas);
    }
}