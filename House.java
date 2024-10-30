import java.util.Objects;

/*Creates a new java class house and gives it value sof owner and value*/
/*Constructor is being created*/
public class House {
    private String owner;
    private int value;

    /*Instantitaes the owner and the value*/
    public House(String owner, int value) {
        this.owner = owner;
        this.value = value;
    }

    /*Calls on the method to know the owner and ask the input from the user*/
    public String getOwner() {
        return owner;
    }

    /*Calls on the method getValue and ask the user to write the value to it*/
    public int getValue() {
        return value;
    }

    /*Provides a string representation of the house instance with owner and value*/
    @Override
    public String toString() {
        return "House{" + "owner='" + owner + '\'' + ", value=" + value + '}';
    }

    /*Hashcode method is being written to override the house class to craete a hash code for the house instance*/
    @Override
    public int hashCode() {
        return Objects.hash(this.owner);
    }
}




