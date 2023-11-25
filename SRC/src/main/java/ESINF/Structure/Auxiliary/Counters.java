package ESINF.Structure.Auxiliary;




import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Counters {

    private int counter = 0;

    public void increment(){
        counter++;
    }

}
