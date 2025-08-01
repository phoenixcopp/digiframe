package digiframe.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import digiframe.panels.FrameSetupContainer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class AppWindow {

    JFrame frame = new JFrame();

    public AppWindow() {
        // Initialize the application window
        frame.setTitle("DigiFrame");
        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.WHITE);
        
        // Create the main panel with two FrameSetupContainers side by sid
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(1100,700));
        mainPanel.setLayout(new GridLayout(1, 2));
        mainPanel.add(new FrameSetupContainer());
        mainPanel.add(new FrameSetupContainer());
        
        // Layout for the main frame
        frame.setLayout(new FlowLayout());
        frame.add(mainPanel);
    }

    public void show() {
        frame.setVisible(true);
    }
}