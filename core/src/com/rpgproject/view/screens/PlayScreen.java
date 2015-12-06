package com.rpgproject.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.rpgproject.RPGGame;
import com.rpgproject.view.buttons.MainMenuButton;

/**
 * Created by Lukas on 4-12-2015.
 */
public class PlayScreen extends GameScreen
{

    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    private OrthographicCamera camera;


    public PlayScreen(RPGGame game)
    {
        super(game);
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        map = new TmxMapLoader().load("maps/inkomhal.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);
        init();
    }

    public void init()
    {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(RPGGame.DEBUG);
        table.align(Align.center);

        MainMenuButton newGameButton = new MainMenuButton("New game");
        newGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.loadMainMenu();
            }
        });

        table.add(newGameButton).fill().width(250).height(50);

        stage.addActor(table);
    }

    @Override
    public void update(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            System.out.println("print");
            camera.translate(-5, 0);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            camera.translate(5, 0);
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            camera.translate(0, -5);
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            camera.translate(0, 5);
    }

    @Override
    public void draw() {
        camera.update();
        camera.zoom = 1f;
        mapRenderer.setView(camera);
        mapRenderer.render();
        stage.draw();
    }
}
