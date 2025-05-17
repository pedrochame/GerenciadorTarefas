import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        ListaTarefas lt = new ListaTarefas();
        String op,id,nome,data,desc;

        while(true){

            System.out.println(" -- MENU -- \n"+
                    """
                            1 - Adicionar tarefa
                            2 - Editar tarefa
                            3 - Deletar tarefa
                            4 - Visualizar tarefas
                            5 - Visualizar tarefas pendentes
                            6 - Finalizar tarefa
                            7 - Sair
                            """
            );

            System.out.print("Opção: ");
            op = sc.next();
            System.out.println();

            switch (op) {

                case "1":

                    System.out.println(" - ADICIONAR TAREFA - \n");

                    System.out.print("Nome: ");
                    nome = sc.next();

                    System.out.print("Descrição: ");
                    desc = sc.next();

                    System.out.print("Data: ");
                    data = sc.next();

                    lt.adicionarTarefa(new Tarefa(0, nome, desc, data, false));
                    System.out.println("\nTarefa adicionada !");

                    break;

                case "2":

                    System.out.println(" - EDITAR TAREFA - \n");

                    System.out.print("Id: ");
                    id = sc.next();

                    Tarefa t = lt.getTarefa(Integer.parseInt(id));
                    if (t != null) {

                        System.out.print("\nNome: " + t.getNome() + "\n");
                        System.out.print("Novo nome (deixe vazio para manter): ");
                        nome = sc.next();

                        System.out.print("Descrição: " + t.getDescricao() + "\n");
                        System.out.print("Nova descrição (deixe vazio para manter): ");
                        desc = sc.next();

                        System.out.print("Data: " + t.getData() + "\n");
                        System.out.print("Nova data (deixe vazio para manter): ");
                        data = sc.next();

                        lt.editarTarefa(Integer.parseInt(id), nome, desc, data);
                        System.out.println("\nTarefa editada !");

                    }else{
                        System.out.println("\nNão foi possível localizar a tarefa.");
                    }

                    break;

                case "3":

                    System.out.println(" - DELETAR TAREFA - \n");

                    System.out.print("Id: ");
                    id = sc.next();

                    if (lt.getTarefa(Integer.parseInt(id)) != null) {
                        lt.deletarTarefa(Integer.parseInt(id));
                        System.out.println("\nTarefa deletada !");
                    }else{
                        System.out.println("\nNão foi possível localizar a tarefa.");
                    }

                    break;

                case "4":

                    System.out.println(" - VISUALIZAR TAREFAS - \n");

                    if (lt.getLista().isEmpty()){
                        System.out.println("Não há tarefas !");
                    }

                    for (Tarefa tarefa : lt.getLista()) {
                        System.out.println(
                                "\nId: " + tarefa.getId() + "\n" +
                                "Nome: " + tarefa.getNome() + "\n" +
                                "Descrição: " + tarefa.getDescricao() + "\n" +
                                "Data: " + tarefa.getData() + "\n" +
                                "Status: " + tarefa.getStatusExibicao()
                        );
                    }

                    break;

                case "5":

                    System.out.println(" - VISUALIZAR TAREFAS PENDENTES - \n");

                    if (lt.getListaPendentes().isEmpty()){
                        System.out.println("Não há tarefas pendentes!");
                    }

                    for (Tarefa tarefa : lt.getListaPendentes()) {

                        System.out.println(
                                "\nId: " + tarefa.getId() + "\n" +
                                        "Nome: " + tarefa.getNome() + "\n" +
                                        "Descrição: " + tarefa.getDescricao() + "\n" +
                                        "Data: " + tarefa.getData() + "\n" +
                                        "Status: " + tarefa.getStatusExibicao()
                        );
                    }

                    break;

                case "6":

                    System.out.println(" - FINALIZAR TAREFA - \n");

                    System.out.print("Id: ");
                    id = sc.next();

                    if (lt.getTarefa(Integer.parseInt(id)) != null) {
                        lt.finalizarTarefa(Integer.parseInt(id));
                        System.out.println("\nTarefa finalizada !");
                    }else{
                        System.out.println("\nNão foi possível localizar a tarefa.");
                    }

                    break;

                case "7":

                    System.exit(1);

                    break;


            }
            System.out.print("\n\nTecle algo para continuar...");
            sc.next();
            System.out.println("\n");
        }
    }
}