package com.company;

public class QueueNode<T> {
    private Node<T> Node;
    private int Weight;
    private QueueNode<T> PreviousNode;

    public QueueNode(Node<T> node, int weight, QueueNode<T> previousNode){
        Node = node;
        Weight = weight;
        PreviousNode = previousNode;
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

    public QueueNode<T> getPreviousNode() {
        return PreviousNode;
    }

    public void setPreviousNode(QueueNode<T> previousNode) {
        PreviousNode = previousNode;
    }
}
