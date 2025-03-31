
/**
 * Melhorias a fazer
 * Implemente uma funcionalidade para listar todos os clientes cadastrados. Adicione a capacidade de associar empréstimos aos clientes, permitindo que você veja quais livros um cliente específico emprestou e quando
 * Mantenha um registro de todos os empréstimos, incluindo os devolvidos.
 * Implemente funcionalidades para buscar livros por título ou autor. Adicione filtros para listar apenas livros de determinados gêneros, ou livros que foram adicionados recentemente.
 * Indo mais além, você pode adicionar um menu, que ao iniciar o sistema, pergunta ao usuário se ele quer cadastrar um novo livro, porém para isso, deverá inserir todos os parâmetros do livro, e após adicionar, o livro ficará disponível para empréstimo.
 */


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Author.Author;
import Book.Book;
import Customer.Customer;
import Library.Library;

public class LibraryApp {
    public static void main(String[] args) throws Exception {
        //criando objeto scanner
        Scanner scanner = new Scanner(System.in);
        //criando objeto library
        Library library = new Library();

        //Adcionando livro, autores e clientes.
        Author author = new Author(001, "J.K. Rowling", LocalDate.of(1995, 07, 31));
        Book book = new Book(001, "Herry Potter", author);
        Book book2 = new Book(002, "Herry Potter 2", author);
        Customer customer = new Customer(001, "Daniel Tadeu", LocalDate.of(1999, 01, 10), "daniel@teste.com");

        // adcionando a library as informações
        library.addBook(book);
        library.addBook(book2);
        library.addAuthor(author);
        library.addCustomer(customer);

        //menu de opções
        while (true) {
            System.out.println("1. Listar Livros Disponíveis");
            System.out.println("2. Emprestar Livro");
            System.out.println("3. Filtrar Livros por Título");
            System.out.println("4. Filtrar Livros por Autor");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            Integer opcao = scanner.nextInt();
            scanner.nextLine(); //limpar buffer

            switch (opcao) {
                case 1:
                    library.listAvailableBooks();
                    break;
                
                case 2:
                    System.out.print("Informe o ID do livro disponivel: ");
                    Integer bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Informe seu nome: ");
                    String custumerName = scanner.nextLine();
                    List<Customer> customers = library.getCustomers();
                    
                    for(Customer customerLoan: customers){
                        if(customerLoan.getName().equalsIgnoreCase(custumerName)){
                            library.lendBook(bookId, customerLoan);
                        } else {
                            System.out.println("Cliente não encontrado! Certifique-se de que está cadastrado.");
                        }
                    }
                    break;
                
                case 3:
                    System.out.print("Qlual o tiltulo do livro?");
                    String bookName = scanner.nextLine();
                    library.filterBooksByTitle(bookName);
                    break;

                case 4:
                    System.out.println("Qual o nome do ator?");
                    String authorName = scanner.nextLine();
                    library.filterBooksByAuthor(authorName);
                    break;

                case 5:
                    System.out.println("saindo...");
                    scanner.close();
                    return;
            
                default:
                    System.out.println("Opção invalida.");
                    break;
            }
        }


    }
}
