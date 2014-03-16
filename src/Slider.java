import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Slider extends JPanel{
	private JSlider slider;
	private JLabel label;
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
		
		label = new JLabel("Slide to Change Level.\nCurrent Level: Easy");
		label.setAlignmentX (Component.CENTER_ALIGNMENT);
		
		panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		
		Button pushButton = new Button();
		
		panel.add(pushButton);
		panel.add(label);
		panel.add(slider);
		
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
				label.setText("Slide to Change Level.\nCurrent Level: " + showLevel);
			}
			else if(level == 2){
				showLevel = "Medium";
				label.setText("Slide to Change Level.\nCurrent Level: " + showLevel);
			}
			if(level == 3){
				showLevel = "Hard";
				label.setText("Slide to Change Level.\nCurrent Level: " + showLevel);
			}
			
		}
/*
		public void addChangeListener(SliderListener listener) {
			level = slider.getValue();
			
			if(level == 1){
				showLevel = "Easy";
				label.setText("Level: " + showLevel);
			}
			else if(level == 2){
				showLevel = "Medium";
				label.setText("Level: " + showLevel);
			}
			if(level == 3){
				showLevel = "Hard";
				label.setText("Level: " + showLevel);
			}
			
		}
*/		
		
	}

}
