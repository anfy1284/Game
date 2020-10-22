package ru.anfy.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.anfy.math.Rect;

public class BackGround extends Sprite {
    public BackGround(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }
}

