package ESINF.Structure.Auxiliary;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.text.Segment;
import java.util.List;

@AllArgsConstructor
@Getter
public class Path<V> {
    private V origin;
    private V destination;
    public Path(V origin, V destination){
        this.origin = origin;
        this.destination = destination;
    }

    public List<ESINF.Structure.Auxiliary.Segment<V>> getPath() {
        return path;
    }

    public V getDestination() {
        return destination;
    }

    public V getOrigin() {
        return origin;
    }

    private List<ESINF.Structure.Auxiliary.Segment<V>> path;
}

