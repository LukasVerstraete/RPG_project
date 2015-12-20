package com.rpgproject.controller.newControllers;

import com.rpgproject.model.world.World;
import com.rpgproject.model.world.triggers.Trigger;

/**
 * Created by lukas on 20-12-2015.
 */
public class TriggerController {

    public TriggerController()
    {

    }

    public void update(float delta, World world)
    {
        for(Trigger trigger : world.getCurrentMap().getTriggers())
        {
            if(trigger.checkCollision(world.getPlayer().getBoundingBox()))
                trigger.act(delta, world);
        }
    }

}
