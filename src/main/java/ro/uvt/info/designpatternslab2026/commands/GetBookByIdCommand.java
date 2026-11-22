package ro.uvt.info.designpatternslab2026.commands;

import ro.uvt.info.designpatternslab2026.services.BooksService;

import java.util.Map;

public class GetBookByIdCommand implements Command<Map<String, Object>> {
    private final BooksService booksService;
    private final Long id;

    public GetBookByIdCommand(BooksService booksService, Long id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Map<String, Object> execute() {
        return booksService.findById(id);
    }
}