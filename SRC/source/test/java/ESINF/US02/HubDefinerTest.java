package ESINF.US02;

import ESINF.Domain.Locality;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;
import org.junit.jupiter.api.Test;

class HubDefinerTest {

    NetworkBuilder networkBuilder = NetworkBuilder.getInstance();
    MapGraph<Locality, Integer> mapGraph = networkBuilder.getDistribution();
    HubDefiner hubDefiner = new HubDefiner();
/*
    @Test
    void hubsByInfluence() {

        String influenceResult = hubDefiner.hubsByInfluence(3);
        System.out.println(influenceResult);

    }

    @Test
    void hubsByProximity() {
    }
    */
}