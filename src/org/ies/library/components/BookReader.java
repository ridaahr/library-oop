package org.ies.library.components;

import org.ies.library.model.Author;
import org.ies.library.model.Book;

import java.util.Scanner;

public class BookReader {
    private final Scanner scanner;
    private final AuthorReader authorReader;

    public BookReader(Scanner scanner, AuthorReader authorReader) {
        this.scanner = scanner;
        this.authorReader = authorReader;
    }

    public Book read() {
        System.out.println("Introduce los datos del libro");
        System.out.println("Introduce el ISBN");
        String isbn = scanner.nextLine();

        System.out.println("Introduce el título");
        String title = scanner.nextLine();

        System.out.println("Introduce el año");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduce el número de autores");
        int size = scanner.nextInt();
        scanner.nextLine();
        Author[] authors = new Author[size];
        for (int i = 0; i < authors.length; i++) {
            authors[i] = authorReader.read();
        }

        return new Book(
                isbn,
                title,
                year,
                authors
        );
    }
}
