package com.tetros.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.tetros.game.Tetris;


public class MainMenuScreen implements Screen {
    Tetris tetris;
    Stage stage;
    Skin skin;
    private int buttonOffset = 20;

    //Constructor for the Main Menu
    public MainMenuScreen(Tetris tetris){
        this.tetris = tetris;
        stage = new Stage();
        skin = new Skin();
        createSkin(skin);
        Gdx.input.setInputProcessor(stage);

        //EXAMPLE BUTTON
        TextButton newGameButton = new TextButton("Start game", skin);// testBtn init with the create skin
        newGameButton.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 2
            + (newGameButton.getHeight() + buttonOffset));
        newGameButton.addListener(new ClickListener(){
           @Override
           public void clicked(InputEvent event, float x , float y){
               //todo start a new game
               System.out.println("new game button click");
           }
        });
        stage.addActor(newGameButton);

        TextButton settingsButton = new TextButton("Settings", skin);
        settingsButton.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 2);
        settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //todo exit game
                System.out.println("Settings button click");
            }
        });
        stage.addActor(settingsButton);

        TextButton exitButton = new TextButton("Exit", skin);
        exitButton.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, settingsButton.getY()-buttonOffset * 5);
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //todo exit game
                System.out.println("exitBtn click");
            }
        });
        stage.addActor(exitButton);



    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act();
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

    //COPIED SKIN CREATING METHOD
    public void createSkin(Skin skin){
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        Pixmap pixmap = new Pixmap((int)Gdx.graphics.getWidth()/4,(int)Gdx.graphics.getHeight()/10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("background",new Texture(pixmap));

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
        textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);
    }
}
