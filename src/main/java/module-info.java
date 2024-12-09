module cn.yy.war {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens cn.yy.war to javafx.fxml;
    exports cn.yy.war;
}