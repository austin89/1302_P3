import javax.swing.*;

import java.awt.event.*;
import java.awt.*;


public class Button extends JPanel{
	private JButton push;
	private JPanel panel;
	
	public Button(){
		push = new JButton("Initiate Game!");
		push.addActionListener(new ButtonListener());
		
		panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		
		add(push);
		
		setBackground(Color.LIGHT_GRAY);
		//setPreferredSize(new Dimension(400, 300));
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Countdown timer = new Countdown();
			timer.createAndShowUI();
		}
	}




}
