package ro.uvt.info.designpatternslab2026.Observer;

import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2026.models.Book;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject {

    private final List<Observer> observerCollection = new CopyOnWriteArrayList<>();

    public void attach(Observer observer) {
        observerCollection.add(observer);
    }

    public void detach(Observer observer) {
        observerCollection.remove(observer);
    }

    public void notifyObservers(Book book) {
        for (Observer observer : observerCollection) {
            observer.update(book);
        }
    }

    public void add(Book book) {
        notifyObservers(book);
    }
}