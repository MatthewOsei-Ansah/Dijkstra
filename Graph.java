package com.company;

import java.util.ArrayList;

public class Graph<T>{
    private final int MAX_SIZE = 7;
    private Node[] Array = {null,null,null,null,null,null,null};
    private int length = 0;

    public String Display()
    {
        int i = 0;
        String ReturnValue;
        ArrayList<String> StringArray = new ArrayList<>(MAX_SIZE);
        for(Node<T> value: Array){
            if(value == null){
                continue;
            }else{
                StringArray.add(value.toString() + " : " + value.getHashTable() + "\n");
                i++;
            }
        }
        return (StringArray).toString();
    }


    public void addNode(T Value) {
        boolean Placed = false;
        int i = 1;
        Integer Address;
        Node<T> element = new Node<>(Value);
        Address = element.getKey().hashCode() % MAX_SIZE;
        for(Node<T> value : Array){
            if(value == null){
                continue;
            }else if(value.getKey() == element.getKey()){
                throw new IllegalArgumentException("A node with that name already exists within the hashtable");
            }
        }

        if(Array[Address] == null){
            Array[Address] = element;
            length++;
        }else {
            while (!Placed && i != MAX_SIZE - 1) {
                if (Array[(Address + i) % MAX_SIZE] == null) {
                    Array[(Address + i) % MAX_SIZE] = element;
                    Address = (Address + i) % MAX_SIZE;
                    Placed = true;
                    length++;
                } else {
                    i++;
                }
            }
            if(!Placed){
                throw new UnsupportedOperationException("Dictionary Full");
            }
        }
    }

    public void addConnection(T node, T addnode, Integer weight){
        boolean found = false;
        boolean found2 = false;
        for(Node<T> CurrentNode : Array){
            if(CurrentNode == null){
                continue;
            }else if(CurrentNode.getNode().equals(node)){
                found = true;
                break;
            }
        }

        if(!found){
            throw new IllegalArgumentException("A node with that name was not found");
        }

        for(Node<T> Currentnode2 : Array){
            if(Currentnode2 == null){
                continue;
            }else if(Currentnode2.getNode().equals(addnode)){
                found2 = true;
                break;
            }
        }

        if(!found2){
            throw new IllegalArgumentException("Can not add connection, node does not exist");
        }

        for(Node<T> CurrentNode : Array){
            if(CurrentNode == null){
                continue;
            }else if(CurrentNode.getNode().equals(node)){
                CurrentNode.addConnection(addnode, weight);
                break;
            }
        }

        for(Node<T> Currentnode2 : Array){
            if(Currentnode2 == null){
                continue;
            }else if(Currentnode2.getNode().equals(addnode)){
                Currentnode2.addConnection(node, weight);
                break;
            }
        }
    }

    public Integer getKey(String node){
        boolean found = false;
        Integer keyvalue = null;

        for(Node Node : Array){
            if(Node == null){
                continue;
            } else if (Node.getNode().equals(node)) {
                found = true;
                keyvalue = Node.getKey();
                return keyvalue;
            }
        }
        if(!found){
            throw new IllegalArgumentException("Node with name given does not exist");
        }
        return keyvalue;
    }



    public T getNode(T node) {
        int i = 0;
        boolean Found = false;
        Node<T> foundvalue = null;
        for(Node<T> value : Array){
            if(value == null){
                continue;
            } else if (value.getNode().hashCode() == node.hashCode()) {
                Found = true;
                foundvalue = value;
                return (T) foundvalue;
            }
        }
        if(!Found) {
            throw new IllegalArgumentException("Key does not exist (I think)");
        }
        return (T) foundvalue;
    }


    public void delete(T node) {
        Integer Address;
        boolean found = false;
        if (!isEmpty()){
            for (Node<T> value : Array) {
                if (value == null) {
                    continue;
                } else if (Math.abs(value.getNode().hashCode()) == Math.abs(node.hashCode())) {
                    found = true;
                    Address = value.getKey() % MAX_SIZE;
                    Array[Address] = null;
                    length--;
                }
            }
        }else {
            throw new IllegalArgumentException("Dictionary is empty");
        }
        if(!found){
            throw new IllegalArgumentException("Value with the inputted key was not found");
        }
    }


    public int length() {
        int i = 0;
        for(Node<T> value : Array){
            if(value == null){
                continue;
            }else{
                i++;
            }
        }
        return i;
    }


    public boolean isEmpty() {
        return (length == 0);
    }

    public void Dijkstra(T StartNode){
        Integer Address;
        boolean found = false;
        LinkedList<T> PQ = new LinkedList<>();
        Element<T> Popped;

        if (!isEmpty()){
            for (Node<T> value : Array) {
                if (value == null) {
                    continue;
                } else if (Math.abs(value.getNode().hashCode()) == Math.abs(StartNode.hashCode())) {
                    found = true;
                    PQ.append(value, 0, null);
                    break;
                }
            }
        }else {
            throw new IllegalArgumentException("Dictionary is empty");
        }
        if(!found){
            throw new IllegalArgumentException("Start node was not found");
        }

        for(Node<T> value : Array) {
            if (value == null){
                continue;
            } else if (Math.abs(value.getNode().hashCode()) == Math.abs(StartNode.hashCode())) {
                continue;
            }else{
                PQ.append(value, Integer.MAX_VALUE, null);
            }
        }

        for(int i = 0; i < PQ.length(); i++) {
            Popped = PQ.pop();
            Connector<T>[] Conne
            for (Connector<T> Item : Popped.getNode().getConnections()) {
                PQ.append(new Node<T>(Item.getNode()), Item.getWeight(), Popped.getNode().getNode());
            }
        }
    }
}
