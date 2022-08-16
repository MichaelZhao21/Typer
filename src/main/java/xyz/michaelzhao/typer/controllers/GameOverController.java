package xyz.michaelzhao.typer.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import xyz.michaelzhao.typer.game.TyperGame;
import xyz.michaelzhao.typer.util.StageChanger;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class GameOverController {
    @FXML
    public Button restartButton;

    @FXML
    private Text gameOverText;

    @FXML
    public Text scoreText;

    public TyperGame game;

    @FXML
    protected void onRestartButtonClick() throws IOException {
        // When the start button is clicked, go to the game view
        StageChanger.change(gameOverText, "game-view.fxml", 1000, 800, "Typer [In Game]");
    }

    protected void transferData(TyperGame game) {
        // Set the game to an instance variable
        this.game = game;

        // Get the score from the game
        scoreText.setText("Score: " + game.getScore());

        // Enable the "restart" button after 1 second
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> restartButton.setDisable(false));
            }
        }, 1000);
    }
}
