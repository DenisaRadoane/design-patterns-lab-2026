package ro.uvt.info.designpatternslab2026.persistence;

import org.springframework.stereotype.Repository;
import ro.uvt.info.designpatternslab2026.models.Book;

import java.util.List;
import java.util.Optional;

@Repository
public class BooksRepositoryAdapter implements CrudRepository<Book, Integer> {

    private final BooksRepository booksRepository;

    public BooksRepositoryAdapter(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return booksRepository.findById(id);
    }

    @Override
    public Book save(Book entity) {
        return booksRepository.save(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return booksRepository.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        booksRepository.deleteById(id);
    }
}
