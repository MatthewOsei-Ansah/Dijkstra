package com.company;

public class QueueNode<T> {
    private Node<T> Node;
    private int Weight;

    public QueueNode(Node<T> node, int weight){
        Node = node;
        Weight = weight;
    }

    public void setWeight(int weight){
        Weight = weight;
    }

    public int getWeight(){
        return Weight;
    }

    public Node<T> getNode(){
        return Node;
    }

    public void setNode(Node node){
        Node = node;
    }

}
