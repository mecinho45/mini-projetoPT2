import java.util.List;

public class TarefaService {
    private final ITarefaRepository repository;

    public TarefaService(ITarefaRepository repository) {
        this.repository = repository;
    }

    public void adicionarTarefa(ITarefa tarefa) {
        repository.adicionarTarefa(tarefa);
    }

    public void removerTarefa(int indice) {
        repository.removerTarefa(indice);
    }

    public void marcarComoConcluida(int indice) {
        ITarefa tarefa = repository.getTarefa(indice);
        tarefa.marcarComoConcluida();
    }

    public List<ITarefa> listarTarefas() {
        return repository.listarTarefas();
    }
}