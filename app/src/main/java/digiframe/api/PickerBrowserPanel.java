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

    /* private String getPickerHtml(String oauthToken, String apiKey) {
        return """
        <html>
        <head>
        <script type="text/javascript">
        function onApiLoad() {
          gapi.load('picker', {'callback': onPickerApiLoad});
        }
        function onPickerApiLoad() {
          var picker = new google.picker.PickerBuilder()
            .addView(google.picker.ViewId.DOCS)
            .setOAuthToken('""" + oauthToken + """')
            .setDeveloperKey('""" + apiKey + ""')
            .setCallback(pickerCallback)
            .build();
          picker.setVisible(true);
        }
        function pickerCallback(data) {
          if (data.action == google.picker.Action.PICKED) {
            var fileId = data.docs[0].id;
            alert("Picked file ID: " + fileId);
            // TODO: communicate with Java via bridge if needed
          }
        }
        </script>
        <script src="https://apis.google.com/js/api.js?onload=onApiLoad"></script>
        </head>
        <body></body>
        </html>
        """;
    } */
}
