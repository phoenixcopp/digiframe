package digiframe.interactions;

import javax.swing.JTextField;

public class TimeIntervalInput extends JTextField {
    private final ChoosePathButton choosePathButton;

    public TimeIntervalInput(ChoosePathButton choosePathButton) {
        super("3"); 
        this.choosePathButton = choosePathButton;
        setBounds(100, 220, 200, 40);
        setFocusable(true);
        
        addActionListener(e -> {
            try {
                int newDelay = Integer.parseInt(getText());
                if (newDelay >= 1 && newDelay <= 300) { 
                    choosePathButton.delay = newDelay * 1000;
                    if (choosePathButton.slideshowTimer != null) {
                        choosePathButton.startSlideshow(); 
                    }
                } else {
                    setText("3"); 
                }
            } catch (NumberFormatException ex) {
                setText("3"); 
            }
        });
    }  
}
