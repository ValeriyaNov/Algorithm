public class Mapa<K, V> {
    int size = 3;
    Node<K, V>[] nodes = new Node[size];


    public Integer getHash(K key) {
        return Math.abs(key.hashCode()) % size;
    }


    public V put(K key, V value) {
        Node<K, V> inputNode = new Node<>(key, value);
        Integer index = getHash(key);
        if (nodes[index] != null) {
            Node<K, V> currentNode = nodes[index];
            while (currentNode != null) {
                if (currentNode.key == key) {
                    V result = currentNode.value;
                    currentNode.value = value;
                    return result;
                }
                currentNode = currentNode.nextNode;
            }
            inputNode.nextNode = nodes[index];
        }
        nodes[index] = inputNode;
        return null;
    }


    public V get(K key) {
        Integer index = getHash(key);
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                return currentNode.value;
            }
            currentNode = currentNode.nextNode;
        }
        return null;
    }


    public V remove(K key) {
        Integer index = getHash(key);
        Node<K, V> currentNode = nodes[index];
        Node<K, V> prevNode = null;
        while (currentNode != null) {
            if (currentNode.key == key) {
                V temp = currentNode.value;
                if (prevNode == null) {
                    nodes[index] = currentNode.nextNode;
                } else if (currentNode.nextNode == null) {
                    prevNode.nextNode = null;
                } else {
                    prevNode.nextNode = currentNode.nextNode;
                }
                return temp;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        return null;
    }


    public V replays(K key, V value) {
        V findNodeValue = get(key);
        remove(key);
        put(key, value);
        return findNodeValue;
    }


    boolean containsKey(K key) {
        if (get(key) != null)
            return true;
        return false;
    }


    boolean containsValue(V value) {
        for (Node<K, V> node : nodes) {
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.nextNode;
            }
        }
        return false;
    }

    int getSize(){

        return size;
    }

}
