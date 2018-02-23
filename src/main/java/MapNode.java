import java.util.HashSet;
import java.util.Set;

/* Written on 22-02-2018
*This is a constructor for defining the Mapnodes
*  Constructor returns node name, node edge and neighbours of the node
*/

public class MapNode {

        private Set<MapEdge> edges;
        private String name;

        public MapNode(String name) {
            this.name = name;
            edges = new HashSet<MapEdge>();
        }

        void addEdge(MapEdge edge) {
            edges.add(edge);
        }

        String getName() {
            return new String(this.name);
        }

        Set<MapNode> getNeighbors() {
            Set<MapNode> neighbor = new HashSet<MapNode>();
            for (MapEdge edge : edges) {
                neighbor.add(edge.getDestination());
            }
            return neighbor;
        }

        Set<MapEdge> getEdges() {
            return new HashSet(this.edges);
        }
}

