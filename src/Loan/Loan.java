package Loan;

// Source code is decompiled from a .class file using FernFlower decompiler.

import Book.Book;
import Customer.Customer;
import java.time.LocalDate;

public class Loan {
   Book book;
   Customer customer;
   LocalDate dateLoan;
   LocalDate dateRetorn;

   public Loan(Book book, Customer customer) {
      this.book = book;
      this.customer = customer;
      this.dateLoan = LocalDate.now();
   }

   public Book getBook() {
      return this.book;
   }

   public void setBook(Book book) {
      this.book = book;
   }

   public Customer getCustomer() {
      return this.customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   public LocalDate getDateLoan() {
      return this.dateLoan;
   }

   public void setDateLoan(LocalDate dateLoan) {
      this.dateLoan = dateLoan;
   }

   public void returnBook() {
      this.dateRetorn = LocalDate.now();
      this.book.refund();
   }
}
