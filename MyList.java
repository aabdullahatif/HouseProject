import java.util.ArrayList;
import java.util.List;

public class MyList {
    private Node head;

    /*Node class is being created for the linked list*/
    private class Node {
        House house;
        Node next;

        Node(House house) {
            this.house = house;
            this.next = null;
        }
    }

    /*Default constructor is being called on which is myList*/
    public MyList() {
        head = null;
    }

    /*Deep copy is being created to copy the constructor*/
    public MyList(MyList other) {
        this.head = null;
        Node current = other.head;

        while (current != null) {
            this.add(new House(current.house.getOwner(), current.house.getValue()));
            current = current.next;
        }
    }

    /*House class is being added to the start of the list*/
    public void add(House house) {
        Node newNode = new Node(house);
        newNode.next = head;
        head = newNode;
    }

    /*This method helps with finding the house with the name of the owner*/
    public House find(String owner) {
        Node current = head;
        while (current != null) {
            if (current.house.getOwner().equals(owner)) {
                return current.house;
            }
            current = current.next;
        }
        return null;
    }

    /* A deep copy is being created for the myList*/
    public MyList deepCopy() {
        return new MyList(this);
    }

    /*Show us all the houses that are present in the list*/
    public void show() {
        Node current = head;
        while (current != null) {
            System.out.println(current.house);
            current = current.next;
        }
    }

    /*New method to retrieve all House instances in the list*/
    public List<House> getAllHouses() {
        List<House> houses = new ArrayList<>();
        Node current = head;
        while (current != null) {
            houses.add(current.house);
            current = current.next;
        }
        return houses;
    }
}
