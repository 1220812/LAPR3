package ESINF.Structure.Auxiliary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Segment<V> {
    private V origin;
    private V destination;
    private double distance;

}

