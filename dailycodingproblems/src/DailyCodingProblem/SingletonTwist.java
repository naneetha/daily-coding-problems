package DailyCodingProblem;

import java.io.Serializable;

/**
 * This problem was asked by Microsoft.
 *  Implement the singleton pattern with a twist. First, 
 *  instead of storing one instance, store two instances.
 *   And in every even call of getInstance(), 
 *   return the first instance and in every odd call of 
 *   getInstance(), return the second instance.
 * @author anee
 *
 */
public class SingletonTwist {
	public static void main(String[] args) {
		SingletonInstance.getInstance();
		SingletonInstance.getInstance();
		SingletonInstance.getInstance();
		SingletonInstance.getInstance();
	}
}
final class SingletonInstance implements Cloneable, Serializable{
	private static final long serialVersionUID = 42L;
	private static int count;
	private volatile static SingletonInstance evenInstance;
	private volatile static SingletonInstance oddInstance;
	private SingletonInstance()
	{
		 // Safeguard against reflection
        if (evenInstance != null || oddInstance != null) {
            throw new RuntimeException("Use getInstance() instead");
        }
	}
	public static  synchronized SingletonInstance getInstance()
	{
		System.out.println("Call Count : "+ count);
		if(count%2 == 0)
		{	
			System.out.println("Even Instance : "+ getSecondInstance());
			++count;
			return getSecondInstance();
		}
		System.out.println("Odd Instance : "+ getFirstInstance());
		++count;
		return getFirstInstance();
	}
	
	private static  SingletonInstance getFirstInstance()
	{
			if(evenInstance == null )
			{	
				synchronized(SingletonInstance.class) {
				if(evenInstance == null )
					{
					 evenInstance =  new SingletonInstance();
					}
				}
			}
		
			return evenInstance;
		
	}
	private static SingletonInstance getSecondInstance()
	{
			if(oddInstance == null )
			{	
				synchronized(SingletonInstance.class) {
				if(oddInstance == null )
					{
					oddInstance =  new SingletonInstance();
					}
				}
			}
	
			return oddInstance;
		
	}
	// Make singleton from deserializaion
    protected SingletonInstance readResolve() {
        return getInstance();
    }
	 @Override
	    protected Object clone() throws CloneNotSupportedException {
	        throw new CloneNotSupportedException("Use getInstance() instead");
	    }
	
}