import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tarefas tarefas = new Tarefas("src/tasks.txt");

        System.out.println("=== Gerenciamento de Tarefas ===");

        while (true) {
            System.out.println("Selecione uma opção:\n" +
                    "[0] Sair\n" +
                    "[1] Adicionar Tarefa\n" +
                    "[2] Excluir Tarefa\n" +
                    "[3] Listar Tarefas Salvas\n" +
                    "[4] Salvar Tarefas");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consumir a linha para evitar problemas com o scanner

            if (option == 0) {
                System.out.println("=== Saindo... ===");
                break;

            } else if (option == 1) {
                System.out.println("=== Adicionar Tarefa ===");
                System.out.print("Digite uma nova tarefa: ");
                String task = scanner.nextLine();
                tarefas.adicionarTarefa(task);

            } else if (option == 2) {
                System.out.println("=== Remover Tarefa ===");
                System.out.print("Digite a tarefa que deseja remover: ");
                String task = scanner.nextLine();
                tarefas.removerTarefa(task);

            } else if (option == 3) {
                tarefas.listarTarefasSalvas();

            } else if (option == 4) {
                tarefas.salvarTarefas();
            }
        }

        scanner.close();
    }
}
