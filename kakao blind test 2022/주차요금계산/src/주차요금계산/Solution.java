package 주차요금계산;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Solution {

	int basicMin;
	int basicMoney;
	
	int plusMin;
	int plusMoney;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
////		System.out.println(Math.ceil(1.1));
////		System.out.println(Math.ceil(4.02));		System.out.println(Math.ceil(1.4));
//
//
//		Solution s=new Solution();
//		s.solution(new int[] {180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
//	}
	
	  public int[] solution(int[] fees, String[] records) {
		  
		  basicMin=fees[0];
		  basicMoney=fees[1];
		  plusMin=fees[2];
		  plusMoney=fees[3];
		  
		  Map<String,Car> carMap=new HashMap<String, Solution.Car>();
		  
		  for(int i=0; i<records.length; i++) {
			  String record=records[i];
			  String recordSplit[]=record.split(" ");
			  String time=recordSplit[0];
			  String carNumber=recordSplit[1];
			  String state=recordSplit[2];
			  
			  if(state.equals("IN")) {
				  
				  if(carMap.containsKey(carNumber)) {
					  Car car=carMap.get(carNumber);
					  car.update(time);
				  }else {
					  Car car=new Car(carNumber,time);
					  carMap.put(carNumber, car);
				  }
				  
			  }else {
				  //존재가정
				  Car car=carMap.get(carNumber);
				  car.updateTotalMin(time);
			  }
			  
		  }
		  
		 List<Car> answerList=new ArrayList<Car>();
		 
		 
		 Set<String> sets=carMap.keySet();
		 Iterator<String> iterator=sets.iterator();
		 while(iterator.hasNext()) {
			 String key=iterator.next();
			 Car car=carMap.get(key);
			 
			 if(car.state) {
				 //true인 상태에서 끝난경우
				 car.updateTotalMin("23:59");
			 }
			 
			 car.calculate();
			 answerList.add(car);
		 }
		 
		 Collections.sort(answerList,(a,b)->Integer.parseInt(a.carNumber)-Integer.parseInt(b.carNumber));
		 int[] answer = new int[answerList.size()];
		 
		 for(int i=0; i<answerList.size(); i++) {
			 answer[i]=answerList.get(i).cal;
		 }
		 
		
		 
		
		  
		  
		  
		  System.out.println(Arrays.toString(answer));
		  
		  
	       
	        return answer;
	  }

	  class Car{
		   String carNumber;
		   String inTime;
		   int totalMin=0; //총분
		   
		   int cal=0;
		   
		   boolean state; //true면 in , false 면 out
		   
		   public Car(String carNumber,String inTime) {
			   this.carNumber=carNumber;
			   this.inTime=inTime;
			   this.state=true; // 처음에는 In
		   }
		   
		   public void update(String inTime){
			   this.inTime=inTime;
			   this.state=true;
		   }
		   
		   public void updateTotalMin(String outTime) {
			   //intTime = 06 : 30
			   //outTime = 13 : 27
			   String inTimeSplit[]=inTime.split(":");
			   String outTimeSplit[]=outTime.split(":");
			   
			   //System.out.println(Arrays.toString(inTimeSplit)  +" , "+Arrays.toString(outTimeSplit));
				  
			   totalMin+=( (Integer.parseInt(outTimeSplit[0]) -Integer.parseInt(inTimeSplit[0]))*60 )+(Integer.parseInt(outTimeSplit[1]) - Integer.parseInt(inTimeSplit[1]));
			  // System.out.println(( (Integer.parseInt(outTimeSplit[0]) -Integer.parseInt(inTimeSplit[0]))*60 )+(Integer.parseInt(outTimeSplit[1]) + Integer.parseInt(inTimeSplit[1])));
			  // System.out.println("totalMinUpdate ! "+this.carNumber+" : "+" totalMin : "+totalMin);
			   state=false; //out 했어~
			   
		   }
		   
		   public void calculate() {
			   //System.out.println(this.carNumber+" : "+" totalMin : "+totalMin);
			   
			   if(totalMin<=basicMin) {
				   cal=basicMoney;
			   }
			   else {
				   cal=basicMoney;
				   totalMin=totalMin-basicMin;
				   
				  // System.out.println((int)Math.ceil((double)totalMin/plusMin)+" , "+(double)totalMin/plusMin);
				   cal+=(int)Math.ceil((double)totalMin/plusMin)*plusMoney;
				   
			   }
		   }
		   
	  }
}
