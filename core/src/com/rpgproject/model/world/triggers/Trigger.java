package com.rpgproject.model.world.triggers;

import com.badlogic.gdx.math.Rectangle;
import com.rpgproject.model.world.Player;
import com.rpgproject.model.world.World;

/**
 * Created by Lukas on 15-12-2015.
 */
public abstract class Trigger {

    private Rectangle actionField;

    public Trigger(Rectangle actionField)
    {
        this.actionField = actionField;
    }

    public abstract void act(float delta, World world);

    public boolean checkCollision(Rectangle testRect)
    {
        return actionField.overlaps(testRect);
    }
}
