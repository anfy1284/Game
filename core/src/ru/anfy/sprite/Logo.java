package ru.anfy.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.anfy.math.Rect;

public class Logo extends Sprite {

    final private float DEFAULT_VELOCITY = 0.06f;
    final private float DEFAULT_BRAKE = 0.8f;
    final private float DEFAULT_BRAKE_WAY = 1.0f;

    private Vector2 destination;
    private Vector2 way;

    private float velocity;
    private float brake;
    private float brakeWay;

    public Logo(TextureRegion region) {
        super(region);
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
        //тут пока не оптимизировано, потом перепишу
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

    }

    public Logo(TextureRegion region, float halfWidth, float halfHeight){
        super(region, halfWidth, halfHeight);

        //pos = new Vector2((float) x, (float) y);
        destination = new Vector2(0, 0);
        brake = DEFAULT_BRAKE;
        //this.batch = batch;
        //img = new Texture(imgName);
        way = new Vector2();
        brakeWay = DEFAULT_BRAKE_WAY;
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        calc();
    }

    @Override
    public void resize(Rect worldBounds) {
//        setHeightProportion(worldBounds.getHeight());
///        pos.set(worldBounds.pos);
    }
}

