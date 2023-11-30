public class SkipList<K extends Comparable<K>, V> {
    private Node<K, V> head;

    public V get(K key) {
        Node<K, V> node = findNode(key);
        return node.getValue();
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
}
