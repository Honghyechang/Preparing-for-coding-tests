package 주차요금계산_92341;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	int basicTime;
	int basicMoney;
	int exceedTime;
	int exceedMoney;

//	public static void main(String[] args) {
//		System.out.println(Math.ceil(1.1)+" : "+Math.ceil(1.0));
//		
//	Solution s=new Solution();
//	s.solution(new int[] {180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
//}

  public int[] solution(int[] fees, String[] records) {
		 basicTime=fees[0];
		 basicMoney=fees[1];
		 exceedTime=fees[2];
		 exceedMoney=fees[3];
		 
//		 System.out.println(basicTime + " : "+basicMoney);
//		 System.out.println(exceedTime + " : "+exceedMoney);
		 Map<String,Car> carMap=new HashMap<String, Solution.Car>();
		 
		 for(String record : records) {
			 String split[]=record.split(" ");
			 String time=split[0];
			 String carNumber=split[1];
			 String type=split[2];
			 
			 String timeSplit[]=time.split(":");
			 int timeInt= (Integer.parseInt(timeSplit[0])*60)+(Integer.parseInt(timeSplit[1]));
			 
			 if(type.equals("IN")) {
				 
				 if(!carMap.containsKey(carNumber)) {
					 carMap.put(carNumber, new Car(timeInt,carNumber));
				 }else {
					 carMap.get(carNumber).setInputTime(timeInt);
				 }
				
			 }else {
				 carMap.get(carNumber).setOutputTime(timeInt);
			 }
		 }
		 
		 List<Car> answerList=new ArrayList<Car>();
		 for(String carNumber : carMap.keySet()) {
			 Car car=carMap.get(carNumber);
			 car.calculate();
			 answerList.add(car);
		 }
		 int answer[]=answerList.stream()
				 				.sorted((a,b)->{
				 					return Integer.parseInt(a.carNumber)-Integer.parseInt(b.carNumber);
				 				})
				 				.map((car)->car.getCal())
				 				.mapToInt(i->i.intValue())
				 				.toArray();
		 System.out.println(Arrays.toString(answer));
		 
		 return answer;
  }
  
  class Car{
	  int inputTime;
	  int outputTime;
	  String carNumber;
	  int cal;
	  //누적타임
	  int totalTime=0;
	  
	  public Car(int inputTime,String carNumber) {
		  this.inputTime=inputTime;
		  this.carNumber=carNumber;
		  outputTime=0;
	  }
	  
	  public void setInputTime(int intputTime) {
		  this.inputTime=intputTime;
		  this.outputTime=0;
	  }
	  
	  public void setOutputTime(int outputTime) {
		  this.outputTime=outputTime;
		  totalTime+=outputTime-inputTime;
	  }
	  
	  public void calculate() {
		  
		  if(outputTime==0) {
			  outputTime=23*60 + 59;
			  int time=outputTime-inputTime;
			  totalTime+=time;
		  }
		  
		  
		  if(this.totalTime<=basicTime) {
			  this.cal=basicMoney;
			  return;
		  }
		  int money=basicMoney;
		  totalTime-=basicTime;
		  int plusMoney=((int)Math.ceil((double)totalTime/exceedTime))*exceedMoney;
		  this.cal= money+plusMoney;
		  
	  }
	  
	  public int getCal() {
		  return this.cal;
	  }

}

	  
  }
  
 