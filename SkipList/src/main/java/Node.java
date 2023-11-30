public class Node<K extends Comparable<K>, V> {
    private int level;

    private K key;
    private V value;

    private Node<K, V> left, right, up, down;

    public Node(K key, V value, int level) {
        this.key = key;
        this.value = value;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getPrevious() {
        return left;
    }

    public void setPrevious(Node<K, V> left) {
        this.left = left;
    }

    public Node<K, V> getNext() {
        return right;
    }

    public void setNext(Node<K, V> right) {
        this.right = right;
    }

    public boolean hasNext() {
        return this.right != null;
    }

    public Node<K, V> getUp() {
        return up;
    }

    public void setUp(Node<K, V> up) {
        this.up = up;
    }

    public Node<K, V> getDown() {
        return down;
    }

    public void setDown(Node<K, V> down) {
        this.down = down;
    }
}