package org.ies.library.model;

import java.util.Arrays;
import java.util.Objects;

public class Library {
    private String name;
    private Book[] books;

    public Library(String name, Book[] books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public boolean hasBook(String isbn) {
        for (Book book: books) {
            if (book.getIsbn().equals(isbn)) {
                return true;
            }
        }   return false;
    }

//    public boolean hasAuthor(String nif) {
//        for (Book book: books) {
//            for (Author author: book.getAuthors()) {
//                if (author.getNif().equals(nif)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public boolean hasAuthor(String nif) {
        for (Book book: books) {
            if(book.hasAuthor(nif)) {
                return true;
            }
        }   return false;
    }

//    public int countBooks(String nif) {
//        int numBooks = 0;
//        for (Book book: books) {
//            for (Author author: book.getAuthors()) {
//                if (author.getNif().equals(nif)) {
//                    numBooks ++;
//                }
//            }
//        }   return numBooks;
//    }

    public int countBooks(String nif) {
        int numBooks = 0;
        for (Book book: books) {
            if(book.hasAuthor(nif)) {
                numBooks++;
            }
        }   return numBooks;
    }

    public int countYearBooks(int year) {
        int numYearBooks = 0;
        for (Book book: books) {
            if (book.getYear() == (year)) {
                numYearBooks++;
            }
        }   return numYearBooks;
    }

    public void findBook(String isbn) {
        for (Book book: books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }   return null;
    }



    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", books=" + Arrays.toString(books) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) && Objects.deepEquals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(books));
    }
}
