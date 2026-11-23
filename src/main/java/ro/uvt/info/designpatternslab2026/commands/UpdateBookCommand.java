package ro.uvt.info.designpatternslab2026.commands;

import ro.uvt.info.designpatternslab2026.models.Book;
import ro.uvt.info.designpatternslab2026.services.BooksService;

public class UpdateBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final Integer id;
    private final Book book;

    public UpdateBookCommand(BooksService booksService, Integer id, Book book) {
        this.booksService = booksService;
        this.id = id;
        this.book = book;
    }

    @Override
    public Book execute() {
        return booksService.update(id, book);
    }
}