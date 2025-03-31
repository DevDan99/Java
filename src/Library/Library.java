
package Library;

import java.util.ArrayList;
import java.util.List;

import Author.Author;
import Book.Book;
import Loan.Loan;
import Customer.Customer;

public class Library {
    private List<Book> books;
    private List<Customer> customers;
    private List<Loan> loan;
    private List<Author> authors;

    //construtor
    public Library(){
        this.books = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.loan = new ArrayList<>();
        this.authors = new ArrayList<>();
    }

    //metodo get
    public List<Customer> getCustomers(){
        return customers;
    }
    
    //metos para adcionar livros, clientes, autores
    public void addBook(Book book){
        books.add(book);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    //listar os livros disponiveis 
    /* com função lambda
        public void listAvailableBooks(){
        books.stream()
      .filter(Book::isAvailable)
      .forEach(b -> System.out.println(b.getId() + " - " + b.getTitle()));
    }*/

    public void listAvailableBooks(){
        System.out.println("Livros Disponiveis:");
        for(Book book : books){
            if(book.isAvailable()){
                System.out.println(String.format("Id: %d,\n title: %s,\n author: %s,\n available: %s\n", book.getId(), book.getTitle(), book.getAuthor().getName(), book.isAvailable()));
            }
        }
        System.out.println("Todos os livros foram emprestados");
    }

    //Metodo emprestar livro
    public void lendBook(Integer bookId, Customer customer){
        for(Book book : books){
            if(book.getId() == bookId && book.isAvailable()){
                Loan loan1 = new Loan(book, customer);
                book.loanHistory(loan1);
                loan.add(loan1);
                System.out.println("Emprestimo realizado com sucesso!");
                return;
            }
        }
        System.out.println("Livro não disponivel para imprestimo.");
    }

    //Metodos de Filtros
    public void filterBooksByTitle(String title){
        for(Book book : books){
            if(book.getTitle().toLowerCase().contains(title.toLowerCase())){
                System.out.println(String.format("Id: %d,\n title: %s,\n author: %s,\n available: %s\n", book.getId(), book.getTitle(), book.getAuthor().getName(), book.isAvailable()));    
            }
        }
    }

    public void filterBooksByAuthor(String author){
        for(Book book : books){
            if(book.getAuthor().getName().toLowerCase().contains(author.toLowerCase())){
                System.out.println(String.format("Id: %d,\n title: %s,\n author: %s,\n available: %s\n", book.getId(), book.getTitle(), book.getAuthor().getName(), book.isAvailable()));          
            }
        }
    }

}
