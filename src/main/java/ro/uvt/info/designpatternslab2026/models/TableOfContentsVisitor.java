package ro.uvt.info.designpatternslab2026.models;

import java.util.ArrayList;
import java.util.List;

public class TableOfContentsVisitor implements Visitor {
    private final List<String> entries = new ArrayList<>();

    @Override
    public void visit(Book book) {
    }

    @Override
    public void visit(Section section) {
        entries.add(section.getTitle());
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
    }

    @Override
    public void visit(Paragraph paragraph) {
    }

    @Override
    public void visit(ImageProxy imageProxy) {
    }

    @Override
    public void visit(Image image) {
    }

    @Override
    public void visit(Table table) {
    }

    public TableOfContents getToC() {
        return new TableOfContents();
    }
}