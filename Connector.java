
public class Connector<T> {
    private Integer Weight;
    private T Node;


    public Connector(T node, Integer weight){
        this.Weight = weight;
        this.Node = node;
    }

    public T getNode(){
        return this.Node;
    }

    public Integer getWeight(){
        return this.Weight;
    }

    public void setWeight(Integer weight){
        this.Weight = weight;
    }

    public void setNode(T node){
        this.Node = node;
    }

    public String Idk(T node){
        String Step1;
        String Step2;
        String Step3;
        Step1 = node.toString();
        Step2 = this.Weight.toString();
        Step3 = Step1 + " : " + Step2;

        return Step3;
    }


}
