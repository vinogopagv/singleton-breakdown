package breaksingleton;

import java.io.Serializable;
/**
 * Idle Singleton Sample Class
 * @author Vinothkumar
 *
 */
public class SingletonSample implements Serializable, Cloneable{
	
	private static final long serialVersionUID = 1L;
	public static SingletonSample singleton;
	
	/**
	 * Private constructor for Singleton
	 */
	private SingletonSample(){
		
	}
	
	/**
	 * getInstance Method to return object
	 * @return
	 */
	public static SingletonSample getInstance() {
		if(singleton == null) {
			singleton = new SingletonSample();
		}
		return singleton;
		
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
