package 재귀함수연습;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*1. 중복순열 (Permutation with Repetition)

	중복 허용 + 순서 고려
	n^k 가지
	예: {a,b,c}에서 3개 뽑기 → aaa, aab, aba, baa, ... (27가지)

	2. 순열 (Permutation)

	중복 불허 + 순서 고려
	nPk = n!/(n-k)! 가지
	예: {a,b,c,d}에서 3개 뽑기 → abc, acb, bac, bca, ... (24가지)

	3. 조합 (Combination)

	중복 불허 + 순서 무시
	nCk = n!/(k!×(n-k)!) 가지
	예: {a,b,c,d}에서 3개 뽑기 → abc, abd, acd, bcd (4가지)*/
	
	//method1
	//char을 받고, 모든 중복이 가능하도록 5자리 수 만들기
	//ex) {a,b,c,d,e} -> aaaaa aaaab aaaac bbbee 등등
	
	public void method1(char chars[],char select[],int depth) {
		
		if(depth==5) {
			System.out.println(Arrays.toString(select));
			return;
		}
		
		for(int i=0; i<chars.length; i++) {
			char ch=chars[i];
			select[depth]=ch;
			method1(chars,select,depth+1);
		}
	}
	
	//method2
	//char을 받고, 중복이 가능하지 않은 5글자 만들기
	//ex) {a,b,c,d,e,f} -> abcde abcef bcedf adefc 순서 고려
		
	public void method2(char chars[],char select[],int depth,boolean visited[]) {
			
		if(depth==5) {
			System.out.println(Arrays.toString(select));
			return;
		}
		
		for(int i=0; i<chars.length; i++) {
			//i가 선택되었다면 그 자리는 선택하지 못한다.
			if(!visited[i]) {
				char ch=chars[i];
				select[depth]=ch;
				visited[i]=true;
				method2(chars,select,depth+1,visited);
				//중요한것은 백트래킹 시 다시 돌아와야한다!
				visited[i]=false;
			}
		}
	}
	//method3
	//char을 받고, 순서를 고려하지 않은 5글자 만들기
	//ex) {a,b,c,d,e,f} -> abced==fabed 같은것
		
	public void method3(char chars[],char select[],int depth,int start) {
			
		int selectableSize=chars.length-start;
		int remainDepth=5-depth;
		
		if(selectableSize<remainDepth) {
			return;
		}
		
		
		if(depth==5) {
			System.out.println(Arrays.toString(select));
			return;
		}
		
		for(int i=start; i<chars.length; i++) {
			char ch=chars[i];
			select[depth]=ch;
			method3(chars,select,depth+1,i+1);
		}
	}
}
