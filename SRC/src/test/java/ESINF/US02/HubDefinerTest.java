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
    String influenceResult = hubDefiner.hubsByInfluence(3);
    String proximityResult = hubDefiner.hubsByProximity(3);
    @Test
    void hubsByInfluence() {

        String expectedInfuence =   "| Local  |        Influencia        |\n"+
                "|--------|--------------------------|\n"+
                "|    CT5 |                        5 |\n"+
                "|   CT10 |                        5 |\n"+
                "|   CT16 |                        5 |\n";
        assertEquals(influenceResult, expectedInfuence);

    }

    @Test
    void hubsByProximity() {

        String expectedProximity =      "| Local  |    Proximidade           |\n"+
                "|--------|--------------------------|\n"+
                "|    CT8 |                   166331 |\n"+
                "|    CT4 |                   143294 |\n"+
                "|   CT14 |                   127060 |\n";
        assertEquals(proximityResult, expectedProximity);

    }
}