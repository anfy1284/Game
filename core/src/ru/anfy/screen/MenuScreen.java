package ru.anfy.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import ru.anfy.Sprite.Sprite;
import ru.anfy.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Sprite playerSprite;
    private Texture backGround;

    private ArrayList<Sprite> sprites;

    @Override
    public void render(float delta) {
        super.render(delta);

        batch.begin();
        batch.draw(backGround, 0, 0);

        for (Sprite spr: sprites) {
            spr.draw();
        }

        batch.end();
    }

    @Override
    public void show() {
        super.show();
        playerSprite = new Sprite(batch, 100,100,"badlogic.jpg");
        sprites = new ArrayList<>();
        sprites.add(playerSprite);

        backGround = new Texture("spaceBackGround.jpg");
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        playerSprite.setDestination(screenX, Gdx.graphics.getHeight() - screenY);
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
