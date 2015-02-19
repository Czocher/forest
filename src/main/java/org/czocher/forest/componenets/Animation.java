package org.czocher.forest.componenets;

import com.artemis.Component;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Data;

@Data
public class Animation extends Component {
    private final com.badlogic.gdx.graphics.g2d.Animation moveDownAnimation;
    private final com.badlogic.gdx.graphics.g2d.Animation moveLeftAnimation;
    private final com.badlogic.gdx.graphics.g2d.Animation moveRightAnimation;
    private final com.badlogic.gdx.graphics.g2d.Animation moveUpAnimation;
    private final TextureRegion[][] animationSheet;

    public Animation(TextureRegion[][] animationSheet) {
        this.animationSheet = animationSheet;
        this.moveDownAnimation = new com.badlogic.gdx.graphics.g2d.Animation(0.20f, animationSheet[0]);
        this.moveLeftAnimation = new com.badlogic.gdx.graphics.g2d.Animation(0.20f, animationSheet[1]);
        this.moveRightAnimation = new com.badlogic.gdx.graphics.g2d.Animation(0.20f, animationSheet[2]);
        this.moveUpAnimation = new com.badlogic.gdx.graphics.g2d.Animation(0.20f, animationSheet[3]);
    }

}
