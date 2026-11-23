package ro.uvt.info.designpatternslab2026.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.info.designpatternslab2026.Observer.AllBooksSubject;
import ro.uvt.info.designpatternslab2026.Observer.SseObserver;

@RestController
@RequiredArgsConstructor
public class BooksSseController {

    private final AllBooksSubject allBooksSubject;

    @GetMapping(value = "/books-sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter getBooksSse() {
        SseEmitter emitter = new SseEmitter(0L);
        SseObserver observer = new SseObserver(emitter);

        allBooksSubject.attach(observer);

        emitter.onCompletion(() -> allBooksSubject.detach(observer));
        emitter.onTimeout(() -> {
            allBooksSubject.detach(observer);
            emitter.complete();
        });
        emitter.onError(e -> allBooksSubject.detach(observer));

        return emitter;
    }
}