package sample;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class Controller {

    public TextField sndMsg;
    public Button btn;
    public TextArea chat;

    public void click(ActionEvent actionEvent) {
        chat.setText(chat.getText() + "\n" +  sndMsg.getText());
        sndMsg.setText("");
    }
}
