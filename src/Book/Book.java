package Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Author.Author;
import Loan.Loan;

public class Book {
    private Integer id;
    private String title;
    private Author author;
    private boolean available;
    private LocalDate dateRegistrred;
    private LocalDate dateUpDate;
    private List<Loan> loanHistory; 

    public Book(Integer id, String title, Author author){
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
        this.dateRegistrred = LocalDate.now();
        this.dateUpDate = LocalDate.now();
        this.loanHistory = new ArrayList<>();
    }

    //get and set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDate getDateRegistrred() {
        return dateRegistrred;
    }

    public void setDateRegistrred(LocalDate dateRegistrred) {
        this.dateRegistrred = dateRegistrred;
    }

    public LocalDate getDateUpDate() {
        return dateUpDate;
    }

    public void setDateUpDate(LocalDate dateUpDate) {
        this.dateUpDate = dateUpDate;
    }

    //verifica a disponibilidade e empresta o livro (maca disponibilidade como true)
    public void toLoan(){
        if(available){
            setAvailable(false);
            setDateUpDate(LocalDate.now());
        } else {
            System.out.println("Livro já foi emprestado.");
        }
    }

    //verifica a disponibilidade do livro e devolve o livro (marca disponibilidae como false)
    public void refund(){
        if(!available){
            setAvailable(true);
            setDateUpDate(LocalDate.now());
        } else {
            System.out.println("Livro não foi emprestado.");
        }
    }

    //pega o historico de emprestido do livro
    public void loanHistory(Loan loan){
        this.loanHistory.add(loan);
        setAvailable(false);
    }

    /*@Override
    public String toString(){
        return "livros [Id="+id+", title="+title+", author="+author.getName()+", available="+available+"]";
    }*/
}
