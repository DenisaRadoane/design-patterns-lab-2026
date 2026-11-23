package ro.uvt.info.designpatternslab2026.commands;

import ro.uvt.info.designpatternslab2026.models.Book;
import ro.uvt.info.designpatternslab2026.services.BooksService;

public class CreateBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final Book book;

    public CreateBookCommand(BooksService booksService, Book book) {
        this.booksService = booksService;
        this.book = book;
    }

    @Override
    public Book execute() {
        return booksService.create(book);
    }
}