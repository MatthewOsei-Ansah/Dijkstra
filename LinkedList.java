package com.company;

import java.util.ArrayList;

public class LinkedList<T> {
    private Element<T> front;
    private int length = 0;

    public static void main(String[] args) {
    }

    public String[] asArray() {
        ArrayList<String> a = new ArrayList<String>();
        Element<T> e = front;

        while (e != null) {
            a.add(e.toString());
            e = e.Next();
        }

        return a.toArray(new String[a.size()]);
    }

    public boolean isEmpty() {
        return (length() == 0);
    }

    public void append(QueueNode<T> value) {
        Element<T> Current;
        Element<T> Tail;
        Element<T> Insert;

        if (front != null) {
            Current = front;

            while (Current.Next() != null) {
                if(Current.getNode().getNode().getNode() == value.getNode().getNode()){
                    if (Current.getNode().getWeight() >= value.getWeight()) {
                        Insert = new Element<T>(value, null, null);
                        Insert.Next(Current.Next());
                        Insert.Previous(Current.Previous());
                        Current.Next().Previous(Insert);
                        Current.Previous().Next(Insert);
                        Current.Next(null);
                        Current.Previous(null);
                    }
                    return;
                }
                if(Current.getNode().getWeight() < value.getWeight()){
                    Current = Current.Next();
                } else{
                    Insert = new Element<T>(value,null, null);
                    Insert.Next(Current);
                    Insert.Previous(Current.Previous());
                    Current.Previous(Insert);
                    Current.Previous().Next(Insert);
                    length++;
                    return;
                }

            }
            if(Current.getNode().getNode().getNode() == value.getNode().getNode()) {
                if (Current.getNode().getWeight() >= value.getWeight()) {
                    Insert = new Element<T>(value, null, null);
                    Insert.Previous(Current.Previous());
                    Current.Previous().Next(Insert);
                    Current.Previous(null);
                }
                return;
            }

            Tail = new Element(value,Current, null);
            Current.Next(Tail);
            length++;
        } else {
            front = new Element(value, null,null);
            length++;
        }
    }

    public Element<T> pop() {
        Element<T> popped;
        if (!isEmpty() && length > 1) {
            popped = front;
            front.Next().Previous(null);
            front = front.Next();
            length--;
            return popped;
        }else if(length == 1) {
            popped = front;
            front = null;
            length --;
            return popped;
        }else if (isEmpty()) {
            throw new UnsupportedOperationException();
        }
        return front;
    }
    public int length() {
        return length;
    }
}
