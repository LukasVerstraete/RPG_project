package com.rpgproject.controller.backup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.rpgproject.model.world.CameraObject;
import com.rpgproject.model.world.Player;

/**
 * Created by lukas on 8-12-2015.
 */
public class CameraController extends MoveController {

    private Player player;
    private float zoom;

    public CameraController(CameraObject camera, Player player, float speed, float zoom)
    {
        super(camera, speed);
        this.player = player;
        this.zoom = zoom;
    }

    private CameraObject getObject()
    {
        return (CameraObject) object;
    }

    @Override
    public void update(float delta) {
        follow();
        super.update(delta);
        setInBounds();
        syncCamera();
    }

    private void follow()
    {
        getObject().setPosition(player.getPosition());
    }

    private void setInBounds()
    {
        Rectangle bounds = getObject().getMapBounds();
        float halfWidth = bounds.getWidth() / 2;
        float halfHeight = bounds.getHeight() / 2;
        Vector2 position = getObject().getPosition();
        if(position.x - ((Gdx.graphics.getWidth() * zoom) / 2) < 0)
            position.x += ((Gdx.graphics.getWidth() * zoom) / 2) - position.x;
        if(position.x + ((Gdx.graphics.getWidth() * zoom) / 2) > bounds.getWidth())
            position.x -= (position.x + ((Gdx.graphics.getWidth() * zoom) / 2)) - bounds.getWidth();
        if(position.y - ((Gdx.graphics.getHeight() * zoom) / 2) < 0)
            position.y += ((Gdx.graphics.getHeight() * zoom) / 2) - position.y;
        if(position.y + ((Gdx.graphics.getHeight() * zoom) / 2) > bounds.getHeight())
            position.y -= (position.y + ((Gdx.graphics.getHeight() * zoom) / 2)) - bounds.getHeight();
        getObject().setPosition(position);
    }

    private void syncCamera()
    {
        getObject().getCamera().position.set(getObject().getX(), getObject().getY(), 0);
        getObject().getCamera().zoom = this.zoom;
    }

    public void setZoom(float zoom)
    {
        this.zoom = zoom;
    }
}
