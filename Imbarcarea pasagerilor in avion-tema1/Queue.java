

import java.io.PrintWriter;

/**
 * @author Savu Ioana Rusalda -325CB
 *
 */
public class Queue {
	private Passenger[] _heap;
	int _size;
	private int maxSize;
	PrintWriter writer;

	public Queue(int maxSize, PrintWriter writer) {
		this.writer = writer;
		this.maxSize = maxSize;
		this._size = 0;
		_heap = new Passenger[this.maxSize + 1];

	}

	/**
	 * Metoda calculeaza pozitia in vector a parintelui unui nod
	 * 
	 * @param pos pozitia copilului
	 * @return returneaza pozitia parintelui
	 */
	private int parent(int pos) {
		return pos / 2;
	}

	/**
	 * Metoda calculeaza pozitia in vector a copilului stang
	 * 
	 * @param pos pozitia parintelui
	 * @return returneaza pozitia copilului stang
	 */
	private int leftChild(int pos) {
		return (2 * pos);
	}

	/**
	 * Metoda calculeaza pozitia in vector a copilului drept
	 * 
	 * @param pos pozitia parintelui
	 * @return returneaza pozitia copilului drept
	 */
	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	/**
	 * Metoda verifica daca un nod este frunza
	 * 
	 * @param pos pozitia nodului
	 * @return returneaza "true" daca nodul este frunza
	 */
	private boolean isLeaf(int pos) {
		if (pos > (_size / 2) && pos <= _size) {
			return true;
		}
		return false;
	}

	/**
	 * Metoda interschimba 2 elemente din vector
	 * 
	 * @param fpos pozitia primului element
	 * @param spos pozitia celui de-al doilea element
	 */
	private void swap(int fpos, int spos) {
		Passenger aux;
		aux = _heap[fpos];
		_heap[fpos] = _heap[spos];
		_heap[spos] = aux;
	}

	/**
	 * Metoda rearanjeaza heap.ul asfel incat sa se respecte conditia de maxheap
	 * 
	 * @param pos pozitia curenta
	 */
	private void maxHeapify(int pos) {
		if (isLeaf(pos))
			return;

		if (((_heap[leftChild(pos)] != null) && (_heap[pos].getPriority() < _heap[leftChild(pos)].getPriority()))
				|| ((_heap[rightChild(pos)] != null)
						&& _heap[pos].getPriority() < _heap[rightChild(pos)].getPriority())) {

			if (_heap[rightChild(pos)] == null) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			} else {
				if (_heap[leftChild(pos)].getPriority() >= _heap[rightChild(pos)].getPriority()) {
					swap(pos, leftChild(pos));
					maxHeapify(leftChild(pos));
				}

				else {
					if (_heap[rightChild(pos)] != null) {
						swap(pos, rightChild(pos));
						maxHeapify(rightChild(pos));
					}
				}
			}
		}
	}

	/**
	 * Metoda introduce un pasager in heap
	 * 
	 * @param p        pasagerul ce trebuie introdus
	 * @param priority prioritatea pasagerului
	 */
	public void insert(Passenger p, int priority) {
		_heap[++_size] = p;

		int current = _size;
		if (_size != 1)
			while (current != 1 && parent(current) != 0
					&& (_heap[current].getPriority() > _heap[parent(current)].getPriority())) {

				swap(current, parent(current));
				current = parent(current);
			}
	}

	/**
	 * Metoda afiseaza in fisier coada de prioritate
	 */
	public void list() {
		list1(1);
		this.writer.print("\n");
	}

	public void list1(int index) {

		if (index > _size) {
			return;
		}
		this.writer.print(_heap[index].getId() + " ");

		list1(2 * index);
		list1(2 * index + 1);
	}

	/**
	 * Metoda elimina root-ul cozii de prioritate
	 * 
	 * @return returneaza pasagerul eliminat
	 */
	public Passenger embark() {
		Passenger max = _heap[1];
		_heap[1] = _heap[_size];
		_heap[_size] = null;
		_size--;
		maxHeapify(1);
		return max;
	}
}
