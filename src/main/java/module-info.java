module xyz.michaelzhao.typer {
    requires javafx.controls;
    requires javafx.fxml;


    opens xyz.michaelzhao.typer to javafx.fxml;
    exports xyz.michaelzhao.typer;
    exports xyz.michaelzhao.typer.controllers;
    opens xyz.michaelzhao.typer.controllers to javafx.fxml;
}