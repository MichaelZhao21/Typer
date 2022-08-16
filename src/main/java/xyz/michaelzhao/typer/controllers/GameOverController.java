package xyz.michaelzhao.typer.controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import xyz.michaelzhao.typer.game.TyperGame;
import xyz.michaelzhao.typer.util.StageChanger;

import java.io.IOException;

public class GameOverController {
    @FXML
    private Text gameOverText;

    @FXML
    public Text scoreText;

    @FXML
    protected void onStartButtonClick() throws IOException {
        // When the start button is clicked, go to the game view
        StageChanger.change(gameOverText, "game-view.fxml", 1000, 800, "Typer [In Game]");
    }

    protected void transferData(TyperGame game) {
        scoreText.setText("Score: " + game.getScore());
    }
}
