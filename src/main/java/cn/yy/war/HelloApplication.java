package cn.yy.war;

import cn.yy.war.entity.WarEntityFactory;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;
import static com.almasb.fxgl.dsl.FXGLForKtKt.spawn;

public class HelloApplication extends GameApplication {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new WarEntityFactory());
        // 将玩家实体增加到游戏世界。
        spawn("player");
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1080);
        settings.setHeight(720);
        settings.setVersion("v1.0");
    }
}