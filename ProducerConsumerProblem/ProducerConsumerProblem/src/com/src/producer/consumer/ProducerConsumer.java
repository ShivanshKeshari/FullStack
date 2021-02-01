package com.src.producer.consumer;

import java.util.LinkedList; 

public class ProducerConsumer {

	
	  
	
	    public static void main(String[] args) 
	        throws InterruptedException 
	    { 
	    	   
	        final ProdCons pc = new ProdCons(); 
	  
	     // Create producer thread 
	        Thread t1 = new Thread(new Runnable() { 
	            @Override
	            public void run() 
	            { 
	                try { 
	                    pc.produce(); 
	                } 
	                catch (InterruptedException e) { 
	                System.out.println(e.getMessage());
	                } 
	            } 
	        }); 
	  
	        // Create consumer thread 
	        Thread t2 = new Thread(new Runnable() { 
	            @Override
	            public void run() 
	            { 
	                try { 
	                    pc.consume(); 
	                } 
	                catch (InterruptedException e) { 
	                    System.out.println(e.getMessage());
	                } 
	            } 
	        }); 
	  
	        // Start both threads 
	        t1.start(); 
	        t2.start(); 
	  
	        // t1 finishes before t2 
	        t1.join(); 
	        t2.join(); 
	    } 
	  
	
	    public static class ProdCons { 
	  
	
	        LinkedList<Integer> list = new LinkedList<>(); 
	        int capacity = 2; 
	  
	        // Function called by producer thread 
	        public void produce() throws InterruptedException 
	        { 
	            int value = 0; 
	            while (true) { 
	                synchronized (this) 
	                { 
	                    
	                    while (list.size() == capacity) 
	                        wait(); 
	  
	                    System.out.println("Producer produced-"
	                                       + value); 
	  
	                   
	                    list.add(value++); 
	  
	                 
	                    notify(); 
	  
	                    Thread.sleep(1000); 
	                } 
	            } 
	        } 
	  

	        public void consume() throws InterruptedException 
	        { 
	            while (true) { 
	                synchronized (this) 
	                { 
	                
	                    while (list.size() == 0) 
	                        wait(); 
	  
	                    int val = list.removeFirst(); 
	  
	                    System.out.println("Consumer consumed-"
	                                       + val); 
	  
	          
	                    notify(); 
	  
	                    // and sleep 
	                    Thread.sleep(1000); 
	                } 
	            } 
	        } 
	    
	} 
}
