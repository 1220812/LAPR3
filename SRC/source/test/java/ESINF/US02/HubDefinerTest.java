package ESINF.US02;

import ESINF.Domain.Hub;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;
import ESINF.US02.HubDefiner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HubDefinerTest {

    NetworkBuilder networkBuilder = NetworkBuilder.getInstance();
    MapGraph<Hub, Integer> mapGraph = networkBuilder.getDistribution();
    HubDefiner hubDefiner = new HubDefiner();

    @Test
    void hubsByInfluence() {

        String influenceResult = hubDefiner.hubsByInfluence(3);
        System.out.println(influenceResult);

    }

    @Test
    void hubsByProximity() {
    }
}