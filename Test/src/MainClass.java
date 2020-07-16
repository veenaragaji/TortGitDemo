import java.lang.reflect.Method;

public class MainClass {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Child c=new Child();
		Parent p=new Parent();
		
		p.add();
		c.add();
		
		c.sub();
		p.sub();
		//parent object storing child instance.Could not access child method but can only access overriden methods of child class
		
		Parent p1=new Child();
		p1.sub(); //Call child sub but could not access non overriden child class 
		
		p1.add();
		
		//Child c1=new Parent();
		
	
		
	
		
		
		
	}

}
