public class SkipList<K extends Comparable<K>, V> {
    private Node<K, V> head;

    public V get(K key) {
        Node<K, V> node = findNode(key);
        return node.getValue();
    }

    private Node<K, V> findNode(K key) {
        Node<K, V> node = head;
        Node<K, V> next;

        // 우측 비교. 언제까지? => level == 1 이고 다음 값이 null 일 떄 까지.
        while (node.getLevel() != 1 && node.hasNext()) {
            next = node.getNext();

            // key 보다 작은 값이 다음에 있을 경우 => 다음으로 이동.
            // 언제까지? => 다음 값이 key 보다 크거나 같을 때 까지.
            while(next != null && lessThanOrEqual(key, next.getKey())) {
                node = next;
                next = node.getNext();
            }

            // key와 현제 노드가 같은 경우
            if (node.getKey().compareTo(key) == 0) {
                break;
            }

            // 없을 경우 => 아래로 이동
            node = node.getDown();
        }

        return node;
    }

    private boolean lessThanOrEqual(K o1, K o2) {
        return o1.compareTo(o2) <= 0;
    }
}
