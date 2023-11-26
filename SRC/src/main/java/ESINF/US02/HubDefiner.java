package ESINF.US02;

import ESINF.Domain.Hub;
import ESINF.Structure.Edge;
import ESINF.Structure.MapGraph;
import ESINF.US01.NetworkBuilder;

import java.util.*;
public class HubDefiner {

    //-------------------------------------------Centrality-------------------------------------------------------
    // Mapa que armazenará os resultados da centralidade para cada vértice
    private static Map<Hub, Integer> sortedHubsCentrality = new HashMap<>();

    // Grafo utilizado para calcular a centralidade
    private MapGraph<Hub, Integer> graphCentrality = NetworkBuilder.getInstance().getDistribution();

    // Método principal que retorna uma representação formatada dos hubs mais centrais
    public String hubsByCentrality(int n) {
        // Calcula e ordena a centralidade dos hubs
        setCentrality();
        orderCentralityMap();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        // Adiciona cabeçalhos à representação formatada
        sb.append("| Local  |       Centralidade       |\n");
        sb.append("|--------|--------------------------|\n");

        // Adiciona os hubs mais centrais à representação formatada
        for (Hub vertex : sortedHubsCentrality.keySet()) {
            if (i < n) {
                sb.append(String.format("|%7s |", vertex.getHubId()));
                sb.append(String.format("%15s |", sortedHubsCentrality.get(vertex)));
                sb.append("\n");
            }
            i++;
        }
        return sb.toString();
    }

    // Método para ordenar o mapa de centralidade em ordem decrescente
    private void orderCentralityMap() {
        List<Map.Entry<Hub, Integer>> entries = new ArrayList<>(sortedHubsCentrality.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        sortedHubsCentrality = new LinkedHashMap<>();
        for (Map.Entry<Hub, Integer> entry : entries) {
            sortedHubsCentrality.put(entry.getKey(), entry.getValue());
        }
    }

    private void setCentrality() {
        MapGraph<Hub, Integer> mapGraph = NetworkBuilder.getInstance().getDistribution();
        for (Hub vertex : mapGraph.vertices()){
            sortedHubsCentrality.put(vertex,0);
        }

    }


    //--------------------------------------------Influence------------------------------------------------------

    // Mapa para armazenar a influência de cada hub
    private static Map<Hub, Integer> sortedHubsInfluence = new HashMap<>();

    // Grafo utilizado para calcular a influência
    private MapGraph<Hub, Integer> graphInfluence = NetworkBuilder.getInstance().getDistribution();

    // Método principal que retorna uma representação formatada dos hubs mais influentes
    public String hubsByInfluence(int n) {

        // Calcula e ordena a influência dos hubs
        setInfluence();
        orderInfluenceMap();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        // Adiciona cabeçalhos à representação formatada
        sb.append("| Local  |        Influencia        |\n");
        sb.append("|--------|--------------------------|\n");

        // Adiciona os hubs mais influentes à representação formatada
        for (Hub vertice : sortedHubsInfluence.keySet()) {
            if (i < n) {
                sb.append(String.format("|%7s |", vertice.getHubId()));
                sb.append(String.format("%15s |", sortedHubsInfluence.get(vertice)));
                sb.append("\n");
            }
            i++;
        }
        return sb.toString();
    }

    // Método para ordenar o mapa de influência em ordem decrescente
    private void orderInfluenceMap() {
        List<Map.Entry<Hub, Integer>> entries = new ArrayList<>(sortedHubsInfluence.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Cria um novo mapa ordenado
        sortedHubsInfluence = new LinkedHashMap<>();
        for (Map.Entry<Hub, Integer> entry : entries) {
            sortedHubsInfluence.put(entry.getKey(), entry.getValue());
        }
    }

    // Método para calcular e armazenar a influência de cada hub no mapa
    private void setInfluence() {
        sortedHubsInfluence = new HashMap<>();
        for (Hub vertice : graphInfluence.vertices()) {
            // Armazena a influência de cada hub no mapa
            sortedHubsInfluence.put(vertice, graphInfluence.inDegree(vertice));
        }
    }

    //-------------------------------------------Proximity------------------------------------------------------

    // Mapa que armazenará os resultados da proximidade para cada vértice
    private static Map<Hub, Integer> sortedHubsProximity = new HashMap<>();

    // Grafo utilizado para calcular a proximidade
    private MapGraph<Hub, Integer> graphProximity = NetworkBuilder.getInstance().getDistribution();

    // Método principal que retorna uma representação formatada dos hubs mais próximos
    public String hubsByProximity(int n) {
        // Calcula e ordena a proximidade dos hubs
        setProximity();
        orderProximityMap();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        // Adiciona cabeçalhos à representação formatada
        sb.append("| Local  |    Proximidade     |\n");
        sb.append("|--------|--------------------|\n");

        // Adiciona os hubs mais próximos à representação formatada
        for (Hub vertex : sortedHubsProximity.keySet()) {
            if (i < n) {
                sb.append(String.format("|%7s |", vertex.getHubId()));
                sb.append(String.format("%15s |", sortedHubsProximity.get(vertex)));
                sb.append("\n");
            }
            i++;
        }
        return sb.toString();
    }

    // Método para ordenar o mapa de proximidade em ordem decrescente
    private void orderProximityMap() {
        List<Map.Entry<Hub, Integer>> entries = new ArrayList<>(sortedHubsProximity.entrySet());

        // Ordena a lista de entradas do mapa com base nos valores (proximidade) em ordem decrescente
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Cria um novo mapa ordenado
        sortedHubsProximity = new LinkedHashMap<>();
        for (Map.Entry<Hub, Integer> entry : entries) {
            // Preenche o novo mapa com os valores ordenados
            sortedHubsProximity.put(entry.getKey(), entry.getValue());
        }
    }


    private void setProximity() {
        // Inicializa o mapa que armazenará os resultados da proximidade para cada vértice
        sortedHubsProximity = new HashMap<>();

        // Itera sobre todos os vértices no grafo de proximidade
        for (Hub vertex : graphProximity.vertices()) {
            int distance = 0; // Inicializa a soma das distâncias
            int count = 0;    // Inicializa a contagem de arestas de entrada

            // Itera sobre todas as arestas de entrada para o vértice atual
            for (Edge edge : graphProximity.incomingEdges(vertex)) {
                // Obtém o peso da aresta (presumindo que o peso seja um número real, como int)
                int edgeWeight = (int) edge.getWeight();

                // Adiciona o peso da aresta à soma das distâncias
                distance += edgeWeight;

                // Incrementa a contagem de arestas de entrada
                count++;
            }

            // Calcula a média ponderada da proximidade para o vértice atual
            // Se a contagem for zero, define a média como zero para evitar divisão por zero
            int avg = (count == 0) ? 0 : (distance / count);

            // Armazena o resultado no mapa, associando o vértice à média de proximidade
            sortedHubsProximity.put(vertex, avg);
        }
    }


}
