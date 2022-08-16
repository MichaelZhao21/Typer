package xyz.michaelzhao.typer.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import xyz.michaelzhao.typer.MainApplication;

import java.io.IOException;

public class StageChanger {
    private StageChanger() {}

    /**
     * Changes the scene to the specified FXML file
     * @param node A node on the current page to fetch the window from
     * @param page The string name of the fxml file (eg. game-view.fxml)
     */
    public static <T> T change(Node node, String page) throws IOException {
        return change(node, page, 320, 240, "Typer");
    }

    /**
     * Changes the scene to the specified FXML file
     * @param node A node on the current page to fetch the window from
     * @param page The string name of the fxml file (eg. game-view.fxml)
     * @param width The width of the window
     * @param height The height of the window
     */
    public static <T> T change(Node node, String page, int width, int height) throws IOException {
        return change(node, page, width, height, "Typer");
    }

    /**
     * Changes the scene to the specified FXML file
     * @param node A node on the current page to fetch the window from
     * @param page The string name of the fxml file (eg. game-view.fxml)
     * @param width The width of the window
     * @param height The height of the window
     * @param title The title of the new window
     */
    public static <T> T change(Node node, String page, int width, int height, String title) throws IOException {
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(page));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        return fxmlLoader.getController();
    }
}
