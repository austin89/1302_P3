import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class Time extends JFrame{
	JLabel promptLabel, timerLabel;
	private int counter;
	JTextField tf;
	JButton button;
	Timer timer;
	
	public Time(){
		setLayout(new GridLayout(2, 2, 5, 5));
		
		//promptLabel = new JLabel("Enter Seconds: ", SwingConstants.CENTER);
		//add(promptLabel);
		
		//tf = new JTextField(5);
		//add(tf);
		
		//button = new JButton("Start!");
		//add(button);
		
		timerLabel = new JLabel("", SwingConstants.CENTER);
		add(timerLabel);
		
		event e = new event();
		button.addActionListener(e);
		
	}
	
	//Action performed when the button is pressed
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int count = 5;
			timerLabel.setText("Begin in:\n" + count);
			
			TimeClass tc = new TimeClass(count);
			timer = new Timer(1000, tc);
			timer.start();
		}
	}
	
	//Action performed for the timer
	public class TimeClass implements ActionListener{
		int counter;
		
		//Construction to take count parameter (from the previous method) and set it equal to the counter variable
		public  TimeClass(int counter){
			this.counter = counter;
		}
		//this method gets invoked every time the timer changes (every second)
		public void actionPerformed(ActionEvent tc){
			counter--;
			
			if(counter >= 1){
				timerLabel.setText("Time Left: " + counter);
			}
			else{
				timer.stop();
				timerLabel.setText("Done!");
			}
		}
		
	}
	
	public void showCountdown(){
		Time gui = new Time();
		gui.setTitle("Timer");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(250, 100);
		gui.setVisible(true);
	}
	

}
