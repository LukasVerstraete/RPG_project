package com.rpgproject.model.world.actions;

import com.rpgproject.controller.newControllers.GameController;

/**
 * Created by lukas on 21-12-2015.
 */
public class NextMessageAction extends Action {

    @Override
    public void perform(GameController controller) {
        controller.nextMessage();
    }
}
