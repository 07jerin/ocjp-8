package com.jerin.oracle.certification.programmer.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		submit();
//		invokeAll();
		
//		basicConcurrentCollections();
		
//		blockingQueueMultiThreads();
		
//		singleThreadBlockingQueue();
		
//		copyOnWriteAL();
		
//		System.out.println(Arrays.asList("w","o","l","f")
////					.stream()
//				   .parallelStream()
//				   .reduce("",String::concat, ));		

	}

	private static void copyOnWriteAL() {
		List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4,3,52));
		for(Integer item: list) {
		   System.out.print(item+" ");
		   list.add(9);
		}
		System.out.println();
		System.out.println("Size: "+list.size());
	}

	private static void singleThreadBlockingQueue() {
		try {
			   BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>(1);

			   blockingDeque.offer(91);
			   blockingDeque.offerFirst(5, 2, TimeUnit.SECONDS);
			   blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
			   blockingDeque.offer(3, 4, TimeUnit.SECONDS);
			   // 5 91 47 3

			   System.out.println(blockingDeque.poll()); 
			   System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
			   System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS)); 
			   System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS)); 
			} catch (InterruptedException e) {
			   // Handle interruption
			}
	}

	private static void blockingQueueMultiThreads() {
		System.out.println();
		try {
			
			 ExecutorService es =  Executors.newCachedThreadPool();
			   BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(1);

			  blockingQueue.offer(39);
			  
			  Callable<Boolean> offer = () -> blockingQueue.offer(3, 10, TimeUnit.MILLISECONDS);
				  
			   
			   Callable<Void> poll = () ->  { Thread.sleep(100); System.out.println(blockingQueue.poll(2, TimeUnit.MILLISECONDS)); return null;}; 
			   
			   es.submit(offer);
			   es.submit(poll);
			   es.submit(poll);
			   es.submit(poll);
			   
			   
			   es.shutdown();
			  
			   
			} catch (Exception e) {
			   // Handle interruption
			}
	}

	private static void basicConcurrentCollections() {
		Map<String,Integer> map = new ConcurrentHashMap<>();
		map.put("zebra", 52);
		map.put("elephant", 10);
		System.out.println(map.get("elephant")); //10
		
		Queue<Integer> queue = new ConcurrentLinkedQueue<>();
		queue.offer(31);
		System.out.println(queue.peek()); //31
		System.out.println(queue.poll()); //31
		Deque<Integer> deque = new ConcurrentLinkedDeque<>();

		deque.offer(10);
		deque.push(4);
		System.out.println(deque.peek()); //4
		System.out.println(deque.pop()); // 4
	}

	private static void invokeAll() throws InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(4);
		Callable<String> c1= () -> {
				Thread.sleep(1000);
			System.out.println("Run  " + Thread.currentThread().getName());
			return "ONE";
		};
		
		Callable<String> c2= () -> {
				Thread.sleep(1000);
			System.out.println("Run  " + Thread.currentThread().getName());
			return "TWO";
		};
		List<Callable<String>> ls = new ArrayList<Callable<String>>();
		ls.add(c1);
		ls.add(c2);
		ls.add(c2);
		
//		String ret = es.invokeAny(ls);
		List<Future<String>> ret = es.invokeAll(ls);
		System.out.println(ret);
		System.out.println("After invoke");
		
		es.shutdown();
		System.out.println("After shutdown");

//		System.out.println(ru.get());
	}

	private static void submit() {
		ExecutorService es = Executors.newFixedThreadPool(4);
		System.out.println("Start " + Thread.currentThread().getName());
		es.execute(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("In first Thread " + Thread.currentThread().getName());
		});

		es.execute(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread 2 " + i + Thread.currentThread().getName());
			}
		});

		es.shutdown();
		System.out.println(es.isShutdown() + " : " + es.isTerminated());
		System.out.println("End " + Thread.currentThread().getName());
	}

}
