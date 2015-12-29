package com.rpgproject.controller.newControllers;

import com.rpgproject.model.world.World;
import com.rpgproject.model.world.actions.Action;

/**
 * Created by lukas on 21-12-2015.
 */
public class ActionController {

    private boolean perform = false;

    public void update(float delta, World world, GameController controller)
    {
        if(perform)
        {
            for (Action action : world.getActions())
                action.perform(controller);
        }
        perform = false;
        world.clearActions();
    }

    public void perform()
    {
        perform = true;
    }
}
