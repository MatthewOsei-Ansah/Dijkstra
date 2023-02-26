import java.util.ArrayList;

public class Node<T> {
    private Integer Key;
    private T Node;
    private Connections<T> ConnectionsGraph = new Connections<>();

    public Node(T node){
        this.Node = node;
        this.Key = Math.abs(node.hashCode());
    }

    public void addConnection(T node, Integer weight){
        ConnectionsGraph.add(node, weight);
    }

    public ArrayList<String> getHashTable(){
        return ConnectionsGraph.getConnections();
    }

    public Connector[] getConnections(){
        return ConnectionsGraph.getArray();
    }


    public T getNode(){
        return this.Node;
    }

    public Integer getKey(){
        return this.Key;
    }

    @Override
    public String toString(){
        return this.Node.toString();
    }
}
