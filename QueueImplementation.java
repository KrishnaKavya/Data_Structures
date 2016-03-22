public class QueueImplementation {

	public int queue[];
	public int last=0,first=0, size;

	QueueImplementation(int size) {
		queue = new int[size];
		this.size = size;
	}

	public void enqueue(int element) {
		if (isFull()) {
			System.out.println("queue is full cannot perform insertion operation.");
		} else {
			queue[last++] = element;
		}
	}

	public void dequeue() {
		if (isEmpty()) {
			System.out.println("queue is empty cannot perform deletion operation.");
		} else {
			System.out.println(queue[first]);
			first++;
		}

	}

	public boolean isEmpty() {
		return false;
	}

	public boolean isFull() {
		return false;
	}

	public static void main(String[] args) {

	}

}
