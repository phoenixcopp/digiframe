package digiframe.frames;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import digiframe.panels.FrameSetupContainer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

public class AppWindow {

    JFrame frame = new JFrame();
        // Custom panel that paints the background image
    static class BackgroundPanel extends JPanel {
        private final Image backgroundImage;

        public BackgroundPanel() {
            Image img = null;
            try {
                img = ImageIO.read(getClass().getResource("/gradient-background.jpg"));
            } catch (IOException | IllegalArgumentException e) {
                System.out.println("Could not load background image: " + e.getMessage());
            }
            backgroundImage = img;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public AppWindow() {
        // Initialize the application window
        frame.setTitle("DigiFrame");
        frame.setSize(850, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        // Create the main panel with two FrameSetupContainers side by sid
        BackgroundPanel mainPanel = new BackgroundPanel();
        mainPanel.setPreferredSize(new Dimension(1100,700));
        mainPanel.setLayout(new GridLayout(1, 2, 40, 40)); // 20px horizontal gap, 0px vertical gap
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // 30px margin on all sides
        mainPanel.add(new FrameSetupContainer());
        mainPanel.add(new FrameSetupContainer());
        
        // Layout for the main frame
        frame.setContentPane(mainPanel);
    }

    public void show() {
        frame.setVisible(true);
    }
}