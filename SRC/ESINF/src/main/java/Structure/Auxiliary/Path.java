package Structure.Auxiliary;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.text.Segment;
import java.util.List;

@AllArgsConstructor
@Getter
public class Path<V> {
    private V origin;
    private V destination;

    private List<Structure.Auxiliary.Segment<V>> path;
}

