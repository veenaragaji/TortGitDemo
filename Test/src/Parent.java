
public class Parent {
	 int x;
	int y;
	 Parent(){
		x=12;
		y=13;
	}
	
	
	static void add(){
		int c=10;
		System.out.println("Parent add method");
	}
	void sub(){
		System.out.println("Parent sub");
	}
	
	public static void main(String args[]){
		Parent p=new Parent();
		
		p.add();
		Parent p1=new Parent();
		p1.add();
		
	}
}
