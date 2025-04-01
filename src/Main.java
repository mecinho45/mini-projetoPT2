import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ITarefaRepository repository = new TarefaRepository();
        TarefaService service = new TarefaService(repository);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Gerenciador de Tarefas SOLID ---");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Remover Tarefa");
            System.out.println("3. Marcar como Concluída");
            System.out.println("4. Listar Tarefas");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> adicionarTarefa(scanner, service);
                    case 2 -> removerTarefa(scanner, service);
                    case 3 -> concluirTarefa(scanner, service);
                    case 4 -> listarTarefas(service);
                    case 0 -> {
                        System.out.println("Saindo...");
                        System.exit(0);
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void adicionarTarefa(Scanner scanner, TarefaService service) {
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Prioritária? (s/n): ");
        String resposta = scanner.nextLine();

        ITarefa tarefa;
        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Prioridade (1-5): ");
            int prioridade = Integer.parseInt(scanner.nextLine());
            tarefa = new TarefaPrioritaria(descricao, prioridade);
        } else {
            tarefa = new Tarefa(descricao);
        }

        service.adicionarTarefa(tarefa);
        System.out.println("✅ Tarefa adicionada!");
    }

    private static void removerTarefa(Scanner scanner, TarefaService service) {
        System.out.print("Índice para remover: ");
        int indice = Integer.parseInt(scanner.nextLine()) - 1;
        service.removerTarefa(indice);
        System.out.println("🗑️ Tarefa removida!");
    }

    private static void concluirTarefa(Scanner scanner, TarefaService service) {
        System.out.print("Índice para concluir: ");
        int indice = Integer.parseInt(scanner.nextLine()) - 1;
        service.marcarComoConcluida(indice);
        System.out.println("✔️ Tarefa concluída!");
    }

    private static void listarTarefas(TarefaService service) {
        System.out.println("\n📝 Lista de Tarefas:");
        var tarefas = service.listarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }
}