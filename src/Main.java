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
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
    }
}
