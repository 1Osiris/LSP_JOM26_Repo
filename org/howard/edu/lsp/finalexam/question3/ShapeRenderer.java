package org.howard.edu.lsp.finalexam.question3;

// Refactored ShapeRenderer
public class ShapeRenderer {
    private final ShapeFactory shapeFactory;
    
    public ShapeRenderer() {
        this.shapeFactory = ShapeFactory.getInstance();
    }
    
    public void renderShape(String shapeType) {
        try {
            Shape shape = shapeFactory.createShape(shapeType);
            shape.draw();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
