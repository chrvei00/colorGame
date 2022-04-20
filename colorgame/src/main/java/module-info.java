module colorgame {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens colorgame to javafx.fxml;
    exports colorgame;
}
