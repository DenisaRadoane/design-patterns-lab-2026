package ro.uvt.info.designpatternslab2026.models;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(String paragraph) {
        System.out.println("          " + paragraph + "          ");
    }
}
