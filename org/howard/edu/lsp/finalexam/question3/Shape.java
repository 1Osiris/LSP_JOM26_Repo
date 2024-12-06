package org.howard.edu.lsp.finalexam.question3;

// Shape interface
interface Shape {
    void draw();
}

// Concrete shape implementations
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}

// Singleton Shape Factory
class ShapeFactory {
    private static ShapeFactory instance;
    
    private ShapeFactory() {} // Private constructor
    
    public static ShapeFactory getInstance() {
        if (instance == null) {
            synchronized (ShapeFactory.class) {
                if (instance == null) {
                    instance = new ShapeFactory();
                }
            }
        }
        return instance;
    }
    
    public Shape createShape(String shapeType) {
        if (shapeType == null || shapeType.isEmpty()) {
            throw new IllegalArgumentException("Shape type cannot be null or empty");
        }
        
        return switch (shapeType.toLowerCase()) {
            case "circle" -> new Circle();
            case "rectangle" -> new Rectangle();
            case "triangle" -> new Triangle();
            default -> throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        };
    }
}
