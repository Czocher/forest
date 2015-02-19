package org.czocher.forest.componenets;

import com.artemis.Component;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Graphics extends Component {
    private TextureRegion textureRegion;
}
