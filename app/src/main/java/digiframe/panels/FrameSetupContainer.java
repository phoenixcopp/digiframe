package digiframe.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

import digiframe.buttons.ChoosePathButton;
import digiframe.buttons.FrameDisplayButton;
import digiframe.frames.Frame;

import javax.swing.BorderFactory;

public class FrameSetupContainer extends JPanel {
    boolean frameExists = false;

    public FrameSetupContainer() {
        // Initialize the frame object
        Frame frame = new Frame();

        // Initialize the container for frame setup components
        setSize(475, 700);
        setBackground(Color.LIGHT_GRAY);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3, true);
        setBorder(border);
        setLayout(new GridBagLayout());

        // Bottom panel (20%)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.GRAY);
        bottomPanel.setLayout(new FlowLayout());
        FrameDisplayPanel frameDisplayPanel = new FrameDisplayPanel(frame.getFrameDisplayButton());
        bottomPanel.add(frameDisplayPanel);

        // Top panel (80%)
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setLayout(new GridLayout(4, 2)); // 2x2 grid for components
        PathSetupPanel pathSetupPanel = new PathSetupPanel(frame.getChoosePathButton());
        topPanel.add(pathSetupPanel);


        JPanel aspectRatioSetup = new JPanel();
        JPanel frameSizeSetup = new JPanel();
        JPanel borderSetup = new JPanel();
        

        topPanel.add(aspectRatioSetup);
        topPanel.add(frameSizeSetup);
        topPanel.add(borderSetup);
       
        
        // Set layout for the container
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        // Top panel (80%)
        gbc.gridy = 0;
        gbc.weighty = 0.8;
        add(topPanel, gbc);

        // Bottom panel (20%)
        gbc.gridy = 1;
        gbc.weighty = 0.2;
        add(bottomPanel, gbc);
    }
}
