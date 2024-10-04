import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Tarefas {
    private String filePath;
    private List<String> tasks;

    public Tarefas(String filePath) {
        this.filePath = filePath;
        this.tasks = new ArrayList<>();
    }

    // Método para adicionar uma tarefa à lista em memória
    public void adicionarTarefa(String task) {
        tasks.add(task);
        System.out.println("=== Tarefa [" + task + "] adicionada com sucesso ===");
    }

    // Método para remover uma tarefa da lista em memória
    public void removerTarefa(String task) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Adiciona à lista, exceto se for o item a ser removido
                if (!line.trim().equals(task)) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        // Escreve a lista de volta no arquivo, sem o item removido
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
        System.out.println("O item \"" + task + "\" foi removido (se existia) do arquivo.");
    }


    // Método para listar todas as tarefas salvas no arquivo
    public void listarTarefasSalvas() {
        System.out.println("=== Listar Tarefas Salvas ===");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        System.out.println("======================");
    }

    // Método para salvar as tarefas da lista no arquivo
    public void salvarTarefas() {
        System.out.println("=== Salvar Tarefas ===");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            for (String task : tasks) {
                bw.write(task);
                bw.newLine();
            }
            tasks.clear();  // Limpa a lista após salvar as tarefas
        } catch (IOException e) {
            System.out.println("Erro ao salvar as tarefas: " + e.getMessage());
        }
        System.out.println("=== Tarefas salvas com sucesso ====");
    }
}
