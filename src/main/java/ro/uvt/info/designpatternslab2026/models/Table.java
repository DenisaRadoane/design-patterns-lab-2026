package ro.uvt.info.designpatternslab2026.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@jakarta.persistence.Table(name = "doc_table")
@Getter
@Setter
@NoArgsConstructor(force = true)

public class Table extends BaseElement {
    private String title;

    public Table(String title) {
        this.title = title;
    }

    public void render() {
        System.out.println("Table: " + title);
    }

    @Override
    public void add(Element element) {}

    @Override
    public void remove(Element element) {}

    @Override
    public Element get(int index) {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}