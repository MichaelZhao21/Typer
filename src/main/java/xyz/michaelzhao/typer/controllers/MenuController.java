package xyz.michaelzhao.typer.controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import xyz.michaelzhao.typer.util.StageChanger;

import java.io.IOException;

public class MenuController {
    @FXML
    private Text welcomeText;

    @FXML
    protected void onStartButtonClick() throws IOException {
        // When the start button is clicked, go to the game view
        StageChanger.change(welcomeText, "game-view.fxml", 1000, 800, "Typer [In Game]");
    }
}
