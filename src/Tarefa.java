public class Tarefa {

    int id;
    String nome;
    String descricao;
    String data;
    Boolean status;

    public Tarefa(int id, String nome, String descricao, String data, Boolean status) {
        this.id = id;
        this.nome = nome.replaceAll(";",",");
        this.descricao = descricao.replaceAll(";",",");
        this.data = data.replaceAll(";",",");
        this.status = status;
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
        this.nome = nome.replaceAll(";",",");
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.replaceAll(";",",");
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data.replaceAll(";",",");
    }

    public Boolean getStatus() {
        return status;
    }

    public String getStatusExibicao() {
        if(status==true){
            return "Finalizada";
        }else{
            return "Não finalizada";
        }
    }

    public void finalizar(){
        this.status = true;
    }

}