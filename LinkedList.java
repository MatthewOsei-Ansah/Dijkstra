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

    public void append(Node<T> value, int weight, T previousNode) {
        Element<T> Current;
        Element<T> Tail;
        Element<T> Insert;
        weight = Math.abs(weight);

        if (front != null) {
            Current = front;

            while (Current.Next() != null) {
                if(Current.getNode() == value){
                    if(Current.getWeight() < weight){
                        Current = Current.Next();
                        continue;
                    }else{
                        Insert = new Element<T>(value, weight,previousNode,null, null);
                        Insert.Next(Current.Next());
                        Insert.Previous(Current.Previous());
                        Current.Next().Previous(Insert);
                        Current.Previous().Next(Insert);
                        Current.Next(null);
                        Current.Previous(null);
                        return;
                    }
                }
                if(Current.getWeight() < weight){
                    Current = Current.Next();
                } else{
                    Insert = new Element<T>(value, weight,previousNode,null, null);
                    Insert.Next(Current);
                    Insert.Previous(Current.Previous());
                    Current.Previous(Insert);
                    Current.Previous().Next(Insert);
                    length++;
                    return;
                }

            }
            if(Current.getNode() == value) {
                if (Current.getWeight() < weight) {
                    return;
                } else {
                    Insert = new Element<T>(value, weight, previousNode, null, null);
                    Insert.Previous(Current.Previous());
                    Current.Previous().Next(Insert);
                    Current.Previous(null);
                    return;
                }
            }

            Tail = new Element(value, weight,previousNode,Current, null);
            Current.Next(Tail);
            length++;
        } else {
            front = new Element(value, 0,null,null,null);
            length++;
        }
    }

    public Element<T> pop() {
        Element<T> popped;
        if (!isEmpty()) {
            popped = front;
            front.Next().Previous(null);
            front = front.Next();
            length--;
            return popped;
        } else if (isEmpty()) {
            throw new UnsupportedOperationException();
        }
        return front;
    }
    public int length() {
        return length;
    }
}
