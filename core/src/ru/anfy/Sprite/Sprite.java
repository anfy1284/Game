package ru.anfy.Sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Sprite {
    final private float DEFAULT_VELOCITY = 20f;
    final private float DEFAULT_BRAKE = 0.8f;
    final private float DEFAULT_BRAKE_WAY = 3f;

    private Vector2 pos;
    private Vector2 destination;
    private Vector2 way;
    private SpriteBatch batch;
    private Texture img;

    private float velocity;
    private float brake;
    private float brakeWay;


    public Sprite(SpriteBatch batch, int x, int y, String imgName){
        pos = new Vector2((float) x, (float) y);
        destination = new Vector2((float) x, (float) y);
        brake = DEFAULT_BRAKE;
        this.batch = batch;
        img = new Texture(imgName);
        way = new Vector2();
        brakeWay = DEFAULT_BRAKE_WAY;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public void setDestination(float x, float y) {
        destination.x = x;
        destination.y = y;
        velocity = DEFAULT_VELOCITY;
        setWay();
    }

    public void setWay(){
        way = new Vector2(destination).sub(pos).setLength(velocity);
    }

    private void calc(){
        if(way.isZero()) return;

        Vector2 newPos = new Vector2(pos);
        newPos.add(way);

        Vector2 newWay = new Vector2(destination).sub(newPos).nor();
        Vector2 oldWay = new Vector2(way).nor();
        if(oldWay.dot(newWay) < 0){
            velocity *= brake;
            way = oldWay.setLength(velocity * brakeWay);
            pos.add(way);
            way = newWay.setLength(velocity);
        }else{
            pos.add(way);
        }


/*
        if(pos.equals(destination)) return;
        Vector2 way = new Vector2(destination);
        way.sub(pos).setLength(velocity);
        pos.add(way);

 */
    }

    public void draw(){
        batch.draw(img, pos.x, pos.y);
        calc();
    }


}
