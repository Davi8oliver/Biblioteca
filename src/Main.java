/* Uma biblioteca precisa controlar o seu acervo e os empréstimos aos membros.
 * Cada livro tem título, autor, ISBN e situação (disponível ou emprestado).
 * Cada membro tem nome, id e os livros que está com ele. Um membro pode ter
 * no máximo 3 livros emprestados ao mesmo tempo, um livro já emprestado não
 * pode ser emprestado de novo, e devolver um livro que o membro não possui
 * deve ser tratado como erro. Esses erros precisam ser sinalizados com exceções
 * próprias, não com retornos boolean. A biblioteca também deve listar os livros
 * disponíveis ordenados por título.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws LivroDuplicadoException, MembroExistenteException {

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opc;
        String titulo;
        String autor;
        String isbn;
        String nome;
        int cpf;

        do {

            System.out.println("========================================");
            System.out.println("              Biblioteca\n");
            System.out.println("1- Ver ascervo");
            System.out.println("2- Ver membros");
            System.out.println("3- Registrar membro");
            System.out.println("4- Registrar livro");
            System.out.println("5- Emprestimo de livro");
            System.out.println("6- devolução de livro");
            System.out.println("7- Sair\n");
            System.out.println("========================================");
            opc = scanner.nextInt();
            System.out.print("\n\n\n");

            switch (opc){
                case 1 -> biblioteca.getAcervo();
                case 2 -> biblioteca.getMembros();
                case 3 -> {

                    System.out.println("nome: ");
                    nome = scanner.next();
                    System.out.println("cpf: ");
                    cpf = scanner.nextInt();

                    biblioteca.adicionarMembro(new Membro(nome, cpf));
                }
                case 4 -> {

                    System.out.println("titulo: ");
                    titulo = scanner.next();
                    System.out.println("autor: ");
                    autor = scanner.next();
                    System.out.println("ISBN: ");
                    isbn = scanner.next();

                    biblioteca.adicionarLivro(new Livro(titulo, autor, isbn));
                }
                case 5 -> {
                    System.out.println("Digite o nome do Membro: ");
                    nome = scanner.next();
                    System.out.println("Digite o cpf do Membro: ");
                    cpf = scanner.nextInt();

                    if (biblioteca.getMembros().contains(cpf));
                }
                case 6 -> {

                }
                case 7 -> {
                    System.out.println("Adeus!!");
                }
                default -> throw new IllegalStateException("Unexpected value: " + opc);
            }
        }while (opc != 7);


    }
}
