
public class progr1 {

	
	/*progr1(int st_id,int st_no)
	{
		st_id=st_id;
		st_no=st_id;
		System.out.println(st_id);
	} */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("message1");
		int[] arr=new int[4];
		arr[0]=10;
		arr[1]=12;
		arr[2]=14;
		arr[3]=15;
	
		int i;
		i=arr.length;
		System.out.println("array length :"+i);
		for(i=0; i<=arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	
}
