package org.czocher.forest.componenets;

import com.artemis.Component;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position extends Component {
    private float x;
    private float y;
}
