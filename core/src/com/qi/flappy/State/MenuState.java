package com.qi.flappy.State;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.qi.flappy.MyFlappy;

public class MenuState extends State {
    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    //spritebatch like a box, open-->put-->close
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0 ,0, MyFlappy.WIDTH, MyFlappy.HEIGHT);
        sb.draw(playBtn, (MyFlappy.WIDTH / 2) - (playBtn.getWidth() / 2), (MyFlappy.HEIGHT / 2) - (playBtn.getHeight() / 2));
        sb.end();
    }
}
