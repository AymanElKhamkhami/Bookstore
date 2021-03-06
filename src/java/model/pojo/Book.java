package model.pojo;
// Generated 06-Feb-2015 15:31:02 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Book generated by hbm2java
 */
public class Book  implements java.io.Serializable {


     private int isbn;
     private String title;
     private String author;
     private String publisher;
     private String category;
     private String format;
     private String description;
     private double price;
     private Set cartbooks = new HashSet(0);

    public Book() {
    }

	
    public Book(int isbn, String title, String author, String publisher, String category, String format, String description, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.format = format;
        this.description = description;
        this.price = price;
    }
    public Book(int isbn, String title, String author, String publisher, String category, String format, String description, double price, Set cartbooks) {
       this.isbn = isbn;
       this.title = title;
       this.author = author;
       this.publisher = publisher;
       this.category = category;
       this.format = format;
       this.description = description;
       this.price = price;
       this.cartbooks = cartbooks;
    }
   
    public int getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return this.publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public String getFormat() {
        return this.format;
    }
    
    public void setFormat(String format) {
        this.format = format;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public Set getCartbooks() {
        return this.cartbooks;
    }
    
    public void setCartbooks(Set cartbooks) {
        this.cartbooks = cartbooks;
    }




}


