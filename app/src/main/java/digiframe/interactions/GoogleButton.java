package digiframe.interactions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import digiframe.api.PickerBrowserPanel;
import digiframe.frames.Frame;

public class GoogleButton extends JButton implements ActionListener{
    private final Frame frame;
    
    public GoogleButton(Frame frame) {
        super("Google");
        this.frame = frame;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PickerBrowserPanel browserPanel = new PickerBrowserPanel("YOUR_OAUTH_TOKEN", "YOUR_API_KEY");
        JFrame frame = new JFrame("Google Picker");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(900, 700);
        frame.add(browserPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
