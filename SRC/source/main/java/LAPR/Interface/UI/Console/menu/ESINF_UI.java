package LAPR.Interface.UI.Console.menu;

import ESINF.Domain.*;
import ESINF.FileReader.ReaderFiles;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;
import ESINF.US02.HubDefiner;
import ESINF.US06.DifferentRoutesFinder;
import ESINF.US07.MaximumHubsFinder;
import ESINF.US08.FindCircuitForProducer;

import java.io.IOException;
import java.time.LocalTime;
import java.util.*;
public class ESINF_UI implements Runnable {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double autonomia;
        do {
            System.out.println("===================================");
            System.out.println("    Rede Distribuição de Cabazes    ");
            System.out.println("===================================");
            System.out.println("1. Percursos possiveis limitados pelos KMS de autonomia");
            System.out.println("2. Percurso que maximiza o número de Hubs visitados");
            System.out.println("3. Circuíto de entrega com o maior número de colaboradores");
            System.out.println("4. Organizar as localidades em clusters");
            System.out.println("0. Sair");
            System.out.println("===================================");

            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ESINF.US06.DifferentRoutesFinder differentRoutesFinder = new DifferentRoutesFinder();
                    MapGraph<Locality, Integer> graph;
                    try {
                        ReaderFiles.importLocalData("SRC/source/main/resources/ESINF/locais_small.csv");
                        ReaderFiles.importDistanceData("SRC/source/main/resources/ESINF/distancias_small.csv", "SRC/source/main/resources/ESINF/locais_small.csv");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    HubDefiner hubDefiner = new HubDefiner();
                    NetworkBuilder networkBuilder = NetworkBuilder.getInstance();
                    graph = networkBuilder.getDistribution();
                    int number = 10;
                    hubDefiner.defineHubs(graph, number);
                    double autonomy = getPositiveDoubleFromUser("Digite a autonomia do veículo : ");
                    double velocidade = getPositiveDoubleFromUser("Digite a velocidade média do veículo : ");
                    Vehicle vehicle = new Vehicle("1", autonomy, velocidade);
                    Locality hubInicial = new Locality("CT1",40.6389,-8.6553);
                    Locality hubFinal = new Locality("CT2",38.0333,-7.8833);

                    TreeMap<LocalityPair, PathInfo> routesMap = differentRoutesFinder.routes(hubInicial, hubFinal, vehicle, graph);

                    for (Map.Entry<LocalityPair, PathInfo> entry : routesMap.entrySet()) {
                        LocalityPair localityPair = entry.getKey();
                        PathInfo pathInfo = entry.getValue();

                        System.out.println("Route: " + localityPair.toString());
                        System.out.println("Total Distance: " + pathInfo.getTotalDistance());
                        System.out.println("Total Travel Time: " + pathInfo.getTotalTime());
                        System.out.println("-------------");
                    }
                    break;
                    case 2:
                        MapGraph<Locality, Integer> graph1;
                        try {
                            ReaderFiles.importLocalData("SRC/source/main/resources/ESINF/locais_small.csv");
                            ReaderFiles.importDistanceData("SRC/source/main/resources/ESINF/distancias_small.csv", "SRC/source/main/resources/ESINF/locais_small.csv");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        HubDefiner hubDefiner1 = new HubDefiner();
                        NetworkBuilder networkBuilder1 = NetworkBuilder.getInstance();
                        graph1 = networkBuilder1.getDistribution();
                        int number1 = 10;
                        hubDefiner1.defineHubs(graph1, number1);

                        Locality hubInicial1 = new Locality("CT1",40.6389,-8.6553);
                        int autonomy2 = getNonNegativeIntFromUser("Digite a autonomia do veículo : ");
                        double velocidade2 = getPositiveDoubleFromUser("Digite a velocidade média do veículo : ");
                        double carregamento2 = getPositiveDoubleFromUser("Digite o tempo médio que o veículo demora a carregar : ");
                        double descarregamento2 = getPositiveDoubleFromUser("Digite o tempo médio que o veículo demora a descarregar nos hubs : ");
                        int horasInicio = getNonNegativeIntFromUser("Digite as horas de início: ");
                        int minutosInicio = getNonNegativeIntFromUser("Digite os minutos de início: ");
                        LocalTime horaDeComeco = LocalTime.of(horasInicio, minutosInicio);
                        PathInfo returned = MaximumHubsFinder.bestPathFinder(hubInicial1, horaDeComeco, autonomy2, velocidade2, carregamento2, descarregamento2, graph1);
                        System.out.println(returned.toString());
                    break;
                case 3:
                    MapGraph<Locality, Integer> graph2;
                    try {
                        ReaderFiles.importLocalData("SRC/source/main/resources/ESINF/locais_small.csv");
                        ReaderFiles.importDistanceData("SRC/source/main/resources/ESINF/distancias_small.csv", "SRC/source/main/resources/ESINF/locais_small.csv");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    HubDefiner hubDefiner2 = new HubDefiner();
                    NetworkBuilder networkBuilder2 = NetworkBuilder.getInstance();
                    graph2 = networkBuilder2.getDistribution();
                    int number2 = 10;
                    hubDefiner2.defineHubs(graph2, number2);
                    ESINF.US08.FindCircuitForProducer findCircuitForProducer = new FindCircuitForProducer();
                    findCircuitForProducer.runUS08();
                    break;
                case 4:
                    MapGraph<Locality, Integer> graph3;
                    try {
                        ReaderFiles.importLocalData("SRC/source/main/resources/ESINF/locais_small.csv");
                        ReaderFiles.importDistanceData("SRC/source/main/resources/ESINF/distancias_small.csv", "SRC/source/main/resources/ESINF/locais_small.csv");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    HubDefiner hubDefiner3 = new HubDefiner();
                    NetworkBuilder networkBuilder3 = NetworkBuilder.getInstance();
                    graph3 = networkBuilder3.getDistribution();
                    int number3 = 10;
                    hubDefiner3.defineHubs(graph3, number3);

                    int n = getNonNegativeIntFromUser("Insira o número de Clusters: ");
                    boolean clusters = ESINF.US09.OrganizeClustersWithHubs.formClusters(graph3, n);

                    if (clusters) {
                        List<Set<Locality>> clusters2 = ESINF.US09.OrganizeClustersWithHubs.getClusters(graph3);

                        System.out.println("Clusters: " + clusters2);

                        Map<Locality, List<Locality>> promotedHubsToClusters = ESINF.US09.OrganizeClustersWithHubs.formClustersAndMapHubs(graph3, n);
                        System.out.println("Hubs promovidos a clusters: " + promotedHubsToClusters);
                    } else {
                        System.out.println("Failed to form clusters.");
                    }

                    break;

                case 0:
                    System.out.println("---A Sair---");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }


        } while (choice != 0);
    }


    private float getNonNegativeFloat(Scanner scanner, String prompt) {
        float value;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextFloat()) {
                System.out.println("Por favor, insira um número real válido.");
                scanner.next();
            }
            value = scanner.nextFloat();
            if (value < 0) {
                System.out.println("Por favor, insira um número real não negativo.");
            }
        } while (value < 0);
        return value;
    }

    private static double getPositiveDoubleFromUser(String message) {
        double value;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(message);
            while (!scanner.hasNextDouble()) {
                System.out.println("Por favor, insira um número válido.");
                System.out.print(message);
                scanner.next();
            }
            value = scanner.nextDouble();

            if (value <= 0) {
                System.out.println("Por favor, insira um número positivo.");
            }
        } while (value <= 0);

        return value;
    }

    private static int getNonNegativeIntFromUser(String message) {
        int value;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(message);
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número inteiro válido.");
                System.out.print(message);
                scanner.next(); // Consumir entrada inválida
            }
            value = scanner.nextInt();

            if (value < 0) {
                System.out.println("Por favor, insira um número não negativo.");
            }
        } while (value < 0);

        return value;
    }
}
