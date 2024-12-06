package org.howard.edu.lsp.finalexam.question3;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShapeFactoryTest {
    @Test
    public void testSingletonInstance() {
        ShapeFactory factory1 = ShapeFactory.getInstance();
        ShapeFactory factory2 = ShapeFactory.getInstance();
        
        assertSame("Factory instances should be the same", factory1, factory2);
    }
    
    @Test
    public void testCreateCircle() {
        ShapeFactory factory = ShapeFactory.getInstance();
        Shape shape = factory.createShape("circle");
        
        assertNotNull(shape);
        assertTrue(shape instanceof Circle);
    }
    
    @Test
    public void testCreateRectangle() {
        ShapeFactory factory = ShapeFactory.getInstance();
        Shape shape = factory.createShape("rectangle");
        
        assertNotNull(shape);
        assertTrue(shape instanceof Rectangle);
    }
    
    @Test
    public void testCreateTriangle() {
        ShapeFactory factory = ShapeFactory.getInstance();
        Shape shape = factory.createShape("triangle");
        
        assertNotNull(shape);
        assertTrue(shape instanceof Triangle);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidShapeType() {
        ShapeFactory factory = ShapeFactory.getInstance();
        factory.createShape("hexagon");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullShapeType() {
        ShapeFactory factory = ShapeFactory.getInstance();
        factory.createShape(null);
    }
}
