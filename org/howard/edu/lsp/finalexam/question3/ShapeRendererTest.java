package org.howard.edu.lsp.finalexam.question3;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShapeRendererTest {
    @Test
    public void testRenderValidShapes() {
        ShapeRenderer renderer = new ShapeRenderer();
        
        // No exceptions should be thrown
        renderer.renderShape("circle");
        renderer.renderShape("rectangle");
        renderer.renderShape("triangle");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRenderInvalidShape() {
        ShapeRenderer renderer = new ShapeRenderer();
        renderer.renderShape("hexagon");
    }
}
