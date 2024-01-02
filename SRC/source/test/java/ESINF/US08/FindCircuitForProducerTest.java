package ESINF.US08;

import ESINF.Domain.Locality;
import ESINF.Domain.Trajetory;
import ESINF.FileReader.ReaderFiles;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindCircuitForProducerTest {

    private static NetworkBuilder networkBuilder;
    private static FindCircuitForProducer findCircuitProducer;
    private static ReaderFiles readerFiles;


    @BeforeAll
    static void setUp() throws IOException {


        String userDir = System.getProperty("user.dir");
        String basePath = userDir + "/SRC/source/main/resources/ESINF/";

        readerFiles.importLocalData(basePath + "locais_small.csv");
        readerFiles.importDistanceData(basePath + "distancias_small.csv", basePath + "locais_small.csv");


        networkBuilder = NetworkBuilder.getInstance();
        findCircuitProducer = new FindCircuitForProducer();
    }

    /**
     * First path.
     */
    @Test
    void firstPath() {
        MapGraph<Locality, Integer> graph = networkBuilder.getDistribution();

        Locality origin0 = graph.vertices().get(0);
        Locality origin1 = graph.vertices().get(1);
        Locality origin2 = graph.vertices().get(2);
        Locality origin3 = graph.vertices().get(3);
        Locality origin4 = graph.vertices().get(4);
        Locality origin5 = graph.vertices().get(5);
        Locality origin6 = graph.vertices().get(6);
        Locality origin7 = graph.vertices().get(7);
        Locality origin8 = graph.vertices().get(8);
        Locality origin9 = graph.vertices().get(9);
        Locality origin10 = graph.vertices().get(10);
        Locality origin11 = graph.vertices().get(11);
        Locality origin12 = graph.vertices().get(12);
        Locality origin13 = graph.vertices().get(13);
        Locality origin14 = graph.vertices().get(14);
        Locality origin15 = graph.vertices().get(15);
        Locality origin16 = graph.vertices().get(16);

        Locality firstEnd0 = findCircuitProducer.firstPath(origin0);
        Locality firstEnd1 = findCircuitProducer.firstPath(origin1);
        Locality firstEnd2 = findCircuitProducer.firstPath(origin2);
        Locality firstEnd3 = findCircuitProducer.firstPath(origin3);
        Locality firstEnd4 = findCircuitProducer.firstPath(origin4);
        Locality firstEnd5 = findCircuitProducer.firstPath(origin5);
        Locality firstEnd6 = findCircuitProducer.firstPath(origin6);
        Locality firstEnd7 = findCircuitProducer.firstPath(origin7);
        Locality firstEnd8 = findCircuitProducer.firstPath(origin8);
        Locality firstEnd9 = findCircuitProducer.firstPath(origin9);
        Locality firstEnd10 = findCircuitProducer.firstPath(origin10);
        Locality firstEnd11 = findCircuitProducer.firstPath(origin11);
        Locality firstEnd12 = findCircuitProducer.firstPath(origin12);
        Locality firstEnd13 = findCircuitProducer.firstPath(origin13);
        Locality firstEnd14 = findCircuitProducer.firstPath(origin14);
        Locality firstEnd15 = findCircuitProducer.firstPath(origin15);
        Locality firstEnd16 = findCircuitProducer.firstPath(origin16);

        assertEquals("CT3", firstEnd0.getName()); //Path when first Locality is CT1
        assertEquals("CT6", firstEnd1.getName()); //Path when first Locality is CT2
        assertEquals("CT11", firstEnd2.getName()); //Path when first Locality is CT3
        assertEquals("CT5", firstEnd3.getName()); //Path when first Locality is CT15
        assertEquals("CT3", firstEnd4.getName()); //Path when first Locality is CT16
        assertEquals("CT11", firstEnd5.getName()); //Path when first Locality is CT12
        assertEquals("CT6", firstEnd6.getName()); //Path when first Locality is CT7
        assertEquals("CT6", firstEnd7.getName()); //Path when first Locality is CT8
        assertEquals("CT6", firstEnd8.getName()); //Path when first Locality is CT13
        assertEquals("CT11", firstEnd9.getName()); //Path when first Locality is CT14
        assertEquals("CT11", firstEnd10.getName()); //Path when first Locality is CT11
        assertEquals("CT3", firstEnd11.getName()); //Path when first Locality is CT5
        assertEquals("CT3", firstEnd12.getName()); //Path when first Locality is CT9
        assertEquals("CT11", firstEnd13.getName()); //Path when first Locality is CT4
        assertEquals("CT11", firstEnd14.getName()); //Path when first Locality is CT17
        assertEquals("CT3", firstEnd15.getName()); //Path when first Locality is CT6
        assertEquals("CT11", firstEnd16.getName()); //Path when first Locality is CT10

    }

    @Test
    void secondPathSize() {
        MapGraph<Locality, Integer> graph = networkBuilder.getDistribution();

        Locality origin0 = graph.vertices().get(0); //Origin is CT1
        Locality origin1 = graph.vertices().get(1); //Origin is CT2
        Locality origin2 = graph.vertices().get(2); //Origin is CT3
        Locality origin3 = graph.vertices().get(3); //Origin is CT15
        Locality origin4 = graph.vertices().get(4); //Origin is CT16
        Locality origin5 = graph.vertices().get(5); //Origin is CT12
        Locality origin6 = graph.vertices().get(6); //Origin is CT7
        Locality origin7 = graph.vertices().get(7); //Origin is CT8
        Locality origin8 = graph.vertices().get(8); //Origin is CT13
        Locality origin9 = graph.vertices().get(9); //Origin is CT14
        Locality origin10 = graph.vertices().get(10); //Origin is CT11
        Locality origin11 = graph.vertices().get(11); //Origin is CT5
        Locality origin12 = graph.vertices().get(12); //Origin is CT9
        Locality origin13 = graph.vertices().get(13); //Origin is CT4
        Locality origin14 = graph.vertices().get(14); //Origin is CT17
        Locality origin15 = graph.vertices().get(15); //Origin is CT6
        Locality origin16 = graph.vertices().get(16); //Origin is CT10

        Locality end0 = graph.vertices().get(0); //End is CT1
        Locality end1 = graph.vertices().get(1); //End is CT2
        Locality end2 = graph.vertices().get(2); //End is CT3
        Locality end3 = graph.vertices().get(3); //End is CT15
        Locality end4 = graph.vertices().get(4); //End is CT16
        Locality end5 = graph.vertices().get(5); //End is CT12
        Locality end6 = graph.vertices().get(6); //End is CT7
        Locality end7 = graph.vertices().get(7); //End is CT8
        Locality end8 = graph.vertices().get(8); //End is CT13
        Locality end9 = graph.vertices().get(9); //End is CT14
        Locality end10 = graph.vertices().get(10); //End is CT11
        Locality end11 = graph.vertices().get(11); //End is CT5
        Locality end12 = graph.vertices().get(12); //End is CT9
        Locality end13 = graph.vertices().get(13); //End is CT4
        Locality end14 = graph.vertices().get(14); //End is CT17
        Locality end15 = graph.vertices().get(15); //End is CT6
        Locality end16 = graph.vertices().get(16); //End is CT10

        LinkedList<Trajetory> trajetory = findCircuitProducer.secondPath(origin0, end1);
        LinkedList<Trajetory> trajetory1 = findCircuitProducer.secondPath(origin1, end2);
        LinkedList<Trajetory> trajetory2 = findCircuitProducer.secondPath(origin2, end3);
        LinkedList<Trajetory> trajetory3 = findCircuitProducer.secondPath(origin3, end4);
        LinkedList<Trajetory> trajetory4 = findCircuitProducer.secondPath(origin4, end5);
        LinkedList<Trajetory> trajetory5 = findCircuitProducer.secondPath(origin5, end6);
        LinkedList<Trajetory> trajetory6 = findCircuitProducer.secondPath(origin6, end7);
        LinkedList<Trajetory> trajetory7 = findCircuitProducer.secondPath(origin7, end8);
        LinkedList<Trajetory> trajetory8 = findCircuitProducer.secondPath(origin8, end9);
        LinkedList<Trajetory> trajetory9 = findCircuitProducer.secondPath(origin9, end10);
        LinkedList<Trajetory> trajetory10 = findCircuitProducer.secondPath(origin10, end11);
        LinkedList<Trajetory> trajetory11 = findCircuitProducer.secondPath(origin11, end12);
        LinkedList<Trajetory> trajetory12 = findCircuitProducer.secondPath(origin12, end13);
        LinkedList<Trajetory> trajetory13 = findCircuitProducer.secondPath(origin13, end14);
        LinkedList<Trajetory> trajetory14 = findCircuitProducer.secondPath(origin14, end15);
        LinkedList<Trajetory> trajetory15 = findCircuitProducer.secondPath(origin15, end16);
        LinkedList<Trajetory> trajetory16 = findCircuitProducer.secondPath(origin16, end0);
        LinkedList<Trajetory> trajetory17 = findCircuitProducer.secondPath(origin16, end1);
        LinkedList<Trajetory> trajetory18 = findCircuitProducer.secondPath(origin16, end2);
        LinkedList<Trajetory> trajetory19 = findCircuitProducer.secondPath(origin16, end3);

        assertEquals(4, trajetory.size());
        assertEquals(6, trajetory1.size());
        assertEquals(1, trajetory2.size());
        assertEquals(2, trajetory3.size());
        assertEquals(1, trajetory4.size());
        assertEquals(4, trajetory5.size());
        assertEquals(2, trajetory6.size());
        assertEquals(2, trajetory7.size());
        assertEquals(1, trajetory8.size());
        assertEquals(2, trajetory9.size());
        assertEquals(1, trajetory10.size());
        assertEquals(1, trajetory11.size());
        assertEquals(1, trajetory12.size());
        assertEquals(2, trajetory13.size());
        assertEquals(1, trajetory14.size());
        assertEquals(1, trajetory15.size());
        assertEquals(1, trajetory16.size());
        assertEquals(3, trajetory17.size());
        assertEquals(3, trajetory18.size());
        assertEquals(3, trajetory19.size());
    }

    @Test
    void secondPathDestination() {
        MapGraph<Locality, Integer> graph = networkBuilder.getDistribution();

        Locality origin0 = graph.vertices().get(0); //Origin is CT1
        Locality origin1 = graph.vertices().get(1); //Origin is CT2
        Locality origin2 = graph.vertices().get(2); //Origin is CT3
        Locality origin3 = graph.vertices().get(3); //Origin is CT15
        Locality origin4 = graph.vertices().get(4); //Origin is CT16
        Locality origin5 = graph.vertices().get(5); //Origin is CT12
        Locality origin6 = graph.vertices().get(6); //Origin is CT7
        Locality origin7 = graph.vertices().get(7); //Origin is CT8
        Locality origin8 = graph.vertices().get(8); //Origin is CT13
        Locality origin9 = graph.vertices().get(9); //Origin is CT14
        Locality origin10 = graph.vertices().get(10); //Origin is CT11
        Locality origin11 = graph.vertices().get(11); //Origin is CT5
        Locality origin12 = graph.vertices().get(12); //Origin is CT9
        Locality origin13 = graph.vertices().get(13); //Origin is CT4
        Locality origin14 = graph.vertices().get(14); //Origin is CT17
        Locality origin15 = graph.vertices().get(15); //Origin is CT6
        Locality origin16 = graph.vertices().get(16); //Origin is CT10

        Locality end0 = graph.vertices().get(0); //End is CT1
        Locality end1 = graph.vertices().get(1); //End is CT2
        Locality end2 = graph.vertices().get(2); //End is CT3
        Locality end3 = graph.vertices().get(3); //End is CT15
        Locality end4 = graph.vertices().get(4); //End is CT16
        Locality end5 = graph.vertices().get(5); //End is CT12
        Locality end6 = graph.vertices().get(6); //End is CT7
        Locality end7 = graph.vertices().get(7); //End is CT8
        Locality end8 = graph.vertices().get(8); //End is CT13
        Locality end9 = graph.vertices().get(9); //End is CT14
        Locality end10 = graph.vertices().get(10); //End is CT11
        Locality end11 = graph.vertices().get(11); //End is CT5
        Locality end12 = graph.vertices().get(12); //End is CT9
        Locality end13 = graph.vertices().get(13); //End is CT4
        Locality end14 = graph.vertices().get(14); //End is CT17
        Locality end15 = graph.vertices().get(15); //End is CT6
        Locality end16 = graph.vertices().get(16); //End is CT10

        LinkedList<Trajetory> trajetory = findCircuitProducer.secondPath(origin0, end1);
        LinkedList<Trajetory> trajetory2 = findCircuitProducer.secondPath(origin1, end2);
        LinkedList<Trajetory> trajetory3 = findCircuitProducer.secondPath(origin2, end3);
        LinkedList<Trajetory> trajetory4 = findCircuitProducer.secondPath(origin3, end4);
        LinkedList<Trajetory> trajetory5 = findCircuitProducer.secondPath(origin4, end5);
        LinkedList<Trajetory> trajetory6 = findCircuitProducer.secondPath(origin5, end6);
        LinkedList<Trajetory> trajetory7 = findCircuitProducer.secondPath(origin6, end7);
        LinkedList<Trajetory> trajetory8 = findCircuitProducer.secondPath(origin7, end8);
        LinkedList<Trajetory> trajetory9 = findCircuitProducer.secondPath(origin8, end9);
        LinkedList<Trajetory> trajetory10 = findCircuitProducer.secondPath(origin9, end10);
        LinkedList<Trajetory> trajetory11 = findCircuitProducer.secondPath(origin10, end11);
        LinkedList<Trajetory> trajetory12 = findCircuitProducer.secondPath(origin11, end12);
        LinkedList<Trajetory> trajetory13 = findCircuitProducer.secondPath(origin13, end14);
        LinkedList<Trajetory> trajetory14 = findCircuitProducer.secondPath(origin15, end16);


        List<String> expectedDestination = List.of("CT10", "CT13", "CT7", "CT2");
        List<String> expectedDestination2 = List.of("CT7", "CT13", "CT10", "CT1", "CT12", "CT3");
        List<String> expectedDestination3 = List.of("CT15");
        List<String> expectedDestination4 = List.of("CT3", "CT16");
        List<String> expectedDestination5 = List.of("CT12");
        List<String> expectedDestination6 = List.of("CT1", "CT10", "CT13", "CT7");
        List<String> expectedDestination7 = List.of("CT2", "CT8");
        List<String> expectedDestination8 = List.of("CT14", "CT13");
        List<String> expectedDestination9 = List.of("CT14");
        List<String> expectedDestination10 = List.of("CT13", "CT11");
        List<String> expectedDestination11 = List.of("CT5");
        List<String> expectedDestination12 = List.of("CT9");
        List<String> expectedDestination13 = List.of("CT16", "CT17");
        List<String> expectedDestination14 = List.of("CT10");


        for (int i = 0; i < trajetory.size(); i++) {
            assertEquals(expectedDestination.get(i), trajetory.get(i).getDestination().getName());
        }
        for (int i = 0; i < trajetory2.size(); i++) {
            assertEquals(expectedDestination2.get(i), trajetory2.get(i).getDestination().getName());
        }
        for (int i = 0; i < trajetory3.size(); i++) {
            assertEquals(expectedDestination3.get(i), trajetory3.get(i).getDestination().getName());
        }
        for (int i = 0; i < trajetory4.size(); i++) {
            assertEquals(expectedDestination4.get(i), trajetory4.get(i).getDestination().getName());
        }
        for (int i = 0; i < trajetory5.size(); i++) {
            assertEquals(expectedDestination5.get(i), trajetory5.get(i).getDestination().getName());
        }
        for (int i = 0; i < trajetory6.size(); i++) {
            assertEquals(expectedDestination6.get(i), trajetory6.get(i).getDestination().getName());
        }
        for (int i = 0; i < trajetory7.size(); i++) {
            assertEquals(expectedDestination7.get(i), trajetory7.get(i).getDestination().getName());
        }
        for (int i = 0; i < trajetory8.size(); i++) {
            assertEquals(expectedDestination8.get(i), trajetory8.get(i).getDestination().getName());
        }
        for (int i = 0; i < trajetory9.size(); i++) {
            assertEquals(expectedDestination9.get(i), trajetory9.get(i).getDestination().getName());
        }
        for (int i = 0; i < trajetory10.size(); i++) {
            assertEquals(expectedDestination10.get(i), trajetory10.get(i).getDestination().getName());
        }
        for (int i = 0; i < trajetory11.size(); i++) {
            assertEquals(expectedDestination11.get(i), trajetory11.get(i).getDestination().getName());
        }
        for (int i = 0; i < trajetory12.size(); i++) {
            assertEquals(expectedDestination12.get(i), trajetory12.get(i).getDestination().getName());
        }
        for (int i = 0; i < trajetory13.size(); i++) {
            assertEquals(expectedDestination13.get(i), trajetory13.get(i).getDestination().getName());
        }
        for (int i = 0; i < trajetory14.size(); i++) {
            assertEquals(expectedDestination14.get(i), trajetory14.get(i).getDestination().getName());
        }
    }

    @Test
    void calculateTimeTest() {
        double totalDistance = 5000000;
        double VM = 50;
        double totalDistance2 = 10000000;
        double VM2 = 100;
        double totalDistance3 = 123456;
        double VM3 = 2;

        assertEquals(100, findCircuitProducer.calculateTime(totalDistance, VM));
        assertEquals(100, findCircuitProducer.calculateTime(totalDistance2, VM2));
        assertEquals(61.728, findCircuitProducer.calculateTime(totalDistance3, VM3));
    }
}

