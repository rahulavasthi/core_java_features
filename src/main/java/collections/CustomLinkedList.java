package collections;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> {
	int size = 0;
	Node<T> first;
	Node<T> last;

	public CustomLinkedList() {
	}

	public boolean add(T e) {
		linkLast(e);
		return true;
	}

	public void addFirst(T e) {
		linkFirst(e);
	}

	public void addLast(T e) {
		linkLast(e);
	}

	public T get(int index) {
		checkElementIndex(index);
		return node(index).data;
	}

	public T getFirst() {
		final Node<T> f = first;
		if (f == null)
			throw new NoSuchElementException();
		return f.data;
	}

	public T getLast() {
		final Node<T> l = last;
		if (l == null)
			throw new NoSuchElementException();
		return l.data;
	}

	public T removeFirst() {
		final Node<T> f = first;
		if (f == null)
			throw new NoSuchElementException();
		return unlinkFirst(f);
	}

	public T removeLast() {
		final Node<T> l = last;
		if (l == null)
			throw new NoSuchElementException();
		return unlinkLast(l);
	}

	public boolean remove(Object o) {
		if (o == null) {
			for (Node<T> x = first; x != null; x = x.next) {
				if (x.data == null) {
					unlink(x);
					return true;
				}
			}
		} else {
			for (Node<T> x = first; x != null; x = x.next) {
				if (o.equals(x.data)) {
					unlink(x);
					return true;
				}
			}
		}
		return false;
	}
	
	public int size(){
		return size;
	}

	private void linkLast(T e) {
		final Node<T> l = last;
		final Node<T> newNode = new Node<T>(l, e, null);
		last = newNode;
		if (l == null)
			first = newNode;
		else
			l.next = newNode;
		size++;
	}

	private void linkFirst(T e) {
		final Node<T> f = first;
		final Node<T> newNode = new Node<T>(null, e, f);
		first = newNode;
		if (f == null)
			last = newNode;
		else
			f.prev = newNode;
		size++;
	}

	private T unlinkFirst(Node<T> f) {
		// assert f == first && f != null;
		final T element = f.data;
		final Node<T> next = f.next;
		f.data = null;
		f.next = null; // help GC
		first = next;
		if (next == null)
			last = null;
		else
			next.prev = null;
		size--;
		return element;
	}

	private T unlinkLast(Node<T> l) {
		// assert l == last && l != null;
		final T element = l.data;
		final Node<T> prev = l.prev;
		l.data = null;
		l.prev = null; // help GC
		last = prev;
		if (prev == null)
			first = null;
		else
			prev.next = null;
		size--;
		return element;
	}

	private void checkElementIndex(int index) {
		if (!isElementIndex(index))
			throw new IndexOutOfBoundsException();
	}

	private boolean isElementIndex(int index) {
		return index >= 0 && index < size;
	}

	/**
	 * Returns the (non-null) Node at the specified element index.
	 */
	Node<T> node(int index) {
		// assert isElementIndex(index);

		if (index < (size >> 1)) {
			Node<T> x = first;
			for (int i = 0; i < index; i++)
				x = x.next;
			return x;
		} else {
			Node<T> x = last;
			for (int i = size - 1; i > index; i--)
				x = x.prev;
			return x;
		}
	}

	/**
	 * Unlinks non-null node x.
	 */
	T unlink(Node<T> x) {
		// assert x != null;
		final T element = x.data;
		final Node<T> next = x.next;
		final Node<T> prev = x.prev;

		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
			x.prev = null;
		}

		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			x.next = null;
		}

		x.data = null;
		size--;
		return element;
	}

	private static class Node<T> {
		T data;
		Node<T> next;
		Node<T> prev;

		Node(Node<T> prev, T data, Node<T> next) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
}
