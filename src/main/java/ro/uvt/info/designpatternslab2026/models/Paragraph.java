package ro.uvt.info.designpatternslab2026.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Transient;

@Entity
@Getter
@Setter
@NoArgsConstructor(force = true)
public class Paragraph extends BaseElement {
    private String text;
    @Transient
    private AlignStrategy textAlignment;

    public Paragraph(String text) {
        this.text = text;
    }


    public void setAlignStrategy(AlignStrategy strategy) {
        this.textAlignment = strategy;
    }

    public void render() {
        if (textAlignment != null) {
            textAlignment.render(text);
        } else {
            System.out.println(text);
        }
    }
    @Override
    public void add(Element element) { }

    @Override
    public void remove(Element element) { }

    @Override
    public Element get(int index) {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}