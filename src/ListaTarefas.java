import java.io.*;
import java.util.ArrayList;

public class ListaTarefas {

    ArrayList<Tarefa> lista;

    public ArrayList<Tarefa> getLista() {
        return lista;
    }

    public ArrayList<Tarefa> getListaPendentes(){
        ArrayList<Tarefa> pendentes = new ArrayList<>();

        for(Tarefa t : lista){
            if(t.getStatus() == false){
                pendentes.add(t);
            }
        }

        return pendentes;
    }

    public Tarefa getTarefa(int id){
        for(Tarefa t : lista){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public void adicionarTarefa(Tarefa t){


        int proxId = 1;

        if (!lista.isEmpty()) {
            proxId = lista.getLast().getId() + 1;
        }

        t.setId(proxId);

        this.lista.add(t);
        gravarListaTarefas();
    }

    public void deletarTarefa(int id){
        for(Tarefa t : lista){
            if(t.getId() == id){
                lista.remove(t);
                break;
            }
        }
        gravarListaTarefas();
    }

    public void finalizarTarefa(int id){
        for(Tarefa t : lista){
            if(t.getId() == id){
                t.finalizar();
                break;
            }
        }
        gravarListaTarefas();
    }

    public void editarTarefa(int id, String novoNome, String novoDesc, String novoData){
        for(Tarefa t : lista){
            if(t.getId() == id){
                if(!novoNome.isEmpty()){
                    t.setNome(novoNome);
                }
                if(!novoDesc.isEmpty()){
                    t.setDescricao(novoDesc);
                }
                if(!novoData.isEmpty()){
                    t.setData(novoData);
                }
                break;
            }
        }
        gravarListaTarefas();
    }

    public void gravarListaTarefas(){
        try {

            FileWriter arq = new FileWriter("src/tarefas.txt");

            for (Tarefa t : lista) {

                arq.write(
                        t.getId()        + ";" +
                            t.getNome()      + ";" +
                            t.getDescricao() + ";" +
                            t.getData()      + ";" +
                            t.getStatus()    + "\n"
                );

            }

            arq.close();

        } catch (IOException e) {
            System.err.printf("Erro ao abrir arquivo: %s.\n", e.getMessage());
        }

    }

    public ListaTarefas() {

        this.lista = new ArrayList<>();

        try {

            FileReader arq = new FileReader("src/tarefas.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            while(true){
                String linha = lerArq.readLine();
                if(linha==null){
                    break;
                }
                this.lista.add(criaTarefa(linha));
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro ao abrir arquivo: %s.\n", e.getMessage());
        }

    }

    public Tarefa criaTarefa(String linha){
        int id           = Integer.parseInt(linha.split(";")[0]);
        String nome      = String.valueOf(linha.split(";")[1]);
        String descricao = String.valueOf(linha.split(";")[2]);
        String data      = String.valueOf(linha.split(";")[3]);
        boolean status   = Boolean.parseBoolean(linha.split(";")[4]);
        return new Tarefa(id,nome,descricao,data,status);
    }

}