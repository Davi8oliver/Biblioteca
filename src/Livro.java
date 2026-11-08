public class Livro {
    Biblioteca biblioteca = new Biblioteca();

    private final String titulo;
    private final String autor;
    private final String isbn;
    public enum Situacao{
        DISPONIVEL, EMPRESTADO
    }
    private Situacao situacao;

    public Livro(String titulo, String autor, String isbn){

        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.situacao = Situacao.DISPONIVEL;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) throws LivroIndisponivelException {
        if (this.situacao == situacao){
            throw new LivroIndisponivelException("Livro já emprestado: " + titulo);
        }
        this.situacao = situacao;
    }
}
