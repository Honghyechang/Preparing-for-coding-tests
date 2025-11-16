package 주사위고르기_258709;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	Solution s=new Solution();
//	s.solution(new int[][]{{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}});
//}
	 int max=Integer.MIN_VALUE;
	 int answer[];

 public int[] solution(int[][] dice) {
	 int totalDiceCount=dice.length;
	 int totalDice[]=new int[totalDiceCount];
	 for(int i=0; i<totalDice.length; i++) {
		 totalDice[i]=i+1;
	 }
	 answer=new int[totalDice.length/2];
	 getCollaboration(dice,totalDice,new int[totalDiceCount/2],0,0);
	 System.out.println(Arrays.toString(answer));
	 return answer;
 }
 

 
 //조합 구하기
 public void getCollaboration(int [][]dice, int totalDice[], int selectDice[], int selectIndex , int index) {
	 
	 if(totalDice.length/2==selectIndex) {
		// System.out.println("select : "+Arrays.toString(selectDice));
		 int notSelectDice[]=getNotSelect(totalDice, selectDice);
		 //System.out.println("notSelect : "+Arrays.toString(notSelect));
		 int winCount=winA(dice,selectDice,notSelectDice);
		 
		 if(max<winCount) {
			 max=winCount;
			 int copy[]=selectDice.clone();
			 Arrays.sort(copy);
			 answer=copy;
		 }
		 return;
	 }
	 
	 for(int i=index; i<totalDice.length; i++) {
		 selectDice[selectIndex]=totalDice[i];
		 getCollaboration(dice,totalDice,selectDice,selectIndex+1,i+1);
	 }
	 
	 
 }
 
 //select가 이기는 경우의 수
 public int winA(int [][]dice,int selectDice[],int notSelectDice[]) {
	 //selectDice[] 로부터 얻을 수 있는 합의 조합
	 Map<Integer,Integer> selectWinMap=new HashMap<Integer, Integer>();
	 Map<Integer,Integer> notSelectWinMap=new HashMap<Integer, Integer>();
	 
	 getSum(dice,selectDice,0,0,selectWinMap);
	 getSum(dice,notSelectDice,0,0,notSelectWinMap);
	 
	 int winCount=0;
	 
	 for(int selectWin : selectWinMap.keySet()) {
		 int selectValue=selectWinMap.get(selectWin);
		 
		 
		 for(int notSelectWin : notSelectWinMap.keySet()) {
			 int notSelectValue=notSelectWinMap.get(notSelectWin);
			 
			 if(selectWin > notSelectWin) {
				 winCount+=(selectValue*notSelectValue);
			 }
			 
		 }
		 
		 
	 }
	 
	 return winCount;
 }
 
 public void getSum(int [][]dice, int selectDice[],int selectIndex, int sum , Map<Integer,Integer> selectWinMap) {
	 if(selectDice.length==selectIndex) {
		 selectWinMap.merge(sum, 1, (a,b)->a+b);
		 return;
	 }
	 
	 int currentDice[]=dice[selectDice[selectIndex]-1];
	 for(int i=0; i<currentDice.length; i++) {
		 getSum(dice,selectDice,selectIndex+1,sum+currentDice[i],selectWinMap);
	 }
	 
 }
 
 public int [] getNotSelect(int totalDice[], int selectDice[]) {
	 List<Integer> totalList=Arrays.stream(totalDice)
			 						.boxed()
			 						.collect(Collectors.toList());
	 

	 List<Integer> selectList=Arrays.stream(selectDice)
			 						.boxed()
			 						.collect(Collectors.toList());
	 
	 totalList.removeAll(selectList);
	 return totalList.stream()
			 		 .mapToInt(i->i.intValue())
			 		 .toArray();
	 
 }
 
}
