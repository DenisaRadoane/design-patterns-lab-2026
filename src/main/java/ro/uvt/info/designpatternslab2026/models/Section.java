package ro.uvt.info.designpatternslab2026.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

@Entity
@Getter
@Setter
@NoArgsConstructor(force = true)

public class Section extends BaseElement {
    protected String title;
    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL)
    protected List<Element> children = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void add(Element element) {
        children.add(element);
    }

    @Override
    public void remove(Element element) {
        children.remove(element);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }

    public void render() {
        System.out.println(title);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element element : children) {
            element.accept(visitor);
        }
    }

    public String getTitle() {
        return title;
    }

}