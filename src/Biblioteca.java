import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {

    private final List<Livro> acervo = new ArrayList<>();
    private final List<Membro> membros = new ArrayList<>();

    public List<Membro> getMembros() {
        return membros;
    }

    public List<Livro> getAcervo() {
        return acervo;
    }

    public List<Livro> listarDisponiveis(){
        return acervo.stream()
                .filter(livro -> livro.getSituacao() == Livro.Situacao.DISPONIVEL)
                .sorted(Comparator.comparing(Livro::getTitulo))
                .toList();
    }

    public void adicionarLivro(Livro livro) throws LivroDuplicadoException {
        if (acervo.contains(livro)){
            throw new LivroDuplicadoException("Livro já cadastrado: " + livro.getTitulo());
        }acervo.add(livro);
    }

    public void adicionarMembro(Membro membro) throws MembroExistenteException {
        if (membros.contains(membro)){
            throw new MembroExistenteException("Membro já cadastrado: " + membro.getNome());
        }membros.add(membro);
    }

    public void devolver(Membro membro, Livro livro) throws LivroSemPosseException, LivroIndisponivelException {
        membro.removeLivrosEmprestados(livro);
        livro.setSituacao(Livro.Situacao.DISPONIVEL);
    }

    public void emprestar(Membro membro, Livro livro) throws LivroIndisponivelException, LimiteExcedidoException, LivroDuplicadoException {
        membro.setLivrosEmprestados(livro);
        livro.setSituacao(Livro.Situacao.EMPRESTADO);
    }

}
