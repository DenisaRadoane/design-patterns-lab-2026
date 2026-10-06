package ro.uvt.info.designpatternslab2026.models;

public class ImageProxy implements Element {
    private String url;
    private Image realImage;

    public ImageProxy(String url) {
        this.url = url;
    }

    // Metodă internă care instanțiază imaginea reală doar la nevoie
    private Image loadImage() {
        if (realImage == null) {
            realImage = new Image(url);
        }
        return realImage;
    }

    @Override
    public void print() {
        loadImage().print();
    }

    @Override
    public void add(Element element) { }

    @Override
    public void remove(Element element) { }

    @Override
    public Element get(int index) {
        return null;
    }
}