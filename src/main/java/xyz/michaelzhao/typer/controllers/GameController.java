package xyz.michaelzhao.typer.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class GameController {

    @FXML
    public Text infoText;

    @FXML
    public TextField textInput;

    @FXML
    protected void onKeyPressed(KeyEvent e) {
        // If the user presses the enter or space key
        if (e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.SPACE) {
            // Submit word
            String text = textInput.getText();

            // Update message
            infoText.setText(text);

            // Clear the box
            textInput.setText("");
        }
    }
}
