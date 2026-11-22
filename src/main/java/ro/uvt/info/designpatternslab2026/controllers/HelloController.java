package ro.uvt.info.designpatternslab2026.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.info.designpatternslab2026.difexamples.ClientComponent;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HelloController {
    private final ClientComponent clientComponent;
    private final ClientComponent anotherClientComponent;

    @GetMapping("/")
    public String hello() {
        return "Hello from ClientComponent = " + clientComponent
                + " | anotherClientComponent = " + anotherClientComponent
                + " | sameInstance = " + (clientComponent == anotherClientComponent);
    }
}
