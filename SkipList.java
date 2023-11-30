public class SkipList<K extends Comparable<K>, V> {
    private Node<K, V> head;
    private static final double PROBABILITY = 0.5;
    private int size;

    public SkipList() {
        head = new Node<>(null, null, 0);
        size = 0;
    }

    public V get(K key) {
        Node<K, V> node = findNode(key);
        return node.getValue();
    }

    public void add(K key, V value) {
        Node<K, V> node = findNode(key);
        if (node.getKey() != null && equalTo(key, node.getKey())) {
            node.setValue(value);
            return;
        }

        Node<K, V> prevNode = node;
        int currentLevel = 1;
        int headLevel = head.getLevel();
        Node<K, V> newNode = new Node<>(key, value, currentLevel);
        insertAfter(newNode, prevNode);

        while (canBuildNextLevel()) {
            if (currentLevel >= head.getLevel()) {
                Node<K, V> newHead = new Node<>(null, null, headLevel + 1);
                linkVertical(newHead, head);
                head = newHead;
                headLevel = head.getLevel();
            }

            while (prevNode.getUp() == null) {
                prevNode = prevNode.getPrevious();
            }
            prevNode = prevNode.getUp();

            Node<K, V> upperNode = new Node<>(key, value, prevNode.getLevel());
            insertAfter(prevNode, upperNode);
            linkVertical(upperNode, newNode);
            newNode = upperNode;
            currentLevel++;
        }
        size++;
    }

    private Node<K, V> findNode(K key) {
        Node<K, V> node = head;
        Node<K, V> next;
        Node<K, V> down;
        K nodeKey;

        while (true) {
            next = node.getNext();

            while(next != null && lessThanOrEqual(key, next.getKey())) {
                node = next;
                next = node.getNext();
            }

            nodeKey = node.getKey();
            if (nodeKey != null && equalTo(key, nodeKey)) {
                break;
            }

            down = node.getDown();
            if (down != null) {
                node = down;
            } else {
                break;
            }
        }

        return node;
    }

    private boolean lessThanOrEqual(K o1, K o2) {
        return o1.compareTo(o2) <= 0;
    }
    private boolean equalTo(K o1, K o2) {
        return o1.compareTo(o2) == 0;
    }

    private void insertAfter(Node<K, V> existingNode, Node<K, V> newNode) {
        newNode.setPrevious(existingNode);
        newNode.setNext(existingNode.getNext());
        if (existingNode.getNext() != null) {
            existingNode.getNext().setPrevious(newNode);
        }
        existingNode.setNext(newNode);
    }

    private void linkVertical(Node<K, V> upper, Node<K, V> lower) {
        upper.setDown(lower);
        lower.setUp(upper);
    }

    private boolean canBuildNextLevel() {
        return Math.random() < PROBABILITY;
    }

    class Node<K extends Comparable<K>, V> {
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

        public boolean hasDown() {
            return this.down != null;
        }
    }
}
