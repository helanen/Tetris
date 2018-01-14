package com.tetros.game.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tetros.game.Tetris;

public class MainGameScreen implements Screen {
    SpriteBatch batch = new SpriteBatch();

    OrthographicCamera cam;
    Sprite mm_sprite;

    Tetris tetris;

    public MainGameScreen(Tetris tetris){
        this.tetris = tetris;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
