import java.util.ArrayList;
import java.util.HashSet;

public class TestProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[]={1,2,2,4,4,5};
		int a2[]={6,7,1,2,8};
		
		//1,2,4,5,6,7,8
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		for(int i=0;i<a1.length;i++){
			al.add(a1[i]);
			
		}
		for(int i=0;i<a2.length;i++){
			
			al.add(a2[i]);
		}
		int i;
		
		HashSet<Integer> hs=new HashSet<Integer>();
		System.out.println(al);
		for(i=0;i<al.size();i++){
			
			hs.add(al.get(i));
		}
		System.out.print("Unique list-"+hs+" ");
		
	}

}
