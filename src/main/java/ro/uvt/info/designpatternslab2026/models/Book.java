package ro.uvt.info.designpatternslab2026.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(force = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Author> authors = new ArrayList<>();

    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL)
    private List<Element> content = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void addContent(Element element) {
        this.content.add(element);
    }

    public void render() {
        System.out.println(title);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element element : content) {
            element.accept(visitor);
        }
    }
}