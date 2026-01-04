package day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution1 s=new Solution1();
//		s.solution(5);
//	}

	public int[] solution(int n) {
	//총 3단계를 거친다.	
	//밑으로 쭉 내려오기, 
	//오른쪽으로 쭉 가기
	//대각선의로 쭉 올라가기
	
	int arr[][]=new int[n][n];
	int y=0;
	int x=0;
	int number=1;
	
	int targetNumber=0;
	for(int i=1;i<=n;i++) {
		targetNumber+=i;
	}
	targetNumber++;
	
	arr[y][x]=number++;
	while(true) {
	//1과정
		while(number!=targetNumber) {
			y++;
			if(y>n-1 || arr[y][x]!=0) {
				y--;
				break;
			}
			arr[y][x]=number++;
		}
		
		//2과정
		while(number!=targetNumber) {
					x++;
					if(x>n-1 || arr[y][x]!=0) {
						x--;
						break;
					}
					arr[y][x]=number++;
		}	
		//3과정
		while(number!=targetNumber) {
					x--;
					y--;
					if(x>n-1|| y>n-1 || arr[y][x]!=0) {
						x++;
						y++;
						break;
					}
					arr[y][x]=number++;
		}	
		
		if(targetNumber==number) {
			break;
		}
	}
	
	List<Integer> answerList=new ArrayList<Integer>();
	for(int i=0; i<arr.length;i++) {
		for(int j=0; j<arr[i].length; j++) {
			if(arr[i][j]==0)break;
			answerList.add(arr[i][j]);
		}
	}
	
	int answer[]=answerList.stream()
			  .mapToInt(i->i.intValue())
			  .toArray();
	System.out.println(Arrays.toString(answer));
	return answer;
		
	}
}
