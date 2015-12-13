package com.rpgproject.controller.backup;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rpgproject.model.world.CameraObject;
import com.rpgproject.model.world.Player;
import com.rpgproject.model.world.World;

/**
 * Created by lukas on 8-12-2015.
 */
public class GameController {

    private World world;
    private WorldRenderer worldRenderer;

    private CameraObject camera;
    private MoveController cameraMovementController;

    private Player player;
    private PlayerController playerController;

    public GameController()
    {

        player = new Player();
        playerController = new PlayerController(player, 100f);
        player.addController(playerController);

        camera = new CameraObject(0, 0);
        cameraMovementController = new CameraController(camera, player, 100f, 0.3f);
        camera.addController(cameraMovementController);

        world = new World(player);
        worldRenderer = new WorldRenderer(world, camera);
        world.addController(worldRenderer);

        camera.setMapBounds(world.getCurrentMap());

        world.addChild(camera);
        world.addChild(player);
    }

    public void updateWorld(float delta)
    {
        world.update(delta);
    }

    public void drawWorld(SpriteBatch batch)
    {
        world.draw(batch);
    }
}
