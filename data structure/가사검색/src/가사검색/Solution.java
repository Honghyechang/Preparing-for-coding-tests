package 가사검색;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Solution s =new Solution();
//		s.solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}, new String[] {"fro??", "????o", "fr???", "fro???", "pro?"});
//
//	}
	public int[] solution(String[] words, String[] queries) {
		
		
		//정방향 trie와 reverseTrie를만들기
		
		
		Trie trie=new Trie();
		Trie reverseTrie=new Trie();
		for(int i=0; i<words.length; i++) {
			String word=words[i];
			trie.insert(word);
			reverseTrie.insert(new StringBuilder(word).reverse().toString());
		}
		int answer[]=new int[queries.length];
		for(int i=0; i<queries.length; i++) {
			boolean reverseFlag=false;
			String pattern=queries[i];
			if(pattern.startsWith("?")) {
				pattern=new StringBuilder(pattern).reverse().toString();
				reverseFlag=true;
			}
			
			String sortPattern=pattern.replaceAll("\\?+", "");
			int length=pattern.length()-sortPattern.length();
			
			int n=-1;
			
			if(reverseFlag) {
				//거꾸로라면
				TrieNode seartNode=reverseTrie.searchNode(sortPattern);
				
				if(seartNode==null) {

					//System.out.println("null");
					n=0;
				}
				else {
					//System.out.println("===반대===");
					//System.out.println("seartNode : "+seartNode.nodeCh);
					if(seartNode.matchingCountMap.containsKey(length)) {
						//System.out.println(length+" 키존재");
						n=seartNode.matchingCountMap.get(length);
					}else {
						n=reverseTrie.recursionA(seartNode,length , 0);

						seartNode.matchingCountMap.put(length, n);
					//	System.out.println(seartNode.nodeCh+ "  key : "+length +"  value : "+n);
					}
				
				}
			}else {
				TrieNode seartNode=trie.searchNode(sortPattern);
				if(seartNode==null) {
					//System.out.println("null");
					n=0;
				}
				else {
				//	System.out.println("===정방향===");
					//System.out.println("seartNode : "+seartNode.nodeCh);
					if(seartNode.matchingCountMap.containsKey(length)) {
						//System.out.println(length+" 키존재");
						n=seartNode.matchingCountMap.get(length);
					}else {
						n=trie.recursionA(seartNode,length , 0);
						
						seartNode.matchingCountMap.put(length, n);
					//	System.out.println(seartNode.nodeCh+ "  key : "+length +"  value : "+n);
					
					}
					
					
				}
			}
			
//			if(pattern.startsWith("?")) {
//				n=trie.recursionB(trie.root, length, 0, sortPattern);
//			}else {
//				TrieNode seartNode=trie.searchNode(sortPattern);
//				if(seartNode==null) {
//				//	System.out.println("seartNode : null");
//					
//					n=0;
//				}
//				else {
//					//System.out.println("seartNode : "+seartNode.nodeCh);
//					
//					n=trie.recursionA(seartNode, length, 0);
//				}
//				
//			}
			
			answer[i]=n;
			//System.out.println("정답 n : "+n);
		}
		
		return answer;
		
	}
	
	
	class TrieNode{
		char nodeCh;
		Map<Integer,Integer> matchingCountMap=new HashMap<Integer, Integer>();
		Map<Character,TrieNode> children=new HashMap<Character, Solution.TrieNode>();
		boolean isFinish=false;
		
		public TrieNode(char ch) {
			this.nodeCh=ch;
		}
	}
	
	class Trie{
		TrieNode root;
		public Trie() {
			root=new TrieNode('$');
		}
		
		public void insert(String str) {
			TrieNode current=root;
			for(int i=0; i<str.length(); i++) {
				char ch=str.charAt(i);
				current.children.putIfAbsent(ch, new TrieNode(ch));
				TrieNode chTn=current.children.get(ch);
				current=chTn;
			}
			
			current.isFinish=true;
		}
		
		
		public boolean search(String str) {
			TrieNode current=root;
			for(int i=0; i<str.length(); i++) {
				char ch=str.charAt(i);
				boolean check=root.children.containsKey(ch);
				if(check) {
					current=root.children.get(ch);
				}else {
					return  false;
				}
			}
			
			return current.isFinish;
		}
		
		public TrieNode searchNode(String str) {
			TrieNode current=root;
			
			
			for(int i=0; i<str.length(); i++) {
				char ch=str.charAt(i);
				boolean check=current.children.containsKey(ch);
				if(check) {
					current=current.children.get(ch);
				}else {
					return  null;
				}
			}
			
			return current;
		}
		//재귀함수를 통한 길이 주면 마지막 단어인지 확인!
		public int recursionA(TrieNode node,int n,int deepth) {
			//System.out.println(node.nodeCh + " : "+node.children.size());
			int sum=0;
			if(n==deepth) {
				//System.out.println("깊이가 "+deepth+"일 때, " +node.nodeCh +" , "+node.isFinish);;
				return node.isFinish?1:0;
			}
			
			Set<Character> sets=node.children.keySet();
			Iterator<Character> iterator=sets.iterator();
			
			while(iterator.hasNext()) {
				char key=iterator.next();
				TrieNode child=node.children.get(key);
				sum=sum+recursionA(child,n,deepth+1);
			}
			
			return sum;
		}
		//깊이만큼 가고 거기에 끝나는단어가 있는지
		public int recursionB(TrieNode node,int n,int deepth,String find) {
			int sum=0;
			if(n==deepth) {
			// 예를들어 ?? 깊이가 2인 상태
				boolean exist=true;
				for(int i=0; i<find.length(); i++) {
					char f=find.charAt(i);
					if(node.children.containsKey(f)) {
						node=node.children.get(f);
					}else {
						exist=false;
						break;
					}
				}
				return node.isFinish && exist ? 1 : 0;
			}
			
			Set<Character> sets=node.children.keySet();
			Iterator<Character> iterator=sets.iterator();
			
			while(iterator.hasNext()) {
				char key=iterator.next();
				TrieNode child=node.children.get(key);
				sum=sum+recursionB(child,n,deepth+1,find);
			}
			
			
			return sum;
		}
		
	}

}



//
//public int[] solution(String[] words, String[] queries) {
//    int[] answer = new int[queries.length];
//    
//    for(int i=0; i<queries.length; i++) {
//    	int count=0;
//    	String query=queries[i];
//    	
//    	boolean startEndFlag=true;
//    	
//    	if(query.startsWith("?")) {
//    		startEndFlag=true;
//    	}else {
//    		startEndFlag=false;
//    	}
//    	
//    	String pattern=query.replaceAll("\\?+", "");
//    	
//    	
//    	
//    	for(int j=0; j<words.length; j++) {
//    		
//    		String word=words[j];
//    		
//    		if(word.length()!=query.length()) {
//    			continue;
//    		}
//    		
//    		if(startEndFlag) {
//    			if(word.endsWith(pattern)) {
//    				count++;
//    			}
//    		}else {
//    			if(word.startsWith(pattern)) {
//    				count++;
//    			}
//    		}
//    	}
//    	
//    	answer[i]=count;
//    	System.out.println(count);
//    	
//    }
//    return answer;
//}
