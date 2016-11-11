package PaSkCode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class PSysView {
	
    PSysView() {
    }

    // draw all particles in psm
    void draw(PSysModel psm, Graphics g) {
    	int radius;
    	for (int i = 0; i < psm.getSize(); i++){
    		radius = psm.pRadius(i);
	    	Graphics2D g2d = (Graphics2D) g;
	    	g2d.setRenderingHints(
	    		new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
	    			RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
	    	
	    	g2d.setColor(Color.RED);
	    	g2d.fillOval(psm.pX(i) - radius, psm.pY(i) - radius, radius * 2, radius * 2);
    	}
    }

    // dump information on all particles in psm
    void dump(PSysModel psm, int lc) {
	    System.out.println("Frame " + lc);
	    for (int i = 0; i < psm.getSize(); i++){
	    	System.out.printf("%5d %5d %5d %5d %5d\n",
	    			psm.pRadius(i), 
	    			psm.pX(i), 
	    			psm.pY(i), 
	    			psm.pVX(i), 
	    			psm.pVY(i));
	    }
	    
    }
}
