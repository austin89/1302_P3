import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Countdown extends JPanel{
	private static final String INTRO = "intro";
	private static final String USED_BEFORE = "used before";
	private CardLayout cardLayout = new CardLayout();
	private JLabel countDownLabel = new JLabel("", SwingConstants.CENTER);
	private JPanel introSouthPanel, introPanel, usedBeforePanel;

	public Countdown() {
		introSouthPanel = new JPanel();
		introSouthPanel.add(countDownLabel);

		introPanel = new JPanel();
		//introPanel.setPreferredSize(new Dimension(400, 100));
		introPanel.setLayout(new BorderLayout());
		introPanel.add(new JLabel("Countdown", SwingConstants.CENTER), BorderLayout.CENTER);
		introPanel.add(introSouthPanel, BorderLayout.SOUTH);

		//displays this JPanel after the countdown timer ends
		usedBeforePanel = new JPanel(new BorderLayout());
		usedBeforePanel.setBackground(Color.LIGHT_GRAY);
		usedBeforePanel.add(new JLabel("Used Before", SwingConstants.CENTER));

		setLayout(cardLayout);
		add(introPanel, INTRO);
		add(usedBeforePanel, USED_BEFORE);

		new HurdlerTimer(this).start();
	}

	public void createAndShowUI() {
		JFrame frame = new JFrame("Countdown");
		frame.getContentPane().add(new Countdown());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
/*
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				createAndShowUI();
			}
		});
	}
*/
	
	public void setCountDownLabelText(String text) {
		countDownLabel.setText(text);
	}

	public void showNextPanel() {
		cardLayout.next(this);
	}
}


class HurdlerTimer {
	private static final int TIMER_PERIOD = 1000;
	protected static final int MAX_COUNT = 5;
	private Countdown countdown; // holds a reference to the Countdown class
	private int count;

	public HurdlerTimer(Countdown Countdown) {
		this.countdown = Countdown; // initializes the reference to the Countdown class.
		String text = "Game starting in " + (MAX_COUNT - count) + " seconds...";
		Countdown.setCountDownLabelText(text);
	}

	public void start() {
		new Timer(TIMER_PERIOD, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (count < MAX_COUNT) {
					count++;
					String text = "Game starting in " + (MAX_COUNT - count) + " seconds...";
					countdown.setCountDownLabelText(text); // uses the reference to Countdown
				} else {
					((Timer) e.getSource()).stop();
					countdown.showNextPanel();
				}
			}
		}
				).start();
	}

}