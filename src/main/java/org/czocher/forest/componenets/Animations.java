package org.czocher.forest.componenets;

import com.artemis.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Data;

@Data
public class Animations extends Component {
    private final Animation moveDownAnimation;
    private final Animation moveLeftAnimation;
    private final Animation moveRightAnimation;
    private final Animation moveUpAnimation;
    private final TextureRegion[][] animationSheet;

    public Animations(TextureRegion[][] animationSheet, float animationSpeed) {
        this.animationSheet = animationSheet;
        this.moveDownAnimation = new Animation(animationSpeed, animationSheet[0]);
        this.moveLeftAnimation = new Animation(animationSpeed, animationSheet[1]);
        this.moveRightAnimation = new Animation(animationSpeed, animationSheet[2]);
        this.moveUpAnimation = new Animation(animationSpeed, animationSheet[3]);
    }
}
