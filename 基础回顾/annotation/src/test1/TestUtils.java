package test1;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestUtils {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		TestTest test = new TestTest();
		run(test);
	}
	
	public static void run(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for(Method m:obj.getClass().getMethods()) {
			Test t = m.getDeclaredAnnotation(Test.class);
			if(t!=null && !t.ignore()) {
				m.invoke(obj);
			}
		}
	}
}
