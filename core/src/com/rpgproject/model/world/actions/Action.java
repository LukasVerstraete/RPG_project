package com.rpgproject.model.world.actions;

import com.rpgproject.controller.newControllers.GameController;

/**
 * Created by lukas on 21-12-2015.
 */
public abstract class Action {

    public Action()
    {

    }

    public abstract void perform(GameController controller);
}
