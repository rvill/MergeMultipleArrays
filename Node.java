/*
 * rvill@mit.edu
   copyright(c) 2013
 */



package pset4b;



public class Node<T extends Comparable<? super T>>
implements Comparable<Node<T>> {

	//protected Node2<T> left, right;
	protected T element;
	public static int  size;
	public static int  t[] = new int[size];



	public Node(T obj) {
		element = obj;
	}

	@Override
	public int compareTo(Node<T> node) {
		return element.compareTo(node.element);
	}


	public static int sizeOfArray(){

		return t.length;
	}
}




