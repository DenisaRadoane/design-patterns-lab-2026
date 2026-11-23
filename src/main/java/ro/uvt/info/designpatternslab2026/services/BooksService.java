package ro.uvt.info.designpatternslab2026.services;

import org.springframework.stereotype.Service;
import ro.uvt.info.designpatternslab2026.Observer.AllBooksSubject;
import ro.uvt.info.designpatternslab2026.models.Book;
import ro.uvt.info.designpatternslab2026.persistence.CrudRepository;

import java.util.List;

@Service
public class BooksService {

    private final CrudRepository<Book, Integer> booksRepository;
    private final AllBooksSubject allBooksSubject;

    public BooksService(CrudRepository<Book, Integer> booksRepository,
                        AllBooksSubject allBooksSubject) {
        this.booksRepository = booksRepository;
        this.allBooksSubject = allBooksSubject;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public Book findById(Integer id) {
        return booksRepository.findById(id).orElse(null);
    }

    public Book create(Book book) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Book saved = booksRepository.save(book);
        allBooksSubject.add(saved);
        return saved;
    }

    public Book update(Integer id, Book data) {
        if (!booksRepository.existsById(id)) {
            return null;
        }
        data.setId(id);
        return booksRepository.save(data);
    }

    public boolean delete(Integer id) {
        if (!booksRepository.existsById(id)) {
            return false;
        }
        booksRepository.deleteById(id);
        return true;
    }
}