//Yonatan Rubin
//M21105076

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	private static final int NUM_ACTIONS = 6;
	Queue<Integer> directionQueue = new LinkedList<Integer>();

	/**
	 * 3. In your constructor, place 5 or 6 numbers in the queue so that when the
	 * animation starts – there will be something to retrieve from the queue
	 */
	CarQueue() {
		for (int i = 0; i < NUM_ACTIONS; ++i) {
			// add a number between 0 and 3 to the queue
			this.directionQueue.add(this.generateNewAction());
		}

	}

	/**
	 * 1. There is an addToQueue method that has a class that implements runnable,
	 * define the run method (add random directions into the queue and then sleep),
	 * creates an instance of the runnable object, creates a thread and starts the
	 * thread. Adds 0,1,2 or 3 to queue 0 = up 1 = down 2 = right 3 = left
	 */
	public void addToQueue() {
		class MyRunnable implements Runnable {

			@Override
			public void run() {
				try {
					while (true) {
						directionQueue.add(generateNewAction());
						Thread.sleep(1000);
					}
				} catch (InterruptedException exception) {

				} finally {

				}

			}

		}
		Thread t = new Thread(new MyRunnable());
		t.start();
	}

	/**
	 * 2. It also has a deleteQueue method that returns an Integer;
	 * 
	 * @return
	 */
	public int deleteQueue() {
		return this.directionQueue.poll();
	}

	/**
	 * HELPER METHOD, NOT PART OF ASSIGNMENT
	 * 
	 * generates an int between 0 and 3
	 * 
	 * @return an int between 0 and 3
	 */
	public int generateNewAction() {
		// get a new random number, make it an int,
		// make it between 0-3
		return (new Random().nextInt(4));
	}
}
