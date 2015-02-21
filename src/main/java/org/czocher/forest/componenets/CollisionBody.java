package org.czocher.forest.componenets;

import com.artemis.Component;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CollisionBody extends Component {
    private float width;
    private float height;
}
