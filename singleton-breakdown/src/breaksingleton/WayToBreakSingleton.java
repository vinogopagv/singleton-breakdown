package breaksingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * Class to execute Singleton logic Break down
 * @author Vinothkumar
 *
 */
public class WayToBreakSingleton {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
		SingletonSample originalSingleton = SingletonSample.getInstance();
		SingletonSample duplicateSingleton = SingletonSample.getInstance();
		
		System.out.println("Original Instance hashcode:"+originalSingleton.hashCode());
		System.out.println("Duplicate Instance hashcode:"+duplicateSingleton.hashCode());
		System.out.println("------------------------------------------------------------");
		
		//Reflection
		System.out.println("Breaking Using Reflection:");
		Class<?> singletonClass = Class.forName("breaksingleton.SingletonSample");
		Constructor<SingletonSample> cons = (Constructor<SingletonSample>) singletonClass.getDeclaredConstructor();
		cons.setAccessible(true);
		
		SingletonSample singletonBreakUsingReflectionIns = cons.newInstance();
		System.out.println("Original Instance:"+originalSingleton.hashCode());
		System.out.println("Singleton Breakon Using Reflection Ins is :"+singletonBreakUsingReflectionIns.hashCode());
		
		//Serialization
		
		System.out.println("------------------------------------------------------------");
		System.out.println("Breaking Using Serialization:");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:/Serialization.ser"));
		out.writeObject(originalSingleton);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:/Serialization.ser"));
		SingletonSample brokenSingleObjUsingDeserialize =  (SingletonSample) in.readObject();
		in.close();
		
		System.out.println("Original Instance:"+originalSingleton.hashCode());
		System.out.println("Singleton Broken Using Serialization Ins is: "+brokenSingleObjUsingDeserialize.hashCode());
		
		//Cloning
		System.out.println("------------------------------------------------------------");
		System.out.println("Breaking Using Clone:");
		
		SingletonSample brokenClone = (SingletonSample) originalSingleton.clone(); 
		
		System.out.println("Original Instance:"+originalSingleton.hashCode());
		System.out.println("Singleton Broken Using Clone Ins is: "+brokenClone.hashCode());
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
