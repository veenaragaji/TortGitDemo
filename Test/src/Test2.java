import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Test2 {

	public static void main(String[] args) {
		String s="Veeena Ragaji";
		//unique and duplicate chars
		//e=2  v=1 
		//total dupliate count =1 and unique char count
		
		int l=s.length();
		//int c=0;
		ArrayList<Character> a=new ArrayList<Character>();
		ArrayList<Character> b=new ArrayList<Character>();
		HashSet<Character> hs=new HashSet();
		HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
		//int c;
		for(int i=0;i<l;i++){
			int c=1;
			if(!(s.charAt(i)==' ')){
				
				
				if(!a.contains(s.charAt(i))){
					a.add(s.charAt(i));
				}
				if(!b.contains(s.charAt(i))){
				for(int j=i+1;j<l;j++){
					if(s.charAt(i)==s.charAt(j) ){
						c++;
						System.out.println(s.charAt(i)+"-"+c);
						if(!b.contains(s.charAt(i))){
							b.add(s.charAt(i));
						}
					}
				
				}
				hm.put(s.charAt(i), c);
				
				}
				if(!b.contains(s.charAt(i)))
					hs.add(s.charAt(i));
			}
			
		}
		System.out.println("Duplicate elements count-"+b.size());
		
		//System.out.println("Duplicate elements count-"+b.size());
		System.out.println(hm);
		System.out.println("Uniques characters-"+hs+" Count-"+hs.size());
		System.out.println("Uniques characters-"+a+" Count-"+a.size());
	}

}
