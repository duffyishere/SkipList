public class SkipList<K extends Comparable<K>, V> {
    private Node<K, V> head;

    public V get(K key) {
        Node<K, V> node = findNode(key);
        return node.getValue();
    }

    private Node<K, V> findNode(K key) {
        Node<K, V> node = head;
        Node<K, V> next;

        while (node.getLevel() != 1 && node.hasNext()) {
            next = node.getNext();

            while(next != null && lessThanOrEqual(key, next.getKey())) {
                node = next;
                next = node.getNext();
            }

            if (node.getKey().compareTo(key) == 0) {
                break;
            }

            node = node.getDown();
        }

        return node;
    }

    private boolean lessThanOrEqual(K o1, K o2) {
        return o1.compareTo(o2) <= 0;
    }
}
