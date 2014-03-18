import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
 
public class GameFrame extends JPanel{
    JPanel panel;
    JLabel label;
 
 
    public GameFrame(){
        //panel = new JPanel();
        //panel.setVisible(false);      //make sure this is the last line AFTER you add the pane
    }
 
    public void showGame(){
        JFrame frame = new JFrame("Whack-a-Shape!");
        frame.getContentPane().add(new GameFrame());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);        
        frame.setVisible(true);     //make sure this is the last line AFTER you add the pane
    }
 
 
    public void paintComponent(Graphics g)  
    {  
       super.paintComponent(g);                     //call superclass's paintComponent 
       Paint p = new Paint();
        
       //Rectangle
       //(X-VALUE, Y-VALUE, WIDTH, HEIGHT)
       g.setColor(Color.ORANGE);
       g.fillRect(p.setX(), p.setY(), 100, 150);    //draws filled in rectangle
 
/*       
       //Oval
       //(X-VALUE, Y-VALUE, WIDTH, HEIGHT)
       g.setColor(Color.RED);                       //sets color of the shape
       g.fillOval(p.setX(), p.setY(), 100, 100);    //draws filled in oval
*/     
    }
 
}