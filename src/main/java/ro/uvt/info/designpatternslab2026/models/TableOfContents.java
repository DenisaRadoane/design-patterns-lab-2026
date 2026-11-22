package ro.uvt.info.designpatternslab2026.models;

public class TableOfContents implements Element {
    public void render() {
        System.out.println("Table of Contents");
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