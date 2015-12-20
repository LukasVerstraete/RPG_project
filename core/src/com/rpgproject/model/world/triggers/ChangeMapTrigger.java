package com.rpgproject.model.world.triggers;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.rpgproject.model.world.Player;
import com.rpgproject.model.world.World;
import com.rpgproject.model.world.WorldMap;

/**
 * Created by lukas on 20-12-2015.
 */
public class ChangeMapTrigger extends Trigger {

    private String target;
    private Vector2 targetPosition;

    public ChangeMapTrigger(Rectangle actionField, String target, float x, float y) {
        super(actionField);
        this.target = target;
        targetPosition = new Vector2(x, y);
    }

    @Override
    public void act(float delta, World world) {
        world.setCurrentMap(target);
        world.getPlayer().setPosition(targetPosition);
        System.out.println("acting");
    }
}
