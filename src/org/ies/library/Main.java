package org.ies.library;

import org.ies.library.components.AuthorReader;
import org.ies.library.components.BookReader;
import org.ies.library.components.LibraryReader;
import org.ies.library.model.Library;
import org.ies.library.model.Book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthorReader authorReader = new AuthorReader(scanner);
        BookReader bookReader = new BookReader(scanner, authorReader);
        LibraryReader libraryReader = new LibraryReader(scanner, bookReader);

        Library library = libraryReader.read();
        System.out.println(library);
    }
}