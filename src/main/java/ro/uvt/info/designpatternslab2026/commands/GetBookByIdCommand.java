package ro.uvt.info.designpatternslab2026.commands;

import ro.uvt.info.designpatternslab2026.models.Book;
import ro.uvt.info.designpatternslab2026.services.BooksService;

public class GetBookByIdCommand implements Command<Book> {
    private final BooksService booksService;
    private final Integer id;

    public GetBookByIdCommand(BooksService booksService, Integer id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Book execute() {
        return booksService.findById(id);
    }
}