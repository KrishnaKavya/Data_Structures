public class QueueImplementation {

	public int queue[];
	public int rear = -1, front = -1, size;

	QueueImplementation(int size) {
		this.queue = new int[size];
		this.size = size;
	}

	public void enqueue(int element) {
		if (isFull()) {
			System.out.println("queue is full cannot perform insertion operation.");
		} else if(rear==-1){
			front=0;
			rear=0;
			queue[rear]=element;
		}else if(rear+1<size){
			queue[++rear]=element;
		}
	}

	public void dequeue() {
		if (isEmpty()) {
			System.out.println("queue is empty cannot perform deletion operation.");
		} else{
			front++;
			if(front>rear){
				reinitialize();
			}
			
		}

	}

	private void reinitialize() {
		System.out.println("All the elements in the queue are processed. re initialising the queue");
		front=-1;
		rear=-1;
		
	}

	public boolean isEmpty() {
		if (front == -1) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (rear == size - 1 ) {
			return true;
		}
		return false;

	}
	public void display(){
		if(isEmpty()){
			System.out.println("Queue is empty");
		}else{
		for(int i= front;i<=rear;i++){
			System.out.print(queue[i]+" ");
		}
	}
	}

	public static void main(String[] args) {
		
		int size=10;
		QueueImplementation obj=new QueueImplementation(size);
		
	}

}
