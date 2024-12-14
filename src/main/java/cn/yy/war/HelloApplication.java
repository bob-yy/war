package cn.yy.war;

import cn.yy.war.entity.WarEntityFactory;
import cn.yy.war.ui.MainUi;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

import java.util.Map;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;
import static com.almasb.fxgl.dsl.FXGLForKtKt.spawn;

public class HelloApplication extends GameApplication {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initInput() {
        super.initInput();
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("score", 10);
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new WarEntityFactory());
        MainUi.addUi();
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