package xyz.michaelzhao.typer.game;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.Timer;

public class WordAnimation {
    public Timer timer;
    public Text text;

    public WordAnimation(Timer timer, Text text) {
        this.timer = timer;
        this.text = text;
    }

    public void stop() {
        if (timer != null)
            timer.cancel();
        if (text != null)
            ((Pane) text.getParent()).getChildren().remove(text);
    }
}
