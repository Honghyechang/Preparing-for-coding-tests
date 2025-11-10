package 비밀코드해독_388352;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	//List<int[]> collraboration=new ArrayList<int[]>();
	int answer=0;

	List<List<Integer>> quest=new ArrayList<List<Integer>>();
	
	int answerQuest[];
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	Solution s=new Solution();
//	s.solution(10, new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}}, new int[] {2, 3, 4, 3, 3});
//
//}

 public int solution(int n, int[][] q, int[] ans) {
	 
	 //1부터 n까지 5개의 조합을 모두 구해본다.
	 int arr[]=new int[n];
	 for(int i=0; i<arr.length; i++) {
		 arr[i]=i+1;
	 }
	 
	 for(int qarr[] : q) {
		 quest.add( Arrays.stream(qarr).boxed().collect(Collectors.toList()));
	 }
	 
	 answerQuest=ans;
	 
	 getCol(arr,0,0,new int[5]);
	 System.out.println(answer);
	 return answer;
	 
	 
 }
 
 public void getCol(int arr[] , int index ,int nextIndex ,int select[]) {
	 if(index==5) {
		 if(isPossible(select)) {
			 answer++;
		 }
		 return;
	 }
	 //나머지가 내가 원하는 사이즈 보다 작다면
	 int remainIndex=5-index; // index가1이라면 4개를 앞으로 더 구해야하는데,
	 int remainArr=arr.length-nextIndex;
	 if(remainIndex > remainArr) {
		 return;
	 }
	 
	 for(int i=nextIndex; i<arr.length; i++) {
		 select[index]=arr[i];
		 getCol(arr,index+1,i+1,select);
	 }
	 
	 
 }
 public boolean isPossible(int select[]) {
	 
	 List<Integer> selectList=Arrays.stream(select).boxed().collect(Collectors.toList());
	 
	 for(int i=0; i<quest.size(); i++) {
		
		 List<Integer>compare=new ArrayList<Integer>(quest.get(i));
		 compare.retainAll(selectList);
		 int want=answerQuest[i];
		 if(compare.size()!=want) {
			 return false;
		 }
		
	 }
	 return true;
	 
 }

}
