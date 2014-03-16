import javax.swing.*;

import java.awt.event.*;
import java.awt.*;


public class Button extends JPanel{
	private JButton push;
	private JLabel label;
	private JPanel panel;
	private int count;
	
	public Button(){
		count = 0;
		
		push = new JButton("Start!");
		push.addActionListener(new ButtonListener());
		
		label = new JLabel("Pushed: " + count);
		
		
		panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		
		add(push);
		add(label);
		
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(400, 100));
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Countdown timer = new Countdown();
			timer.createAndShowUI();
		}
	}




}
