package digiframe.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import digiframe.frames.Frame;
import digiframe.interactions.ChoosePathButton;
import digiframe.interactions.GoogleButton;
import digiframe.interactions.PathDisplayInput;
import digiframe.interactions.TimeIntervalInput;

public class PathSetupPanel extends JPanel {

    public PathSetupPanel(Frame frame) {
        setLayout(new GridLayout(2,1));
        setOpaque(false);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setOpaque(false);
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout());    
        middlePanel.setOpaque(false);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setOpaque(false);

        PathDisplayInput pathDisplayInput = new PathDisplayInput(null);
        ChoosePathButton choosePathButton = new ChoosePathButton(frame, pathDisplayInput);
        TimeIntervalInput timeIntervalInput = new TimeIntervalInput(choosePathButton);
        GoogleButton googleButton = new GoogleButton(frame);

        topPanel.add(choosePathButton);
        topPanel.add(timeIntervalInput);
        middlePanel.add(googleButton);
        bottomPanel.add(pathDisplayInput);

        add(topPanel);
        add(middlePanel);
        add(bottomPanel);

        Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
        setBorder(border);
    }
}
