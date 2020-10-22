package ru.anfy.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.anfy.math.Rect;

public class Sprite extends Rect {



    private SpriteBatch batch;
    private Texture img;



    protected float angle;
    protected float scale = 1;
    protected TextureRegion[] regions;
    protected int frame;

    public Sprite(TextureRegion region) {
        this.regions = new TextureRegion[1];
        regions[0] = region;
    }

    public void setHeightProportion(float height) {
        setHeight(height);
        float aspect = regions[frame].getRegionWidth() / (float) regions[frame].getRegionHeight();
        setWidth(height * aspect);
    }

    public Sprite(TextureRegion region, float halfWidth, float halfHeight){
        super(0, 0, halfWidth, halfHeight);

        this.regions = new TextureRegion[1];
        regions[0] = region;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }




/*
    public void draw(){
        //batch.draw(img, pos.x, pos.y, 0.1f, 0.1f);
        batch.draw(img, 0, 0, 0.1f, 0.1f);
        calc();
    }
*/
    public void draw(SpriteBatch batch) {
        batch.draw(
                regions[frame],
                getLeft(), getBottom(),
                halfWidth, halfHeight,
                getWidth(), getHeight(),
                scale, scale,
                angle
        );
    }
    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void resize(Rect worldBounds) {

    }
}
