package digiframe.api;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class PickerBrowserPanel extends JPanel {
    private JFXPanel jfxPanel;

    public PickerBrowserPanel(String oauthToken, String apiKey) {
        setLayout(new BorderLayout());
        jfxPanel = new JFXPanel();
        add(jfxPanel, BorderLayout.CENTER);

        Platform.runLater(() -> {
            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();
            webEngine.load("https://www.google.com"); // Or your desired URL
            jfxPanel.setScene(new Scene(webView));
        }); 
    }
}
