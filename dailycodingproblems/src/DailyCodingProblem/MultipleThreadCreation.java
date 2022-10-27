package DailyCodingProblem;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleThreadCreation {

	
	private void solution(int a, int b, int c, int d)
	{
		ExecutorService executor =  Executors.newFixedThreadPool(2);
		Callable<Integer> thread1 = ()->
		{
			int sum =  a+b;
			return sum;
		};
		
		
		Callable<Integer> thread2 = ()->
		{
			int sum =  c+d;
			return sum;
		};
		
		Future<Integer> f1 = executor.submit(thread1);
		Future<Integer> f2 = executor.submit(thread2);
		try
		{
			System.out.println(f1.get()*f2.get());
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		catch(ExecutionException e)
		{
			e.printStackTrace();
		}
		finally
		{
			executor.shutdown();
		}
		
		
	}
	
	public static void main(String[] args) {
		new MultipleThreadCreation().solution(1,2,3,4);
	}
}
