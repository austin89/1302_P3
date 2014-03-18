import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

import javax.swing.JPanel;


public class Paint extends JPanel{
	Random width = new Random();
	Random height = new Random();
	Random r = new Random();
	
	public Paint(){
		
	}
	
	public int setX(){
		return width.nextInt(250);
	}
	
	public int setY(){
		return height.nextInt(250);
	}
	
	public int getWidth(){
		return r.nextInt(100);
	}
	
	public int getHeight(){
		return r.nextInt(50);
	}

}
