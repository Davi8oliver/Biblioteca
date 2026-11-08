import java.util.ArrayList;
import java.util.List;

public class Membro {

    private final String nome;
    private final int cpf;
    private final List<Livro> livrosEmprestados = new ArrayList<>();

    public Membro(String nome, int cpf) {

        this.nome = nome;
        this.cpf = cpf;

    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return cpf;
    }

    public List<Livro> getPosse() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(Livro livro) throws LimiteExcedidoException, LivroDuplicadoException {

        if (livrosEmprestados.size() >= 4){
            throw new LimiteExcedidoException("Membro ja atingiu o limite 3 livros");
        }else if (livrosEmprestados.contains(livro)){
            throw new LivroDuplicadoException("Membro já possui o Livro: " + livro.getTitulo());
        }

        livrosEmprestados.add(livro);
    }

    public void removeLivrosEmprestados(Livro livro) throws LivroSemPosseException {

        if (!livrosEmprestados.contains(livro)){
            throw new LivroSemPosseException("Membro não tem a posse do o livro: " + livro.getTitulo());
        }

        livrosEmprestados.remove(livro);
    }

    public int quantidade(){
        return livrosEmprestados.size();
    }
}