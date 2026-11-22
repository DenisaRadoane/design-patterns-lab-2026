package ro.uvt.info.designpatternslab2026.commands;

import ro.uvt.info.designpatternslab2026.services.BooksService;

import java.util.Map;

public class CreateBookCommand implements Command<Map<String, Object>> {
    private final BooksService booksService;
    private final Map<String, Object> data;

    public CreateBookCommand(BooksService booksService, Map<String, Object> data) {
        this.booksService = booksService;
        this.data = data;
    }

    @Override
    public Map<String, Object> execute() {
        return booksService.create(data);
    }
}
