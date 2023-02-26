public class Element<T> {
    private Element<T> previous;
    private Element<T> next;
    private T PreviousNode;
    private Node<T> Node;
    private int Weight;

    public Element(Node<T> node, int weight,T previousNode ,Element<T> previous, Element<T> next)
    {
        this.Node = node;
        this.Weight = weight;
        this.PreviousNode = previousNode;
        this.previous = previous;
        this.next = next;

    }

    @Override
    public String toString()
    {
        return Node.toString();
    }

    public Node<T> getNode()
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

    public T getPreviousNode() {
        return PreviousNode;
    }

    public void setPreviousNode(T previousNode) {
        PreviousNode = previousNode;
    }

    public int getWeight() {
        return Weight;
    }

    public void setNode(Node<T> node) {
        Node = node;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }
}
