
 import javax.swing.*;
 import java.awt.*;
 import java.util.Random;
 
 public class SierpinskiGasket extends JFrame {
    
    public static void main(String[] args) {
    	
    	SierpinskiGasket gFrame = new SierpinskiGasket ();
    	gFrame.setVisible(true); }
    	
    	
    public SierpinskiGasket() {
    	
    	super ("Sierpinski Gasket");
    	setSize(400,400);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	getContentPane().setBackground(Color.white);
    }
    
    public void paint (Graphics g) {
    	
    	// set arrays containing the coordinates. One for X and one for Y
    	// create a Random object to pull from the arrays
    	int [] xCoords = {20, 380, 200};
    	int [] yCoords = {380, 380, 50};
    	Random gen = new Random();
    	
    	// Draw the first three vertices
    	g.drawLine(xCoords[0],yCoords[0],xCoords[0],yCoords[0]);
    	g.drawLine(xCoords[1],yCoords[1],xCoords[1],yCoords[1]);
    	g.drawLine(xCoords[2],yCoords[2],xCoords[2],yCoords[2]);
    	
    	// pick a vertex to start as current 
    	int currX = xCoords[0];
    	int currY = yCoords[0];
    	
    	
    	// for loop to control the amount of pixels plotted
    	for (int count=0; count <= 50000; count++) {
    		
    		// use the length of the array to generate a number to set the target coordinates
    		// the y and x coordinates need to match, so I only generated one number based on the
    		// length of the x coordinate array to set the target coordinates
    		int target = gen.nextInt(xCoords.length);
    		
    		// find the midpoint
    		int midX = (currX + xCoords[target]) / 2;
    		int midY = (currY + yCoords[target]) / 2;
    		
    		// plot the midpoint
    		g.drawLine(midX, midY, midX, midY);
    		
    		// update the 'current' coordinates to the midpoint and loop
    		currX=midX;
    		currY=midY;
    	}
    }

    }

