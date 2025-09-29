package 주사위고르기_258709;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
	
	
	int answer[];
	
	//sum 이 key, 그 개수 value;
	Map<Integer,Integer> playerOne=new HashMap<Integer, Integer>();
	Map<Integer,Integer> playerTwo=new HashMap<Integer, Integer>();
	
	Game maxGame;
	boolean isFindMax=false;
	
	class Game{
		
		int win,lose,draw;
		public Game(int win, int lose,int draw) {
			this.win=win;
			this.lose=lose;
			this.draw=draw;
		}
		
		public double getWinable() {
			return (double)win/(win+lose+draw);
		}
		
	}
	
	enum Player{
		ONE,TWO
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new int[][]{{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}});
//	}

	
	 public int[] solution(int[][] dice) {
		 
		 	int onePersonDice=dice.length/2;
		 	//dice /2 만큼 조합을 뽑는다.
		 	collaboration(dice,new int[onePersonDice],0,0,onePersonDice);
		 	
		 
		 	answer=Arrays.stream(answer)
		 		  .map(i->i+1)
		 		  .sorted()
		 		  .toArray();
		 	System.out.println(Arrays.toString(answer));
	        return answer;
	 }
	 //조합을 구하는 경우
	 public void collaboration(int[][] dice,int select[],int start,int depth,int size) {
		 
		 int depthRemain=size-depth;
		 int diceRemain=dice.length-start;
		 if(depthRemain>diceRemain) {
			 return;
		 }
		 
		 if(depth==size) {
		//	 System.out.println("선택된 것 : "+Arrays.toString(select));
			 allSum(dice,select,select.length,0,0,Player.ONE);
			 
			 List<Integer> selectList=Arrays.stream(select)
					 						.boxed()
					 						.collect(Collectors.toList());
			 
			 List<Integer> noNselectList=new ArrayList<Integer>();
			 
			 for(int i=0; i<dice.length; i++) {
				 if(!selectList.contains(Integer.valueOf(i))) {
					 noNselectList.add(i);
				 }
			 }
			 
			 int nonSelect[]=noNselectList.stream()
					 					  .mapToInt(i -> i.intValue())
					 					  .toArray();
			 
			// System.out.println("선택되지 않은 것 : "+Arrays.toString(nonSelect));
			 allSum(dice,nonSelect,select.length,0,0,Player.TWO);
			 
			 //One과 Two 의 승률을 비교한다.
			 int win=0;
			 int lose=0;
			 int draw=0;
			 for(int oneKey : playerOne.keySet()) {
				 int oneValue=playerOne.get(oneKey);
				 
				 for(int twoKey :playerTwo.keySet()) {
					 int twoValue=playerTwo.get(twoKey);
					 
					 int values=oneValue*twoValue;
					 if(oneKey>twoKey) {
						 win+=values;
					 }else if(oneKey<twoKey) {
						 lose+=values;
					 }else {
						 draw+=values;
					 }		 
				 }
			 }
			 
			 Game game=new Game(win, lose, draw);
			 if(!isFindMax) {
				 isFindMax=true;
				 maxGame=game;
				 answer=select.clone();
				// System.out.println("최초업데이트 win : "+win + "lose : "+lose + "draw : "+draw);
			 }else {
				 if(maxGame.getWinable() < game.getWinable()) {
					 maxGame=game;
					 answer=select.clone();
				//	 System.out.println("업데이트 win : "+win + "lose : "+lose + "draw : "+draw);
						
				 }
			 }
			 
			 playerOne.clear();
			 playerTwo.clear();
			 
			 return ;
		 }
		 
		 
		 
		 for(int i=start; i<dice.length; i++) {
			 select[depth]=i;
			 collaboration(dice,select,i+1,depth+1,size);
		 }
	 }
	 
	 
	 
	 //List를 이용해서 1,2,3,4 중 1 ,2 를 뽑았다면 그것의 모든 조합의 합구하기.

	 public void allSum(int[][] dice,int select[],int size,int depth,int sum,Player player) {
		 if(depth==size) {
			 if(player==Player.ONE) {
				 playerOne.merge(sum, 1, (ov,nv)->ov+nv);
			 }else if(player==Player.TWO) {
				 playerTwo.merge(sum, 1, (ov,nv)->ov+nv);
			 }
			 
			 return;
		 }
		 
		 int [] selectDice=dice[select[depth]];
		 for(int i=0; i<selectDice.length; i++) {
			 allSum(dice,select,size,depth+1,sum+selectDice[i],player);
		 }
		 
	 }
	
}
