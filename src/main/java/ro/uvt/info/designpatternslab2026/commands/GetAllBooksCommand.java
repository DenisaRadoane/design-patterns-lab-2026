package ro.uvt.info.designpatternslab2026.commands;

import ro.uvt.info.designpatternslab2026.services.BooksService;

import java.util.List;
import java.util.Map;

public class GetAllBooksCommand implements Command<List<Map<String, Object>>> {
    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<Map<String, Object>> execute() {
        return booksService.findAll();
    }
}
