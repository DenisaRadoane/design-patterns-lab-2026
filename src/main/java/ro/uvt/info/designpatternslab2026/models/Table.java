package ro.uvt.info.designpatternslab2026.models;

public class Table implements Element {
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