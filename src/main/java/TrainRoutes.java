/**
     * @author Alka Jawla
     * Contains 3 classes
     * MapNode - contains info about individual vertex in graph, like nodes connecting to it, its name, edges.
     * MapEdge - class to represent edges between two nodes. it stores distance between two nodes.
     * Graph - Core Graph data structure functionality.
     * Calls methods to validate train routes, calculate the distance of valid route, find routes between nodes and shortest path between nodes
     */

    public class TrainRoutes {

        public static void main(String[] args) {

            Graph graph = new Graph();

            // creating vertex
            MapNode A = new MapNode("A");
            MapNode B = new MapNode("B");
            MapNode C = new MapNode("C");
            MapNode D = new MapNode("D");
            MapNode E = new MapNode("E");

            // adding vertex to graph
            graph.addVertex(A);
            graph.addVertex(B);
            graph.addVertex(C);
            graph.addVertex(D);
            graph.addVertex(E);

            // conneting edges
            graph.addEdge(A, B, 5);
            graph.addEdge(B, C, 4);
            graph.addEdge(C, D, 8);
            graph.addEdge(D, C, 8);
            graph.addEdge(D,E, 6);
            graph.addEdge(A, D, 5);
            graph.addEdge(C, E, 2);
            graph.addEdge(E, B, 3);
            graph.addEdge(A, E, 7);

            //Validate routes and calcualte distance of valid routes
            //Calculate distance of route A->B->C, A->D, A->D->C, A->E->B-C->D, A->E->D
            MapNode[][] route = {{A,B,C},{A,D}, {A,D,C}, {A,E,B,C,D}, {A,E,D}};
            graph.valRoute(route);

            //Find the distance of shortest path between node A and C
            System.out.println(" Distance of shortest path between A and C is: " + graph.bfs(A,C));

            //Find the distance of shortest path between node B and B
            System.out.println(" Distance of shortest path between B and B is: " + graph.bfs(B,B));
        }
    }


