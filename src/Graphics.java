import java.awt.*;
import javax.swing.*;

public class Graphics {

	public static void main(String[] args) {
		

		JFrame frame = new JFrame("Let's make some magic!");	//displays words on top of window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//guarantees that the app exits when pressing X
/*		
		JPanel panel = new JPanel();							//instantiates new JPanel
		panel.setPreferredSize (new Dimension(480, 500));		//sets the size of the JPanel to 480 width and 500 height
		panel.setBackground(Color.GREEN);
		frame.getContentPane().add(panel);						//gets the JFrame and adds the 480x500 screen size
*/		
		
		
		//Button pushButton = new Button();
		//frame.getContentPane().add(pushButton);
		
		frame.getContentPane().add(new Slider());

		frame.pack();
		frame.setVisible(true);									//displays the application
		
	}

}
