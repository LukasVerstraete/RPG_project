package com.rpgproject.controller.newControllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.rpgproject.model.world.Animator;
import com.rpgproject.model.world.Player;
import com.rpgproject.model.world.World;

/**
 * Created by Lukas on 13-12-2015.
 */
public class PlayerController {

    public void update(float delta, World world)
    {
        move(delta, world);
    }

    private void move(float delta, World world)
    {
        Player player = world.getPlayer();
        player.getDirection().nor();
        Vector2 oldPosition = new Vector2(player.getPosition());
        float distance = delta * player.getSpeed();
        Vector2 copy_dir = new Vector2(player.getDirection());
        Vector2 newPosition = oldPosition.mulAdd(copy_dir, distance);
        Rectangle predictedRect = player.getBoundingBox();
        predictedRect.setPosition(newPosition);
        if(!world.checkCollision(predictedRect))
        {
            player.setPosition(newPosition);
            syncSprite(player);
        }
        setAnimator(player);
    }

    private void setAnimator(Player player)
    {
        if(player.getDirection().len() != 0)
            player.setState(Animator.State.RUNNING);
        else
            player.setState(Animator.State.IDLE);
        if(player.getDirection().y == 1)
            player.setDirection(3);
        if(player.getDirection().x == -1)
            player.setDirection(2);
        if(player.getDirection().y == -1)
            player.setDirection(1);
        if(player.getDirection().x == 1)
            player.setDirection(4);
    }

    private void syncSprite(Player player)
    {
        player.getSprite().setPosition(player.getX(), player.getY());
    }
}
