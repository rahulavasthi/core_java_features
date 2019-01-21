package collections;

import java.util.Arrays;
/**
 * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
 * src -- This is the source array.
 * srcPos -- This is the starting position in the source array.
 * dest -- This is the destination array.
 * destPos -- This is the starting position in the destination data.
 * length -- This is the number of array elements to be copied.
 * 
 * Arrays.copyOf does not only copy elements, it also creates a new array. 
 * System.arrayCopy copies into an existing array
 * public static int[] copyOf(int[] original, int newLength) { 
 * 		int[] copy = new int[newLength]; 
 * 		System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
 * 		return copy; 
 * }
 */
public class CustomArrayList<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] DEFAULT_DATA = new Object[10];

	private Object[] arrayData;
	private int arraySize;

	public CustomArrayList() {
		this.arrayData = DEFAULT_DATA;
	}

	public CustomArrayList(int initialCapacity) {
		if (initialCapacity > 0) {
			this.arrayData = new Object[initialCapacity];
		} else if (initialCapacity == 0) {
			this.arrayData = DEFAULT_DATA;
		} else {
			throw new IllegalArgumentException("Initial capacity is not valid"
					+ initialCapacity);
		}
	}

	public E get(int index) {
		if (index < arraySize && index > -1) {
			return (E) arrayData[index];
		} else {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	public void add(E obj) {
		if ((arrayData.length - arraySize) < DEFAULT_CAPACITY / 2) {
			increaseSizeLimit();
		}
		arrayData[arraySize++] = obj;
	}

	public int size() {
		return arraySize;
	}

	public boolean remove(E obj) {
		if (obj == null) {
			for (int index = 0; index < arraySize; index++)
				if (arrayData[index] == null) {
					fastRemove(index);
					return true;
				}
		} else {
			for (int index = 0; index < arraySize; index++)
				if (obj.equals(arrayData[index])) {
					fastRemove(index);
					return true;
				}
		}
		return false;
	}

	public E remove(int index) {
		if (index < arraySize) {
			E obj = (E) arrayData[index];
			arrayData[index] = null;
			int tmp = index;
			while (tmp < arraySize) {
				arrayData[tmp] = arrayData[tmp + 1];
				arrayData[tmp + 1] = null;
				tmp++;
			}
			arraySize--;
			return obj;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	private void increaseSizeLimit() {
		arrayData = Arrays.copyOf(arrayData, arrayData.length * 2);
	}

	private void fastRemove(int index) {
		int moveIndex = arraySize - index - 1;

		if (moveIndex > 0) {
			System.arraycopy(arrayData, index + 1, arrayData, index, moveIndex);
		}
		arrayData[--arraySize] = null;
	}
}
