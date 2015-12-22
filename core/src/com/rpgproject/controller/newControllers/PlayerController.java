package com.rpgproject.controller.newControllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.rpgproject.model.world.Animator;
import com.rpgproject.model.world.Player;
import com.rpgproject.model.world.World;
import com.rpgproject.resources.Resources;

/**
 * Created by Lukas on 13-12-2015.
 */
public class PlayerController {

    private Sound walkingSound;
    private boolean playing = false;

    public PlayerController()
    {
        walkingSound = Gdx.audio.newSound(Resources.getFile("walkSound"));
        long id = walkingSound.play();
        walkingSound.setLooping(id, true);
        walkingSound.setPitch(id, 2.0f);
        walkingSound.stop();
    }

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
        }
        setAnimatorAndSound(player);
    }

    private void setAnimatorAndSound(Player player)
    {
        if(player.getDirection().len() != 0)
        {
            player.setState(Animator.State.RUNNING);
            if(!playing) {
                walkingSound.play();
                playing = true;
            }
        }
        else
        {
            player.setState(Animator.State.IDLE);
            walkingSound.stop();
            playing = false;
        }
        if(player.getDirection().y == 1)
            player.setDirection(3);
        if(player.getDirection().x == -1)
            player.setDirection(2);
        if(player.getDirection().y == -1)
            player.setDirection(1);
        if(player.getDirection().x == 1)
            player.setDirection(4);
    }
}
