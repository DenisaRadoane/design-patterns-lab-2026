package ro.uvt.info.designpatternslab2026.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BooksService {
    private final Map<Long, Map<String, Object>> books = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Map<String, Object>> findAll() {
        return new ArrayList<>(books.values());
    }

    public Map<String, Object> findById(Long id) {
        return books.get(id);
    }

    public Map<String, Object> create(Map<String, Object> data) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long id = idGenerator.getAndIncrement();
        Map<String, Object> item = new LinkedHashMap<>(data);
        item.put("id", id);
        item.putIfAbsent("isbn", "978-" + (100000000 + id));
        books.put(id, item);
        return item;
    }

    public Map<String, Object> update(Long id, Map<String, Object> data) {
        if (!books.containsKey(id)) {
            return null;
        }
        Map<String, Object> item = new LinkedHashMap<>(data);
        item.put("id", id);
        books.put(id, item);
        return item;
    }

    public boolean delete(Long id) {
        return books.remove(id) != null;
    }
}