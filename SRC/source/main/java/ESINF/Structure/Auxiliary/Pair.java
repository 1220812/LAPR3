package ESINF.Structure.Auxiliary;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Pair <F,S>{
    private F first;
    private S second;
}
