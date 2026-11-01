import java.util.ArrayList;
import java.util.List;

public class Membro {

    private final String nome;
    private final int id;
    private final List<Livro> livrosEmprestados = new ArrayList<>();

    public Membro(String nome, int id) {

        this.nome = nome;
        this.id = id;

    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public List<Livro> getPosse() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(Livro livro){
        livrosEmprestados.add(livro);
    }

    public void removeLivrosEmprestados(Livro livro){
        livrosEmprestados.remove(livro);
    }

    public int quantidade(){
        return livrosEmprestados.size();
    }
}