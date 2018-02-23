import java.util.*;

/* Written on 22-02-2018
 * This class is for defining the Graph using nodes and Edges
*/

public class Graph {

    private int numVertices;
    private Map<MapNode, HashSet<MapEdge>> vertices;

    Graph() {
        numVertices = 0;
        vertices = new HashMap<MapNode, HashSet<MapEdge>>();
    }

    /* This meothod adds vertex to the graph
     * @param - node to be added as vertex to the graph
     */

    void addVertex(MapNode V) {
        if (!vertices.containsKey(V)) {
            vertices.put(V, new HashSet<MapEdge>());
            ++numVertices;
        } else
            System.out.println("Vertex already added");
    }

    /* This method adds Edge between a source node and a destination node
    * @param - Source node, Destination node, weight represented by distance between two nodes
    */

    void addEdge(MapNode source, MapNode destination, int distance) {
        if (vertices.containsKey(source)) {
            MapEdge map_edge = new MapEdge(source, destination, distance);
            vertices.get(source).add(map_edge);
            source.addEdge(map_edge);
        } else {
            System.out.println("Source vertex not found..");
        }

    }

    /* This method calculates the distance between two nodes
    * @param - source node and destination node
    */
    int getDistance(MapNode source, MapNode destination) {
        int distance = 0;
        for (MapEdge edge : vertices.get(source)) {
            if (edge.getDestination() == destination) {
                distance =  edge.getDistance();
                break;
            }
        }
        return distance;
    }
    /* This method validates the given route, returns the total distance of route of route is valid
     * @param - Arraylist containing the routes to be validated
     */

    void valRoute(MapNode[][] route) {
        int i = 0;
        int j = 0;

        for (j = 0; j < route.length; j++) {
            ArrayList<String> path = new ArrayList();
            int distance = 0;
            for (i = 0; i < (route[j].length - 1); i++) {
                path.add(route[j][i].getName());
                if (getDistance(route[j][i], route[j][i+1]) == 0){
                    distance = 0;
                    break;
                }
                else
                    distance = distance + getDistance(route[j][i], route[j][i+1]);
            }
            if (distance == 0){
                path.add(route[j][i+1].getName());
                System.out.println("Route " + path + " Does not exists");
            }
            else {
                path.add(route[j][i].getName());
                System.out.println("Distance of route " + path + " is :" + distance);
            }
        }
    }

    /* This method finds the shortest route between two nodes and calculate the distance of the route
     * @param - source node and destination node
     */
    int bfs(MapNode source, MapNode destination) {
        Queue<MapNode> queue = new LinkedList<MapNode>();
        int distance = 0;
        MapNode node = source;
        boolean routeFound = false;
        queue.add(source);

        while ((!queue.isEmpty())&& (!routeFound)){
            node = queue.poll();
            Set<MapNode> neighbor = node.getNeighbors();
            distance = distance + getDistance(source, node);
            source = node;
            for (MapNode V : neighbor) {
                if (V == destination){
                        node = V;
                        routeFound = true;
                        break;
                    }
                    else {
                        queue.add(V);
                }
            }
        }
        distance = distance + getDistance(source, destination);
        return distance;
    }

}

