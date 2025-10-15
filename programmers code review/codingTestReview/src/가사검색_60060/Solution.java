package 가사검색_60060;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	
//	Solution s =new Solution();
//	s.solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}, new String[] {"fro??", "????o", "fr???", "fro???", "pro?"});
//
//	//System.out.println("?1".matches("\\?+"));
//}
	public int[] solution(String[] words, String[] queries) {
		
		TrieNode root=new TrieNode('*', 0);
		TrieNode reverseRoot=new TrieNode('*', 0);
		
		//오직소문자니까
		//abcde fghij klmno pqrst uvwxy z 26개
		
		
		for(String word : words) {	
			TrieNode current=root;
			for(int i=0; i<word.length(); i++) {
				char ch=word.charAt(i);
				if(current.childrens.containsKey(ch)) {
					//존재한다 이미 그럼 이거는 해결 완료
					current=current.childrens.get(ch);
					if(i==word.length()-1) {
						current.setFinish();
					}
					continue;
				}
				TrieNode t=new TrieNode(ch, i+1);
				if(i==word.length()-1) {
					t.setFinish();
				}
				
				current.insert(t);
				
				current=t;
				//System.out.println("최초 등장 : "+t.ch +" , "+t.detph);
			}
			
			current=reverseRoot;
			//System.out.println("=====");
			for(int i=word.length()-1; i>=0; i--) {
				char ch=word.charAt(i);
				if(current.childrens.containsKey(ch)) {
					//존재한다 이미 그럼 이거는 해결 완료
					current=current.childrens.get(ch);
					if(i==word.length()-1) {
						current.setFinish();
					}
					continue;
				}
				TrieNode t=new TrieNode(ch, word.length()-i);
				if(i==0) {
					t.setFinish();
				}
				
				current.insert(t);
				
				current=t;
				//System.out.println("최초 등장 : "+t.ch +" , "+t.detph);
			}			
		}
		
//		printTrieNode(root);
//		System.out.println("==");
//		printTrieNode(reverseRoot);
		
		int answer[]=new int[queries.length];
		Map<String,Integer> answerMap=new HashMap<String, Integer>();
		
		for(int i=0; i<queries.length; i++) {
			String query=queries[i];
			if(answerMap.containsKey(query)) {
				answer[i]=answerMap.get(query);
				continue;
			}
			
			int count=0;
			if(query.matches("\\?+")) {
				//?깊이만큼 다 돌아야한다
				int length=query.length();
				//목적지의 depth가 length이고, finish인 개수 세기!
				int n=getCount(root,0,length);
				answerMap.put(query, n);
				answer[i]=n;
			}else if(query.startsWith("?")) {
				// ????시작하면 거꾸로 바꾸기
				//reverse에서 찾기
				String originalQuery=query;
				
				//반대로바꾸고
				StringBuilder sb=new StringBuilder(query);
				query=sb.reverse().toString();
				
//				System.out.println(query);
//				System.out.println(originalQuery);
				
				
				String newQuery=query.replaceAll("\\?+", ""); //fro라면 
				int length=newQuery.length();//3
				
				//reverse에서 newQuery를 찾아가기
				TrieNode seekNode=seekTrieNode(reverseRoot,newQuery);
				if(seekNode==null) {
					answer[i]=0;
					answerMap.put(originalQuery, 0);
					continue;
				}
				
				int n=getCount(seekNode,length,query.length());
				answer[i]=n;
				answerMap.put(originalQuery, n);
			}else if(query.endsWith("?")) {
				
				String newQuery=query.replaceAll("\\?+", ""); //fro라면 
				int length=newQuery.length();//3
				
				//reverse에서 newQuery를 찾아가기
				TrieNode seekNode=seekTrieNode(root,newQuery);
				if(seekNode==null) {
					answer[i]=0;
					answerMap.put(query, 0);
					continue;
				}
				
				int n=getCount(seekNode,length,query.length());
				answer[i]=n;
				answerMap.put(query, n);
				
			}
			
			
			
		}
		
		
	//	System.out.println(Arrays.toString(answer));
		
		return answer;
		
	}
	
	public TrieNode seekTrieNode(TrieNode root, String query) {
		boolean isFind =true;
		TrieNode current=root;
		for(int i=0; i<query.length(); i++) {
			char ch=query.charAt(i);
			
			if(!current.childrens.containsKey(ch)) {
				return null;
			}
			current=current.childrens.get(ch);
		}
		
		return current;
	}
	
	public int getCount(TrieNode node , int depth , int target) {
		int sum=0;
		if(depth==target) {
			
			if(node.isFinish) {
				return 1;
			}else {
				return 0;
			}
			
		}
		
		for(char key : node.childrens.keySet()) {
			TrieNode t=node.childrens.get(key);
			sum+=getCount(t,depth+1,target);
		}
		
		return sum;
		
	}
	
	
	public void printTrieNode(TrieNode t) {
		System.out.println("ch : " + t.ch + "  depth : "+t.detph );
		if(t.childrens.size()==0) {
			return;
		}
		for(char key : t.childrens.keySet()) {
			TrieNode node=t.childrens.get(key);
			printTrieNode(node);
		}
	}

	
	//부모가 자식을 알아야한다!
	class TrieNode{
		boolean isFinish;
		char ch;
		Map<Character,TrieNode> childrens ;
		int detph;
		
		public TrieNode(char ch, int depth) {
			this.ch=ch;
			this.detph=depth;
			this.isFinish=false;
			this.childrens=new HashMap<Character,TrieNode>();
		}
		
		public void setFinish() {
			this.isFinish=true;
		}
		
		public void insert(TrieNode t) {
			childrens.put(t.ch,t);
		}
		
	}
}
