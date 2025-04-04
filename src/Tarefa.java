public class Tarefa implements ITarefa {
    private final String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean isConcluida() {
        return concluida;
    }

    @Override
    public void marcarComoConcluida() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        return "[" + (concluida ? "X" : " ") + "] " + descricao;
    }
}