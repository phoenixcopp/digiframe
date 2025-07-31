package digiframe.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

import digiframe.frames.Frame;

import javax.swing.JButton;

public class ChoosePathButton extends JButton implements ActionListener {
    private final Frame frame;

    public ChoosePathButton(Frame frame) {
        super("Choose Path");
        this.frame = frame;
        setBounds(100, 160, 200, 40);
        setFocusable(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedPath = getPath();
        if (selectedPath != null) {
            frame.setImageForNewPhoto(selectedPath); // Call a method on Frame to update the image
        }
    }

    public String getPath() {
        String filepath = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            filepath = selectedFile.getAbsolutePath();
        } else {
            System.out.println("No file selected");
        }

        return filepath;
    }
}
