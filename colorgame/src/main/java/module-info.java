module colorgame {
    requires javafx.controls;
    requires javafx.fxml;

    opens colorgame to javafx.fxml;
    exports colorgame;
}
