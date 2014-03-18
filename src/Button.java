import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Button extends JPanel{
	private JButton push;       		//new Button
	private JPanel panel;       		//new panel for the button
	private JFrame frame;       		//new frame for the panel and button to be displayed in
	private Timer timer;				//new count down timer
	private JLabel space, timerLabel;	//labels for the timer and a space between the "start game button" and the timer


	public Button(){
		push = new JButton("Start Game!");           			//sets the text displayed on the button
		push.setAlignmentX (Component.CENTER_ALIGNMENT);

		space = new JLabel("\n");								//adds a space between the "start game" button and the count down timer
		space.setAlignmentX (Component.CENTER_ALIGNMENT);

		timerLabel = new JLabel("", SwingConstants.CENTER);		//adds the count down timer below the "start game" button	
		timerLabel.setAlignmentX (Component.CENTER_ALIGNMENT);

		panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);      
		panel.setLayout(layout);                        //sets the alignment of the JFRAME window

		panel.add(push);                                //adds the button to the frame window
		panel.add(space);
		panel.add(timerLabel);                          //adds count down to the window (still in the same window though)

		add(panel);										//adds the panels in BoxLayout style

		event e = new event();							//the mouse click event when the user wants to play the game
		push.addActionListener(e);						//listener for the mouse click

		//setPreferredSize(new Dimension(500, 265));      //sets the size of the initial window
	}


	public void showFrame(){
		frame = new JFrame("Whack-a-Shape!");           		//displays words on top of window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //guarantees that the app exits when pressing X
		frame.getContentPane().add(new Slider());               //adds the level slider to the window
		frame.setSize(500, 265);
		frame.setVisible(true); 								//displays the application
	}



	//Action performed when the button is pressed (count down begins)
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent e){

			panel.remove(push);				//gets rid of the button after you press it
			panel.remove(space);			//removes random space added above
			Slider slider = new Slider();
			slider.repaint();
			
			int count = 5;                                  //count down starts at 5
			timerLabel.setText("Start game in: " + count);

			CountDown tc = new CountDown(count);            //makes new TimeClass object to keep track of the count down
			timer = new Timer(1000, tc);
			timer.start();
		}
	}

	//Count down action performed for the timer
	public class CountDown implements ActionListener{
		int counter;

		//Construction to take count parameter (from the previous method) and set it equal to the counter variable
		public  CountDown(int counter){
			this.counter = counter;
		}
		//this method gets invoked every time the timer changes (every second)
		public void actionPerformed(ActionEvent tc){
			counter--;

			if(counter >= 0){
				timerLabel.setText("Start game in: " + counter);
			}
			else{
				timer.stop();							//stops timer once 5 seconds is over

				GameFrame game = new GameFrame();		//displays a screen with a randomly placed rectangle
				game.showGame();

			}
		}

	}

}
