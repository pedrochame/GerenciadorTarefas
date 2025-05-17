import java.util.Date;

public class Tarefa {

    int id;
    String nome;
    String descricao;
    Date data;
    Boolean status;

    public Tarefa(int id, String nome, String descricao, Date data) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.status = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void finalizarTarefa(){
        this.status = true;
    }


}
