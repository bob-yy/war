package cn.yy.war.ui;

import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MainUi {
    public static void addUi() {
        //创建大小为50 50 的矩形
        Rectangle rectangle = new Rectangle(50, 50);
        //填充矩形 使用刚才的图片
        rectangle.setFill(Color.RED);
        //添加到ui节点中，同时设置节点位置
        FXGL.addUINode(rectangle, 900, 20);

        Text score = FXGL.getUIFactoryService().newText(FXGL.getip("score").asString());
        score.setFill(Color.BLUE);
        //添加到ui控件中
        FXGL.addUINode(score, 900, 200);
    }
}
