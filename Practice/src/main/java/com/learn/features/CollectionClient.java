package com.learn.features;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CollectionClient {
	private Comparator<ZonedDateTime> comp = Comparator.comparingLong((input) -> input.toInstant().toEpochMilli()); 
	private ConcurrentSkipListMap<ZonedDateTime, String> skipMap = new ConcurrentSkipListMap<>(comp);
	
	
	private ConcurrentSkipListSet<ZonedDateTime> skipList = new ConcurrentSkipListSet<>();
	
	public static void main(String[] args) {
		CollectionClient client = new CollectionClient();
		client.produceByCallable();
		
		client.printMap(client.tailMap(), "Tail Map: ");
		client.printMap(client.headMap(), "Head");
		
	}
	
	public void printMap(ConcurrentNavigableMap<ZonedDateTime, String> map, String message)  {
		System.out.println("****************************");
		System.out.println(message);
		map.entrySet().forEach(entry -> {
			System.out.println(entry.getKey().toString()+"\n"+entry.getValue());
		});
		
	}

	public ConcurrentNavigableMap<ZonedDateTime, String> tailMap() {
		return skipMap.tailMap(ZonedDateTime.now().minusMinutes(1));
	}
	
	public ConcurrentNavigableMap<ZonedDateTime, String> headMap() {
		return skipMap.headMap(ZonedDateTime.now().minusMinutes(1));
	}
	
	
	public void acceptEvent(Event event) {
		skipMap.put(event.getZoneDate(), UUID.randomUUID().toString());
		System.out.println(skipMap);
	}
	
	
	public void produceEvent() {
		ExecutorService service = Executors.newFixedThreadPool(3);
		Runnable producer = () -> IntStream.rangeClosed(1, 100)
				.forEach(index -> acceptEvent(new Event(ZonedDateTime.now().minusSeconds(index), UUID.randomUUID().toString())));
		for(int index =0; index<2; index++) {
			service.execute(producer);
		}
		
		
		try {
			if(!service.awaitTermination(60, TimeUnit.SECONDS)) {
				service.shutdown();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public void produceByCallable() {
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		
		Callable<Integer> producer = () -> {
			IntStream.rangeClosed(1, 10).forEach(index -> acceptEvent(new Event(ZonedDateTime.now().minusSeconds(index), UUID.randomUUID().toString())));
			return 1;
		};
			
		List<Future<Integer>> future = new ArrayList<Future<Integer>>();
		for(int index =0; index<2; index++) {
			future.add(service.submit(producer));			
		}
		future.forEach(input -> {
			try {
				int test = input.get();
				System.out.println(test);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});

		
		try {
			if(service.awaitTermination(10, TimeUnit.SECONDS)) {
				service.shutdown();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


class Event{
	private ZonedDateTime zoneDate;
	private String value;
	
	public Event(ZonedDateTime zoneDate, String value) {
		super();
		this.zoneDate = zoneDate;
		this.value = value;
	}
	/**
	 * @return the zoneDate
	 */
	public ZonedDateTime getZoneDate() {
		return zoneDate;
	}
	/**
	 * @param zoneDate the zoneDate to set
	 */
	public void setZoneDate(ZonedDateTime zoneDate) {
		this.zoneDate = zoneDate;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Event [zoneDate=" + zoneDate + ", value=" + value + "]";
	} 
	
}
