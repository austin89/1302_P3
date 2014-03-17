import javax.swing.*;

import java.awt.event.*;
import java.awt.*;


public class Button extends JPanel{
	private JButton push;		//new Button
	private JPanel panel;		//new panel for the button
	private JFrame frame;		//new frame for the panel and button to be displayed in
	
	
	public Button(){
		push = new JButton("Initiate Game!");			//sets the text displayed on the button
		push.addActionListener(new ButtonListener());	//adds new action to be performed when the button is pressed
		
		panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);		
		panel.setLayout(layout);						//sets the alignment of the JFRAME window
		
		add(push);										//adds the button to the frame window
		
		setBackground(Color.LIGHT_GRAY);				//sets the color scheme of the initial window
		//setPreferredSize(new Dimension(400, 300));	//sets the size of the initial window
	}

	
	public void showFrame(){
		frame = new JFrame("Let's make some magic!");			//displays words on top of window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//guarantees that the app exits when pressing X
		
		frame.getContentPane().add(new Slider());				//adds the level slider to the window
		
		frame.pack();
		frame.setVisible(true);									//displays the application
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Countdown timer = new Countdown();		//creates a new Countdown object
			timer.createAndShowUI();				//displays the countdown timer (but still in a separate window)
		}
	}




}
