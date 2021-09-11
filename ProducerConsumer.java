package lab;

public class ProducerConsumer {

	public static void main(String[] args) {
		Consumer c1 = new Consumer("Task 1");
		Producer p1 = new Producer(c1);
		Producer p2 = new Producer(c1);
		Producer p3 = new Producer(c1);
		Producer p4 = new Producer(c1);

		Thread t1 = new Thread(p1,"Producer 1");
		Thread t2 = new Thread(p2,"Producer 2");
		Thread t3 = new Thread(p3,"Producer 3");
		Thread t4 = new Thread(p4,"Producer 4");
		Thread t5 = new Thread(c1,"Consumer 1");

		t5.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();


	}
}

class Producer implements Runnable{
	int count;
	Consumer consumer;

	public Producer(Consumer consumer) {
		this.consumer = consumer;
	}

	@Override
	public void run() {
		while (true){
			synchronized (consumer) {
				try {
					Thread.sleep(1000l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(count>2){
					break;
				}
				System.out.println(Thread.currentThread().getName() + " submitted Task " + consumer.getTaskName());
				count++;
				consumer.notifyAll();
			}
		}
	}
}

class Consumer implements Runnable{
	String taskName;

	public Consumer(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskName() {
		return taskName;
	}

	@Override
	public void run() {
		while (true){
			synchronized (this){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+ " task consumed "+this.taskName);
			}
		}
	}

	
}