package 모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution s=new Solution();
		
		System.out.println(Arrays.toString( s.solution(new int[] {1,2,3,4,5})));
	}

	public int[] solution(int answers[]) {
		int init[][]=init(answers);
		
		int score[]=new int[3];
		
		for(int i=0; i<answers.length; i++) {
			int n=answers[i];
			
			if(n==init[0][i]) {
				score[0]+=1;
				//System.out.println("0번");
			}
			if(n==init[1][i]) {
				score[1]+=1;//System.out.println("1번");
			}
			if(n==init[2][i]) {
				score[2]+=1;//System.out.println("2번");
			}
		}
		
		List<Integer> result=new ArrayList<Integer>();
		
		int n=score[0];
		result.add(0);
		
		for(int i=1; i<3; i++) {
			if(score[i]>n) {
				result.clear();
				result.add(i);
				
				n=score[i];
			}
			else if(score[i]==n) {
				result.add(i);
			}
		}
		Collections.sort(result);
		int res[]=new int[result.size()];
		for(int i=0; i<res.length; i++) {
			res[i]=result.get(i)+1;
		}
		
		
		return  res;
	
	}
	
	public int[][] init(int arr[]){
		
		int init[][] = new int[3][arr.length];
		
		int pattern1[]= {1,2,3,4,5};
		int pattern2[]= {2,1,2,3,2,4,2,5};
		int pattern3[]= {3,3,1,1,2,2,4,4,5,5};
		
		//수포자1
		for(int i=0; i<arr.length; i++) {
			init[0][i]=pattern1[i%pattern1.length];
		}
		
		//수포자2
		for(int i=0; i<arr.length; i++) {
			init[1][i]=pattern2[i%pattern2.length];
		}
		
		//수포자3
		for(int i=0; i<arr.length; i++) {
			init[2][i]=pattern3[i%pattern3.length];
		}
		
		System.out.println(Arrays.toString(init[0]));
		System.out.println(Arrays.toString(init[1]));
		System.out.println(Arrays.toString(init[2]));
		return init;
		
	}
}
