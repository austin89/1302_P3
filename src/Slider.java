import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Slider extends JPanel{
	private JSlider slider;
	private JLabel label, label1, label2, label3, levelLabel, space, space1;
	private JPanel panel;
	
	public Slider(){
		slider = new JSlider(JSlider.HORIZONTAL, 1 , 3, 1);		//sets the slider to be horizontal, with 3 tick marks, and the initial tick mark is set to 1
		slider.setMajorTickSpacing(1);							//sets frequency if tick marks to show
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setAlignmentX(Component.CENTER_ALIGNMENT);		//aligns slider to the center of the screen
		slider.setAlignmentY(Component.HEIGHT/2);
		
		SliderListener listener = new SliderListener();
		slider.addChangeListener(listener);
		
		label = new JLabel("Slide to Change Level.");
		label.setAlignmentX (Component.CENTER_ALIGNMENT);
		space = new JLabel("\n");
		label1 = new JLabel("1 = Easy");
		label1.setAlignmentX (Component.CENTER_ALIGNMENT);
		label2 = new JLabel("2 = Medium");
		label2.setAlignmentX (Component.CENTER_ALIGNMENT);
		label3 = new JLabel("3 = Difficult");
		label3.setAlignmentX (Component.CENTER_ALIGNMENT);
		space1 = new JLabel("\n");
		levelLabel = new JLabel("Current Level: Easy");
		levelLabel.setAlignmentX (Component.CENTER_ALIGNMENT);
		
		panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		
		Button pushButton = new Button();
		
		panel.add(label);
		panel.add(space);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(space1);
		panel.add(levelLabel);
		panel.add(slider);
		panel.add(pushButton);
		
		add(panel);
		
		setBackground(Color.LIGHT_GRAY);
		
	}
	
	private class SliderListener implements ChangeListener{
		private int level;
		private String showLevel;

		@Override
		public void stateChanged(ChangeEvent e) {
			level = slider.getValue();
			
			if(level == 1){
				showLevel = "Easy";
				levelLabel.setText("Current Level: " + showLevel);
			}
			else if(level == 2){
				showLevel = "Medium";
				levelLabel.setText("Current Level: " + showLevel);
			}
			if(level == 3){
				showLevel = "Hard";
				levelLabel.setText("Current Level: " + showLevel);
			}
			
		}
		
	}

}