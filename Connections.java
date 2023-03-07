import java.util.ArrayList;

public class Connections<T>{
    private final int MAX_SIZE = 7;
    private Connector[] Array = {null,null,null,null,null,null,null};
    private int length = 0;

    public ArrayList<String> getConnections()
    {
        int i = 0;
        ArrayList<String> StringArray = new ArrayList<>();
        String Step1;
        String Step2;
        String Step3;
        for(Connector<T> value: Array){
            if(value == null){
                continue;
            }else{
                Step1 = value.getNode().toString();
                Step2 = value.getWeight().toString();
                Step3 = Step1 + " : " + Step2;
                StringArray.add(Step3);
                i++;
            }
        }
        return StringArray;
    }


    public void add(T Value, Integer Weight) {
        boolean Placed = false;
        int i = 1;
        Integer Address;
        Connector<T> element = new Connector<T>(Value, Weight);
        Address = Math.abs(Value.hashCode() % 7);
        for(Connector<T> value : Array){
            if(value == null){
                continue;
            }else if(value.getNode().hashCode() == Value.hashCode()){
                throw new IllegalArgumentException("A node with that key already exists within the hashtable");
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


    public T getNode(T Node) {
        int i = 0;
        boolean Found = false;
        Connector<T> foundvalue = null;
        for(Connector<T> value : Array){
            if(value == null){
                continue;
            } else if (value.getNode().hashCode() == Node.hashCode()) {
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


    public void delete(T Node) {
        Integer Address;
        boolean found = false;
        if (!isEmpty()){
            for (Connector<T> value : Array) {
                if (value == null) {
                    continue;
                } else if (value.getNode().hashCode() == Node.hashCode()) {
                    found = true;
                    Address = Math.abs((value.getNode().hashCode() % MAX_SIZE));
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


    public boolean contains(T Node) {
        boolean found = false;
        for(Connector<T> value : Array){
            if(value == null){
                continue;
            } else if (value.getNode().hashCode() == Node.hashCode()) {
                found = true;
                return found;
            }
        }
        return found;
    }


    public int length() {
        int i = 0;
        for(Connector<T> value : Array){
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

    public Connector[] getArray(){
        return Array;
    }
}
