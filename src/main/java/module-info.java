module com.example.thepokergame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.thepokergame to javafx.fxml;
    exports com.example.thepokergame;
}