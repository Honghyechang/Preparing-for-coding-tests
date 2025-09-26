package 비밀코드해독_388352;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	List<int[]> collaboration=new ArrayList<int[]>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s=new Solution();
		s.solution(10, new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}}, new int[] {2, 3, 4, 3, 3});

	}
	
	 public int solution(int n, int[][] q, int[] ans) {
		 makeFive(n,0,0,new int[5]);
		 
//		 System.out.println("test");
//		 System.out.println(Arrays.toString(collaboration.get(collaboration.size()-1)));
//			
		 
		 
		 for(int i=0; i<q.length; i++) {
			 int qeustion[]=q[i];
			 int answer=ans[i];
			 List<int[]> live=new ArrayList<int[]>();
			// System.out.println(Arrays.toString(qeustion)+"검사 시작");
			 
			 for(int[] arr : collaboration) {
				 int count=0;
				 //arr을 List바꿔서 contains함수사용하기.
				// System.out.println(Arrays.toString(arr));
				 List<Integer> arrList=Arrays.stream(arr)
						 					 .boxed()
						 					 .collect(Collectors.toList());
				// System.out.println(arrList.toString());
				 for(int m : qeustion) {
					 if(arrList.contains(m)) {
						count++; 
					 }
				 }
				 if(count==answer) {
				//	 System.out.println(Arrays.toString(arr));
					 live.add(arr);
				 }
			 }
			// System.out.println((i+1)+"단계 ->"+collaboration.size()+"에서 "+live.size()+"만큼만 살아남았다.");
			 collaboration.retainAll(live);
			 
			// System.out.println();
			 //System.out.println();
		 }

		 System.out.println("최종 사이즈 : "+collaboration.size());

		 return collaboration.size();
	  }

	 
	 
	 public void makeFive(int n,int start,int depth,int[] current) {
		 
		 int sizeA=n-start;//남아있는 숫자

		 int sizeB=5-depth;//필요한 숫자
		 
		 if(sizeA<sizeB) {
			 return;
		 }
		 
		 
		 if(depth==5) {
//			 String str=Arrays.stream(current)
//					 		  .mapToObj((i)->i+"")
//					 		  .collect(Collectors.joining());
			 collaboration.add(current.clone());
			// System.out.println(Arrays.toString(collaboration.get(collaboration.size()-1)));
			// System.out.println(str);
			 return;
		 }
		 
		 for(int i=start; i<n; i++) {
			 current[depth]=i+1;
			 makeFive(n,i+1,depth+1,current);
		 }
		 
	 }
	
}
