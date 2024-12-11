package cn.yy.war.entity;

import cn.yy.war.component.MoveComponent;
import cn.yy.war.enm.WarEnum;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class WarEntityFactory implements EntityFactory {
    @Spawns("player")
    public Entity createPlayer(SpawnData data) {
        // 创建实体
        MoveComponent moveComponent = new MoveComponent();
        moveComponent.bindInput();
        return entityBuilder(data)
                .type(WarEnum.Player)
                .viewWithBBox("player.png")
                .with(new CollidableComponent(true))
                .with(moveComponent)
                .build();
    }
}
