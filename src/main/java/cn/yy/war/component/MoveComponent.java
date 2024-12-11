package cn.yy.war.component;

import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;

public class MoveComponent extends Component {
    private double speedX = 0;
    private double speedY = 0;
    private double maxSpeed = 4;

    @Override
    public void onUpdate(double tpf) {
        if (speedX != 0d) {
            Vec2 dir = Vec2.fromAngle(entity.getRotation() - 360)
                    .mulLocal(speedX);
            entity.translate(dir);
        }
        if (speedY != 0d) {
            Vec2 dir = Vec2.fromAngle(entity.getRotation() - 90)
                    .mulLocal(speedY);
            entity.translate(dir);
        }
    }

    public void bindInput() {
        bindY("up", maxSpeed, KeyCode.W);
        bindY("down", -maxSpeed, KeyCode.S);
        bindX("left", -maxSpeed, KeyCode.A);
        bindX("right", maxSpeed, KeyCode.D);
    }

    private void bindX(String action, double speed, KeyCode code) {
        FXGL.getInput().addAction(new UserAction(action) {
            @Override
            protected void onActionBegin() {
                speedX = speed;
            }

            @Override
            protected void onActionEnd() {
                speedX = 0;
            }
        }, code);
    }

    private void bindY(String action, double speed, KeyCode code) {
        FXGL.getInput().addAction(new UserAction(action) {
            @Override
            protected void onActionBegin() {
                speedY = speed;
            }

            @Override
            protected void onActionEnd() {
                speedY = 0;
            }
        }, code);
    }
}
