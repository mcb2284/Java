import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Collection;



public class Graph<V> { 
   
    // Keep an index from node labels to nodes in the map
    protected Map<V, Vertex<V>> vertices; 

    /**
     * Construct an empty Graph.
     */
    public Graph() {
       vertices = new HashMap<V, Vertex<V>>();
    }

    /**
     * Retrieve a collection of vertices. 
     */  
    public Collection<Vertex<V>> getVertices() {
        return vertices.values();
    }

    public void addVertex(V u) {
        addVertex(new Vertex<>(u));
    }
    
    public void addVertex(Vertex<V> v) {
        if (vertices.containsKey(v.name)) 
            throw new IllegalArgumentException("Cannot create new vertex with existing name.");
        vertices.put(v.name, v);
    }

    /**
     * Add a new edge from u to v.
     * Create new nodes if these nodes don't exist yet. 
     * @param u unique name of the first vertex.
     * @param w unique name of the second vertex.
     * @param cost cost of this edge. 
     */
    public void addEdge(V u, V w, Double cost) {
        if (!vertices.containsKey(u))
            addVertex(u);
        if (!vertices.containsKey(w))
            addVertex(w);

        vertices.get(u).addEdge(
            new Edge<>(vertices.get(u), vertices.get(w), cost)); 

    }

    public void addEdge(V u, V w) {
        addEdge(u,w,1.0);
    }

    public void printAdjacencyList() {
        for (V u : vertices.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(u.toString());
            sb.append(" -> [ ");
            for (Edge e : vertices.get(u).getEdges()){
                sb.append(e.target.name);
                sb.append(" ");
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }    
  
   /**
    * Add a bidirectional edge between u and v. Create new nodes if these nodes don't exist
    * yet. This method permits adding multiple edges between the same nodes.
    *
    * @param u  
    *          the name of the source vertex.
    * @param v 
    *          the name of the target vertex.
    * @param cost
    *          the cost of this edge
    */
    public void addUndirectedEdge(V u, V v, Double cost) {
        addEdge(u,v, cost);
        addEdge(v,u, cost);
    }

    /****************************
     * Your code follows here.  *
     ****************************/ 
    
    // Part 1
    public void computeAllEuclideanDistances() {
        
        int xdist;
        int ydist;
        Vertex<V> adj;
        

        for(Vertex<V> v: vertices.values()){          
             for(Edge<V> u : v.getEdges()){
                 adj = u.target;
                 xdist = v.posX - adj.posX;
                 ydist = v.posY - adj.posY;
                 
                 u.distance = Math.hypot(xdist, ydist);
             }
         } 

      return; 
    }
    
    // Part 2
    public void doDijkstra(V s) {
        
        /*
         * I got stuck here for some reason the BinaryHeap 
         * isn't working and seeing how this is due in the next 30 
         * I don't think ill be able to reach out for help in time 
         * but hopefully I was on the right track. thank you guy for 
         * the awesome class this summer. 
         */
        
        for(Vertex<V> v : vertices.values()){
            v.visited = false;
            v.backpointer = null;
        } 
        
        Double startCost = 0.0;

        BinaryHeap<V> q = new BinaryHeap<>();
        q.insert(s);
        Vertex<V> adj;

        while (!q.isEmpty()){
            
            Vertex<V> u = vertices.get(q.pollmin());
            u.visited = true;
            
            for(Edge<V> v : u.getEdges()){
                
                adj = v.target;
                
                if(!adj.visited){
                    
                    double c = u.cost + v.distance;
                    
                    if (c < adj.cost){
                        
                        adj.cost = c;
                        adj.backpointer = u;
                        q.insert(adj.name);
                        
                    }
                }

            }
        }

        
        

        
      
        return; // TODO
    }

    // Part 3
    public List<Edge<V>> getDijkstraPath(V s, V t) {
      doDijkstra(s);
      return null; // TODO
    }  
    
}
