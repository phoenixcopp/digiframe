package digiframe.interactions;

import javax.swing.JTextField;

public class TimeIntervalInput extends JTextField {
    private final ChoosePathButton choosePathButton;

    public TimeIntervalInput(ChoosePathButton choosePathButton) {
        super("3"); // Default delay in milliseconds
        this.choosePathButton = choosePathButton;
        setBounds(100, 220, 200, 40);
        setFocusable(true);
        
        // Add an action listener to handle delay changes
        addActionListener(e -> {
            try {
                int newDelay = Integer.parseInt(getText());
                if (newDelay >= 1 && newDelay <= 300) { // Validate delay
                    choosePathButton.delay = newDelay * 1000;
                    if (choosePathButton.slideshowTimer != null) {
                        choosePathButton.startSlideshow(); // Restart slideshow with new delay
                    }
                } else {
                    setText("3"); // Reset to default if invalid input
                }
            } catch (NumberFormatException ex) {
                setText("3"); // Reset to default on error
            }
        });
    }
    
}
