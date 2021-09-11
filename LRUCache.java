package lab;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
	private Node<K, V> lru;
	private Node<K, V> mru;
	private final int capacity;
	private final Map<K, Node<K, V>> container;
	private int currentSize;

	public LRUCache(int capacity) {
		this.container = new HashMap<>();
		this.capacity = capacity;
		this.currentSize = 0;

	}

	public V get(K key) {
		if (!container.containsKey(key)) {
			return null;
		}
		Node<K, V> tempNode = container.get(key);

		Node<K, V> prevNode = tempNode.previous;
		Node<K, V> nextNode = tempNode.next;

		if (tempNode.key == mru.key) {
			return tempNode.value;
		}
		if (tempNode.key == lru.key) {
			nextNode.previous = null;
			lru = nextNode;
		} else {
			prevNode.next = nextNode;
			nextNode.previous = prevNode;
		}
		tempNode.previous = mru;
		mru.next = tempNode;
		mru = tempNode;
		mru.next = null;

		return tempNode.value;
	}

	@Override
	public String toString() {
		return "LRUCache{" +
				container +
				'}';
	}

	public void put(K key, V value) {
		if (container.containsKey(key)) {
			return;
		}
		Node<K, V> newNode = new Node<>(key, value, mru, null);
		if (mru != null) {
			mru.next = newNode;
		}
		container.put(key, newNode);
		mru = newNode;

		if (capacity == currentSize) {
			container.remove(lru.key);
			lru = lru.next;
			lru.previous = null;
		} else if (currentSize < capacity) {
			if (currentSize == 0) {
				lru = newNode;
			}
			currentSize++;
		}


	}

	private class Node<K, V> {
		K key;
		V value;
		Node<K, V> previous;
		Node<K, V> next;

		public Node(K key, V value, Node<K, V> previous, Node<K, V> next) {
			this.key = key;
			this.value = value;
			this.previous = previous;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node{" +
					"key=" + key +
					", value=" + value +
					'}';
		}
	}

}
