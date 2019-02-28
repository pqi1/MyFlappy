package com.qi.flappy.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {
    public static final int TUBE_WIDTH = 52;
    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 120;
    private Texture topTube, botTube;
    private Vector2 posTopTube, posBotTube;
    private Rectangle boundsTop, boundsBot;
    private Rectangle scoreBox;
    public Texture scoreTexture;
    public Vector2 posScore;
    private static int cishu = 0;

    private Random rand;

    public Tube(float x){
        topTube = new Texture("toptube.png");
        botTube = new Texture("bottomtube.png");
        rand = new Random();

        posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x, posTopTube.y -  TUBE_GAP - botTube.getHeight());

        boundsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBot = new Rectangle(posBotTube.x, posBotTube.y, botTube.getWidth(), botTube.getHeight());

        //scoreTexture = new Texture("playbtn.png");
        posScore = new Vector2(x, posTopTube.y - TUBE_GAP);
        scoreBox = new Rectangle(posScore.x, posScore.y, topTube.getWidth(),TUBE_GAP);
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBotTube() {
        return botTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public void reposition(float x){
        posTopTube.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x, posTopTube.y -  TUBE_GAP - botTube.getHeight());

        boundsTop.setPosition(posTopTube.x,posTopTube.y);
        boundsBot.setPosition(posBotTube.x,posBotTube.y);

        posScore.set(x, posTopTube.y - TUBE_GAP);
        scoreBox.setPosition(posScore.x, posScore.y);
    }

    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }

    public boolean getScore(Rectangle player){
        cishu++;
        System.out.println(cishu);
        if(player.x > scoreBox.x && player.x < (scoreBox.x + scoreBox.getWidth()) && player.y > scoreBox.y && player.y < (scoreBox.y + TUBE_GAP) ){
            return true;
        }

        return false;
        //return player.overlaps(scoreBox);
    }

    public void dispose(){
        topTube.dispose();
        botTube.dispose();
    }

}
