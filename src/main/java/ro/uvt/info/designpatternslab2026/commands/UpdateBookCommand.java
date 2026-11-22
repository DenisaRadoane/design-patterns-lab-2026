package ro.uvt.info.designpatternslab2026.commands;

import ro.uvt.info.designpatternslab2026.services.BooksService;

import java.util.Map;

public class UpdateBookCommand implements Command<Map<String, Object>> {
    private final BooksService booksService;
    private final Long id;
    private final Map<String, Object> data;

    public UpdateBookCommand(BooksService booksService, Long id, Map<String, Object> data) {
        this.booksService = booksService;
        this.id = id;
        this.data = data;
    }

    @Override
    public Map<String, Object> execute() {
        return booksService.update(id, data);
    }
}