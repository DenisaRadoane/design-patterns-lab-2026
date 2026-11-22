package ro.uvt.info.designpatternslab2026.commands;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class AsyncCommandExecutor {
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
    private final Map<String, AsyncRequestStatus<?>> jobs = new ConcurrentHashMap<>();

    public <T> String submit(Command<T> command) {
        String requestId = UUID.randomUUID().toString();
        jobs.put(requestId, AsyncRequestStatus.pending(requestId));

        executorService.submit(() -> {
            try {
                T result = command.execute();
                jobs.put(requestId, AsyncRequestStatus.completed(requestId, result));
            } catch (Exception ex) {
                jobs.put(requestId, AsyncRequestStatus.failed(requestId, ex.getMessage()));
            }
        });

        return requestId;
    }

    @SuppressWarnings("unchecked")
    public <T> AsyncRequestStatus<T> getStatus(String requestId) {
        return (AsyncRequestStatus<T>) jobs.get(requestId);
    }
}
