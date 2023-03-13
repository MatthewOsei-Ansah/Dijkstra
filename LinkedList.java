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
        Element<T> Search;

        if (Front != null) {
            Current = Front;

            while (Current.Next() != null) {
                if (Current.getNode().getNode().getNode() == value.getNode().getNode()) {
                    if (Current.getNode().getWeight() > value.getWeight()) {
                        if (Current == Front) {
                            Insert = new Element<T>(value, null, null);
                            Insert.Next(Current.Next());
                            Insert.Previous(Current.Previous());

                            if(Current.Next() != null){
                                Current.Next().Previous(Insert);
                            }
                            Current.Next(null);
                            Current.Previous(null);
                            Front = Insert;
                            Search = Insert;
                        }else {
                            Insert = new Element<T>(value, null, null);
                            Insert.Next(Current.Next());
                            Insert.Previous(Current.Previous());
                            Current.Next().Previous(Insert);
                            Current.Previous().Next(Insert);
                            Current.Next(null);
                            Current.Previous(null);
                            Search = Insert;
                        }
                        while (Search.Next() != null) {
                            Search = Search.Next();

                            if (Search.getNode().getNode().getNode() == Insert.getNode().getNode().getNode()) {
                                if (Search.Next() == null) {
                                    Search.Previous().Next(null);
                                    return;
                                }
                            }

                            if (Search.getNode().getNode().getNode() == Insert.getNode().getNode().getNode()) {
                                Search.Next().Previous(Search.Previous());
                                Search.Previous().Next(Search.Next());
                                Search.Next(null);
                                Search.Previous(null);
                                return;
                            }
                        }
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
                        Search = Insert;
                        while (Search.Next() != null) {
                            Search = Search.Next();

                            if (Search.getNode().getNode().getNode() == Insert.getNode().getNode().getNode()) {
                                if (Search.Next() == null) {
                                    Search.Previous().Next(null);
                                    return;
                                }
                            }

                            if (Search.getNode().getNode().getNode() == Insert.getNode().getNode().getNode()) {
                                Search.Next().Previous(Search.Previous());
                                Search.Previous().Next(Search.Next());
                                Search.Next(null);
                                Search.Previous(null);
                                return;
                            }
                        }
                        Length++;
                        return;
                    } else {
                        Insert = new Element<T>(value, null, null);
                        Insert.Next(Current);
                        Insert.Previous(Current.Previous());
                        Current.Previous(Insert);
                        Current.Previous().Next(Insert);
                        Search = Insert;
                        while (Search.Next() != null) {
                            Search = Search.Next();

                            if (Search.getNode().getNode().getNode() == Insert.getNode().getNode().getNode()) {
                                if (Search.Next() == null) {
                                    Search.Previous().Next(null);
                                    return;
                                }
                            }

                            if (Search.getNode().getNode().getNode() == Insert.getNode().getNode().getNode()) {
                                Search.Next().Previous(Search.Previous());
                                Search.Previous().Next(Search.Next());
                                Search.Next(null);
                                Search.Previous(null);
                                return;
                            }
                        }
                        Length++;
                        return;
                    }
                }

            }
            if (Current.getNode().getNode().getNode() == value.getNode().getNode()) {
                if (Current.getNode().getWeight() > value.getWeight()) {
                    if (Current == Front) {
                        Insert = new Element<T>(value, null, null);
                        Insert.Next(Current.Next());
                        Insert.Previous(Current.Previous());

                        if(Current.Next() != null){
                            Current.Next().Previous(Insert);
                        }
                        Current.Next(null);
                        Current.Previous(null);
                        Front = Insert;
                        Search = Insert;
                        while (Search.Next() != null) {
                            Search = Search.Next();

                            if (Search.getNode().getNode().getNode() == Insert.getNode().getNode().getNode()) {
                                if (Search.Next() == null) {
                                    Search.Previous().Next(null);
                                    return;
                                }
                            }

                            if (Search.getNode().getNode().getNode() == Insert.getNode().getNode().getNode()) {
                                Search.Next().Previous(Search.Previous());
                                Search.Previous().Next(Search.Next());
                                Search.Next(null);
                                Search.Previous(null);
                                return;
                            }
                        }
                    } else {
                        Insert = new Element<T>(value, null, null);
                        Insert.Previous(Current.Previous());
                        Current.Previous().Next(Insert);
                        Current.Previous(null);
                        Search = Insert;
                        while (Search.Next() != null) {
                            Search = Search.Next();

                            if (Search.getNode().getNode().getNode() == Insert.getNode().getNode().getNode()) {
                                if (Search.Next() == null) {
                                    Search.Previous().Next(null);
                                    return;
                                }
                            }

                            if (Search.getNode().getNode().getNode() == Insert.getNode().getNode().getNode()) {
                                Search.Next().Previous(Search.Previous());
                                Search.Previous().Next(Search.Next());
                                Search.Next(null);
                                Search.Previous(null);
                                return;
                            }
                        }
                    }
                }
                return;
            }
            if (Current.getNode().getWeight() > value.getWeight()) {
                if (Current == Front) {
                    Insert = new Element<T>(value, null, null);
                    Insert.Next(Current.Next());
                    Insert.Previous(Current.Previous());
                    Current.Previous(Insert);
                    Front = Insert;
                    Search = Insert;
                    while (Search.Next() != null) {
                        Search = Search.Next();

                        if (Search.getNode().getNode().getNode() == Insert.getNode().getNode().getNode()) {
                            if (Search.Next() == null) {
                                Search.Previous().Next(null);
                                return;
                            }
                        }

                        if (Search.getNode().getNode().getNode() == Insert.getNode().getNode().getNode()) {
                            Search.Next().Previous(Search.Previous());
                            Search.Previous().Next(Search.Next());
                            Search.Next(null);
                            Search.Previous(null);
                            return;
                        }
                    }
                    Length++;
                } else {
                    Insert = new Element<T>(value, null, null);
                    Insert.Previous(Current.Previous());
                    Current.Previous().Next(Insert);
                    Current.Previous(null);
                    Search = Insert;
                    while (Search.Next() != null) {
                        Search = Search.Next();

                        if (Search.getNode().getNode().getNode() == Insert.getNode().getNode().getNode()) {
                            if (Search.Next() == null) {
                                Search.Previous().Next(null);
                                return;
                            }
                        }

                        if (Search.getNode().getNode().getNode() == Insert.getNode().getNode().getNode()) {
                            Search.Next().Previous(Search.Previous());
                            Search.Previous().Next(Search.Next());
                            Search.Next(null);
                            Search.Previous(null);
                            return;
                        }
                    }
                    //Length++;
                }
                return;
            }
            Tail = new Element<T>(value, Current, null);
            Current.Next(Tail);
        } else {
            Front = new Element<T>(value, null, null);
        }
        Length++;
    }


    public Element<T> pop() {
        Element<T> popped;
        if (Length > 1) {
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
}
