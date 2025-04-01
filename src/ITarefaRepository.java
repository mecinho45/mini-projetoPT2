import java.util.List;

public interface ITarefaRepository {
    void adicionarTarefa(ITarefa tarefa);
    void removerTarefa(int indice);
    ITarefa getTarefa(int indice);
    List<ITarefa> listarTarefas();
}