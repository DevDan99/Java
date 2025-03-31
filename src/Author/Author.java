package Author;

import java.time.LocalDate;

public class Author {
    private Integer id;
    private String name;
    private LocalDate dateBirht;
    
    //constructor
    public Author(Integer id, String name, LocalDate dateBirth){
        this.id = id;
        this.name = name;
        this.dateBirht = dateBirth;
    }

     //Getters and Stters
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
    
    //sobrescrever o metodo toString
    /*@Override
    public String toString(){
        return "Author: " + name;
    }*/
    
}
