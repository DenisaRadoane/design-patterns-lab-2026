package ro.uvt.info.designpatternslab2026.commands;

import ro.uvt.info.designpatternslab2026.services.BooksService;

public class DeleteBookCommand implements Command<Boolean> {
    private final BooksService booksService;
    private final Integer id;

    public DeleteBookCommand(BooksService booksService, Integer id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Boolean execute() {
        return booksService.delete(id);
    }
}