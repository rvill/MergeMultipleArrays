/*
 * rvill@mit.edu
   copyright(c) 2013
 */



package pset4b;
import java.util.NoSuchElementException;

// Max heap with usual compareTo()
// Heap capacity must be set large enough by user. Add grow() method later.

// With node 0 as root, parent/left/right aren't as elegant as with node 1:
//   Parent(i)= (i-1)/2
//   Left(i)= 2i+1
//   Right(i)= 2i+2

// We implement adjust() inline in delete, heapify and heapsort since
// delete is an instance method and the other two are static



public class MinHeap {
	@SuppressWarnings("unchecked")
	private Comparable[] data;
	private int size; 		// Actual number of elements in heap
	private int capacity;
	private static final int DEFAULT_CAPACITY= 30;

	public MinHeap(int capacity) {
		data = new Comparable[capacity];
		this.capacity= capacity;			// size= 0
	}
	public MinHeap() {
		this(DEFAULT_CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public MinHeap(Comparable[] c) {
		data= c;
	//	heapify(data);
		capacity= size= data.length;
	}
	@SuppressWarnings("unchecked")
	public void insert(Node item) {
		if (size == 0) {
			size= 1;
			data[0]= item;
		} else {
			if (size == data.length)
				grow();
			int i = size++; 				// Increase no of elements
			while (i > 0 && (data[(i-1)/2].compareTo(item) > 0)) { 
				data[i] = data[(i-1)/2]; 	// Move parent item down
				i = (i-1)/2; 				// Go up one level in heap
			}
		data[i] = item; 					// Drop item into correct place in heap
		}
	}	
	@SuppressWarnings("unchecked")
	public Comparable delete() throws NoSuchElementException {
		if (size == 0)
			throw new NoSuchElementException();
		Comparable retValue = data[0];	// Top element is removed and returned
		// Put the last element at the top (element 0) and bubble it down
		Comparable item = data[0] = data[--size]; 	
		int j = 1; 						// Look at right and left children of top node
		while (j < size) {
			// Compare left and right child and let j be larger child
			if ((j+1 < size) && (data[j].compareTo(data[j + 1]) > 0))
				j++;
			if (item.compareTo(data[j]) < 0) 
				break; 								// Position for item found
			data[(j-1) / 2] = data[j];				// Else put child data in parent node
			j = 2*j+1;								// Move down to next level of heap
		}
		data[(j-1) / 2] = item;						// Drop last element into correct place
		return retValue;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size==0);
	}
	
	private void grow() {
		capacity *= 2;
		Object[] oldData = data;
		data = new Comparable[capacity];
		System.arraycopy(oldData, 0, data, 0, oldData.length);
	}
	
/*	public static void main(String[] args) {
		System.out.println("Heap");
		MinHeap2 h= new MinHeap2(4);		// Use small capacity to test grow() method
		h.insert("b");
		h.insert("d");
		h.insert("f");
		h.insert("a");
		h.insert("c");
		h.insert("e");
		h.insert("g");
		h.insert("h");
		h.insert("i");
		String top = null;
		while (h.getSize() > 0) {
			top= (String) h.delete();
			System.out.println(" "+ top);
		}

	} */
}
