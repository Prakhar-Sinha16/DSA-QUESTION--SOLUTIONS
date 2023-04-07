QUES:
Leader in an array

CODE:
public class LeadersInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {2,7,6,4,1,3};
		System.out.println(leaders(a));

	}
	
	static ArrayList<Integer> leaders(int a[]) {
		ArrayList<Integer> al = new ArrayList<>();
		int largest = Integer.MIN_VALUE;
		for(int i=a.length-1;i>=0;i--) {
			if(a[i]>largest) {
				largest = a[i];
				al.add(a[i]);
			}
		}
		Collections.sort(al, Collections.reverseOrder());
		return al;
	}

}
