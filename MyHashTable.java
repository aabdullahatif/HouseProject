public class MyHashTable {
    private MyList[] buckets;
    private int size;

    // Default constructor is being created that helps execute the hash table
    public MyHashTable() {
        buckets = new MyList[4];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new MyList();
        }
        size = 0;
    }

    // Constructor is being copied
    public MyHashTable(MyHashTable other) {
        this.buckets = new MyList[other.buckets.length];
        this.size = other.size;
        for (int i = 0; i < other.buckets.length; i++) {
            this.buckets[i] = other.buckets[i].deepCopy();
        }
    }

    public MyHashTable deepCopy() {
        return new MyHashTable(this);
    }

    // The house is being added to the hash table
    public void add(House house) {
        if ((size + 1.0) / buckets.length > 0.75) {
            resize();
        }
        int bucketIndex = Math.abs(house.hashCode() % buckets.length);
        buckets[bucketIndex].add(house);
        size++;
    }

    // This method will find the house with the name of the owner
    public House find(String owner) {
        int bucketIndex = Math.abs(owner.hashCode() % buckets.length);
        return buckets[bucketIndex].find(owner);
    }

    // The buckets are being resized and added
    private void resize() {
        MyList[] newBuckets = new MyList[buckets.length * 2];
        for (int i = 0; i < newBuckets.length; i++) {
            newBuckets[i] = new MyList();
        }
        for (MyList bucket : buckets) {
            for (House house : bucket.getAllHouses()) { // Get all houses from current bucket
                int bucketIndex = Math.abs(house.hashCode() % newBuckets.length);
                newBuckets[bucketIndex].add(house);
            }
        }
        buckets = newBuckets;
    }

    // All houses are being shown
    public void show() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print("Bucket " + i + ": ");
            buckets[i].show();
        }
    }
}
