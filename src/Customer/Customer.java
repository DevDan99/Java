package Customer;


import java.time.LocalDate;

public class Customer {
    Integer id;
    String name;
    LocalDate dateBirht;
    String email;

    public Customer(Integer id, String name, LocalDate dateBirth, String email){
        this.id = id;
        this.name = name;
        this.dateBirht = dateBirth;
        this.email = email;
    }

    //get and set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateBirht() {
        return dateBirht;
    }

    public void setDateBirht(LocalDate dateBirht) {
        this.dateBirht = dateBirht;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Metodos
   /* @Override
    public String toString(){
        return "Emprestimo [livro="+id+ ", nome="+name+", email="+email+"]";
    }*/
    
}
