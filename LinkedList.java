import java.util.ArrayList;

public class LinkedList<T> {
    private Element<T> Front;
    private int Length = 0;

    public static void main(String[] args) {
    }

    public String asArray() {
        ArrayList<String> a = new ArrayList<>();
        Element<T> e = Front;

        while (e != null) {
            a.add(e.getNode().getNode().getNode().toString());
            e = e.Next();
        }

        return a.toString();
    }

    public boolean isEmpty() {
        return (length() == 0);
    }

    public void append(QueueNode<T> value) {
        Element<T> Current;
        Element<T> Tail;
        Element<T> Insert;

        if (Front != null) {
            Current = Front;

            while (Current.Next() != null) {
                if (Current.getNode().getNode().getNode() == value.getNode().getNode()) {
                    if (Current.getNode().getWeight() > value.getWeight()) {
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
                if (Current.getNode().getWeight() < value.getWeight()) {
                    Current = Current.Next();
                } else {
                    if (Current == Front) {
                        Insert = new Element<T>(value, null, null);
                        Insert.Next(Current);
                        Insert.Previous(Current.Previous());
                        Current.Previous(Insert);
                        Front = Insert;
                        Length++;
                        return;
                    } else {
                        Insert = new Element<T>(value, null, null);
                        Insert.Next(Current);
                        Insert.Previous(Current.Previous());
                        Current.Previous(Insert);
                        Current.Previous().Next(Insert);
                        Length++;
                        return;
                    }
                }

            }
            if (Current.getNode().getNode().getNode() == value.getNode().getNode()) {
                if (Current.getNode().getWeight() > value.getWeight()) {
                    if (Current == Front) {
                        Insert = new Element<T>(value, null, null);
                        Insert.Next(Current);
                        Insert.Previous(Current.Previous());
                        Current.Previous(Insert);
                    } else {
                        Insert = new Element<T>(value, null, null);
                        Insert.Previous(Current.Previous());
                        Current.Previous().Next(Insert);
                        Current.Previous(null);
                    }
                    return;
                }
            }
            Tail = new Element(value, Current, null);
            Current.Next(Tail);
            Length++;
        }else {
            Front = new Element(value, null, null);
            Length++;
            }
        }


        public Element<T> pop() {
            Element<T> popped;
            if (!isEmpty() && Length > 1) {
                popped = Front;
                Front.Next().Previous(null);
                Front = Front.Next();
                Length--;
                return popped;
            } else if (Length == 1) {
                popped = Front;
                Front = null;
                Length--;
                return popped;
            } else if (isEmpty()) {
                throw new UnsupportedOperationException("Linked List is empty");
            }
            return Front;
        }
        public int length() {
            return Length;
        }

        public QueueNode<T> search (QueueNode < T > value) {//Return true if the value exists in the Linked List
            boolean found = false;
            Element<T> Current = Front;
            QueueNode<T> FoundValue;
            if (!isEmpty()) {
                while (Current.Next() != null) {
                    if (Current.getNode().getNode().getNode() == value.getNode().getNode()) {
                        FoundValue = Current.getNode();
                        return FoundValue;
                    } else {
                        Current = Current.Next();
                    }
                }
            }
            if (!found) {
                throw new IllegalArgumentException("Node with corresponding name not found");
            } else {
                return null;
            }
        }
}
