import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class TestClass {

		public void add(){}
		public int add(int g){
			return g;}
		
	public static void main(String[] args) {
		//System.out.println("Test");
		for(int i=5,x=0;i>0;i--,x++){
			for(int k=0;k<x;k++){
				System.out.print(" ");
			}
			for(int j=0;j<i;j++){
				
				System.out.print("*");
			}
			System.out.println();
		}
		//---------------Linked List
		LinkedList<String> object 
        = new LinkedList<String>(); 

    // Adding the elements to the 
    // linked list 
    object.add("A"); 
    object.add("B"); 
    object.addLast("C"); 

    System.out.println("Linked List"+object); 
    
    
		//----------------TreeSet----------------
				TreeSet<Integer> ts=new TreeSet<Integer>();
				ts.add(10);ts.add(4);ts.add(2);ts.add(5);
				System.out.println("TreeSET-"+ts);
				for(Integer s:ts){
					System.out.println(s);
				}
				Iterator<Integer> itr=ts.iterator();
				while(itr.hasNext()){
					System.out.println(itr.next());
				}
			
				System.out.println("HashCode-"+ts.hashCode());
				
		//----------------Linked HashSet----------------
		LinkedHashSet<Integer> lhs=new LinkedHashSet<Integer>();
		lhs.add(10);lhs.add(40);lhs.add(20);lhs.add(50);
		System.out.println("Linked HS-"+lhs);
		for(Integer s:lhs){
			System.out.println(s);
		}
		Iterator<Integer> i=lhs.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	
		System.out.println("HashCode-"+lhs.hashCode());
		//----------------HashSet----------------
		HashSet<String> obj = new HashSet<String>();
		obj.add("18");	obj.add("2");	obj.add("3");	obj.add("46");
		System.out.println("HashSet -"+obj);
		for(String s:obj){
			System.out.println(s);
		}
		Iterator<String> it=obj.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("HasSet hashcode-<String>"+obj.hashCode());
		System.out.println("Using for each-");
		 obj.forEach(System.out::println);
		//----------------ArrayList----------------
		
		ArrayList<String> al=new ArrayList<String>();
		al.add("1");al.add("2");al.add("3");al.add("4");
		System.out.println("Arraylist -"+al);
		for(String s:al){
			System.out.println(s);
		}
		
		
	}
	
	
	
	

}
