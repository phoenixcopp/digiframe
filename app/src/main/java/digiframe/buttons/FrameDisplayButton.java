package digiframe.buttons;

import javax.swing.JButton;

import digiframe.frames.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameDisplayButton extends JButton implements ActionListener {
    private final Frame frame;

    public FrameDisplayButton(Frame frame) {
        super("Add Frame");
        this.frame = frame;
        setBounds(100, 160, 200, 40);
        setFocusable(false);
        addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Toggle the frame display
        if (getText().equals("Add Frame") ) {
            frame.display();  
            setText("Close Frame");      
        } else {
            frame.close();
            setText("Add Frame");
        }
    }
}
