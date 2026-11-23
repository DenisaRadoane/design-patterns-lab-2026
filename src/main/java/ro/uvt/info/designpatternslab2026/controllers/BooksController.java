package ro.uvt.info.designpatternslab2026.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.info.designpatternslab2026.commands.*;
import ro.uvt.info.designpatternslab2026.models.Book;
import ro.uvt.info.designpatternslab2026.services.BooksService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BooksController {
    private final BooksService booksService;
    private final SyncCommandExecutor syncExecutor;
    private final AsyncCommandExecutor asyncExecutor;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(syncExecutor.execute(new GetAllBooksCommand(booksService)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        Book book = syncExecutor.execute(new GetBookByIdCommand(booksService, id));
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createBook(@RequestBody Book body) {
        String requestId = asyncExecutor.submit(new CreateBookCommand(booksService, body));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Map.of(
                "requestId", requestId,
                "statusUrl", "/books/requests/" + requestId
        ));
    }

    @GetMapping("/requests/{requestId}")
    public ResponseEntity<AsyncRequestStatus<?>> getRequestStatus(@PathVariable String requestId) {
        AsyncRequestStatus<?> status = asyncExecutor.getStatus(requestId);
        if (status == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book body) {
        Book updated = syncExecutor.execute(new UpdateBookCommand(booksService, id, body));
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        if (!syncExecutor.execute(new DeleteBookCommand(booksService, id))) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}