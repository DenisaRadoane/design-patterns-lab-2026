package ro.uvt.info.designpatternslab2026.Observer;

import ro.uvt.info.designpatternslab2026.models.Book;

public interface Observer {
    void update(Book book);
}