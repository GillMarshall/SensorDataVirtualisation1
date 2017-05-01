package sensordatavirtualisation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mikemarshall
 */

import java.awt.*;

public class GraphComponent extends Canvas {
    public GraphComponent() {
        // Set preferred size for the grap
        setPreferredSize(new Dimension(300, 300));
        
        // Ensure that it is visible
        setVisible(true);
    }
    
    // Override the 'paint' method
    @Override
    public void paint(Graphics g)
    {
        // Clear the entire canvas
        g.setColor(Color.WHITE);
        g.clearRect(0, 0, getWidth(), getHeight());
        
        // Draw a bit of background with a 10 pixel border
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(10, 10, getWidth()-20, getHeight()-20);
        
        // Drow axis lines
        g.setColor(Color.BLACK);
        g.drawLine(20, 20, 20, getHeight()-20);
        g.drawLine(20, getHeight()-20, getWidth()-20, getHeight()-20);
        
        // Draw data
        // TODO
    }
}
