package bookstore.code;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String title, author, isbn;
    private double price;
    private int year;

    
    public Book() {}

    public Book(String title, String author, int year, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return year;
    }

    public void setPublicationYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
        @Override
    public String toString() {
    return "Title: " + title + "Author: " + author + "Year: " + year + "Price: " + price + "Isbn: " + isbn;
    }
    

}
