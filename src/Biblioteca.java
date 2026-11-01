import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {

    Membro membro;
    Livro livro;

    private final List<Livro> acervo = new ArrayList<>();
    private final List<Membro> membros = new ArrayList<>();

    public List<Livro> listarDisponiveis(){
        return acervo.stream()
                .filter(livro -> livro.getSituacao() == Livro.Situacao.DISPONIVEL)
                .sorted(Comparator.comparing(Livro::getTitulo))
                .toList();
    }

    public void adicionarLivro(Livro livro) throws LivroDuplicadoException {

        boolean existe = acervo.stream().anyMatch(l -> l.getIsbn().equals(livro.getIsbn()));

        if (existe){
            throw new LivroDuplicadoException("Livro já cadastrado: " + livro.getTitulo());
        }acervo.add(livro);
    }

    public void devolver() throws LivroSemPosseException{

        boolean possui = membro.getPosse().stream().anyMatch(l -> l.getIsbn().equals(livro.getIsbn()));

        if (possui){
            throw new LivroSemPosseException("Membro não possui o livro: " + livro.getTitulo());
        }
        membro.removeLivrosEmprestados(livro);
    }

    public void emprestar() throws LivroIndisponivelException, LimiteExcedidoException {
        if (livro.getSituacao() == Livro.Situacao.EMPRESTADO) {
            throw new LivroIndisponivelException("Livro já emprestado: " + livro.getTitulo());
        } else if (membro.quantidade() > 3) {
            throw new LimiteExcedidoException("Membro ja atingiu o limite de livros: " + membro.getPosse());
        }
        livro.setSituacao(Livro.Situacao.EMPRESTADO);
        membro.setLivrosEmprestados(livro);
    }

}
