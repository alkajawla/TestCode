
/* Written on 22-02-2018
 * This is a constructor for defining the Map Edges
 *  Constructor returns source node, destination code and weight of the edge in terms of distance
 */


public class MapEdge
{
    private MapNode source, destination;
    private int distance;

    public MapEdge(MapNode source, MapNode destination, int distance) {
        this.source = source;
        this.destination= destination;
        this.distance= distance;
    }

    MapNode getSource()
    {
        return this.source;
    }
    MapNode getDestination()
    {
        return this.destination;
    }
    int getDistance()
    {
        return this.distance;
    }
}
   