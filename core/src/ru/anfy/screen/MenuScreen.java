package ru.anfy.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

import ru.anfy.sprite.Logo;
import ru.anfy.sprite.Sprite;
import ru.anfy.base.BaseScreen;
import ru.anfy.sprite.BackGround;
import ru.anfy.math.Rect;

public class MenuScreen extends BaseScreen {

    private Logo logo;
    private Texture backGroundTexture;
    private BackGround background;


    private ArrayList<Sprite> sprites;


    @Override
    public void render(float delta) {
        super.render(delta);

//        world.step(Gdx.graphics.getDeltaTime(), 6, 2);

        batch.begin();
        //batch.draw(backGround, 0, 0, 1f,1f);
        background.draw(batch);

        for (Sprite spr: sprites) {
            spr.draw(batch);
        }



        //playerSprite.setPosition(body.getPosition().x, body.getPosition().y);

        batch.end();
    }

    @Override
    public void show() {
        super.show();

        logo = new Logo(new TextureRegion(new Texture("badlogic.jpg")), 0.1f,0.1f);

        sprites = new ArrayList<>();
        sprites.add(logo);

        backGroundTexture = new Texture("spaceBackGround.jpg");
        background = new BackGround(new TextureRegion(backGroundTexture));

/*
        world = new World(new Vector2(0, -98f), true);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        bodyDef.position.set(playerSprite.getX(), playerSprite.getY());
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(playerSprite.getWidth()/2, playerSprite.getHeight()/2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        Fixture fixture = body.createFixture(fixtureDef);


        shape.dispose();

*/

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        logo.setDestination(screenX, Gdx.graphics.getHeight() - screenY);
//        return super.touchDown(screenX, screenY, pointer, button);
        super.touchDown(screenX, screenY, pointer, button);
        logo.setDestination(touch.x, touch.y);
        return false;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
