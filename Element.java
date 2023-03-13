public class Element<T> {
    private Element<T> previous;
    private Element<T> next;
    private QueueNode<T> Node;

    public Element(QueueNode<T> node,Element<T> previous, Element<T> next)
    {
        this.Node = node;
        this.previous = previous;
        this.next = next;

    }

    @Override
    public String toString()
    {
        return Node.toString();
    }

    public QueueNode<T> getNode()
    {
        return Node;
    }

    public Element<T> Previous()
    {
        return previous;
    }

    public void Previous(Element<T> value)
    {
        previous = value;
    }

    public Element<T> Next()
    {
        return next;
    }

    public void Next(Element<T> value)
    {
        next = value;
    }


    public void setNode(QueueNode<T> node) {
        Node = node;
    }

}
