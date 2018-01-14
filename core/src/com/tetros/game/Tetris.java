package com.tetros.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.tetros.game.Networking.Client;
import com.tetros.game.Screens.MainMenuScreen;

public class Tetris extends Game {
	private SpriteBatch batch;
	private OrthographicCamera camera; //camera
	private Client client;

	@Override
	public void create () {
	    Gdx.app.setLogLevel(Application.LOG_DEBUG);//Makes debugging visible in android Logcat
		batch = new SpriteBatch();
		/*camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480); // shows only 800/480 area of the "game world"*/
		client = new Client();
		client.connectSocket();
		client.configSocketEvents();
		this.setScreen(new MainMenuScreen(this));
		/*stage = new Stage();
		skin = new Skin();
		*/

	}

	@Override
	public void render () {
		/*Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
		*/
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
