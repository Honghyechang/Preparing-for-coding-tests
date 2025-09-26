package 봉인된주문_389481;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	
	int setsMaxCount=-1;
	int size=-1;
	Set<String> sets=new TreeSet<String>((a,b)->{
		
		if(a.length()-b.length()==0) {
			return a.compareTo(b);
		}else{
			return a.length() - b.length();
		}
		
	});
	
	List<String> answerList=new ArrayList<String>();

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		String strs[]= {"abc","bbc","abd"};
////		Arrays.sort(strs,(a,b)->a.compareTo(b));
////		System.out.println(Arrays.toString(strs));
//		Solution s=new Solution();
//		s.solution(7388, new String[]{"gqk", "kdn", "jxj", "jxi", "fug", "jxg", "ewq", "len", "bhc"});
//	//	s.solution(30, new String[]{"d", "e", "bb", "aa", "ae"});
//		
//
//	}

	  public String solution(long n, String[] bans) {
		  Digit digits[]=new Digit[11]; //최대 자리수 11자리
		  for(int i=0; i<digits.length; i++) {
			  
			  digits[i]=new Digit(i+1);
		  }
		
		  for(String ban : bans) {
			  int length=ban.length();
			  Digit digit=digits[length-1];
			  digit.addBan(ban);
		  }
		  
		  int nSize=1;
		  for(Digit digit : digits) {
			  if(n<=digit.count) {
				  break;
			  }
			  nSize++;
		  }
		  System.out.println("bens를 제외한 순서를 고려한 결과 자리수 : "+nSize+"만 구하면된다.");
		  
		  long realN=-1;
		  
		  if(nSize==1) {
			   realN=n;
		  }else {
		   //1자리수가 아니라면 그 전자리수의 값만큼 빼고, 해당하는 자리 수에서 몇번째인지만 알면된다.
		   int beforeSize=nSize-1;
//		   Digit beforeDigit=digits[beforeSize-1];
//		   realN=n-beforeDigit.count;
		   
		   long sumSubract=0;
		   for(int i=0; i<beforeSize; i++) {
			   Digit digit=digits[i];
			   sumSubract+=digit.count;
		   }
		   
		   realN=n-sumSubract;
		   System.out.println("realN : "+n+" - "+sumSubract+" = "+realN);
			  
		  }
		  System.out.println("해당 자리수에서 "+realN+"만 구하면 된다.");
		  
		  dfs("abcdefghijklmnopqrstuvwxyz",nSize,realN,new StringBuilder(),digits[nSize-1].bans);
//		  
//		  Digit banDigit=digits[nSize-1];
//		  for(String ban : banDigit.bans) {
//			  if(sets.contains(ban)) {
//				  sets.remove(ban);
//			  }
//		  }
//		  int count=1;
//		  for(String word : sets) {
//			  if(count==realN) {
//				  System.out.println(word+"찾음");
//				  return word;
//			  }
//			//  System.out.println(word);
//			  count++;
//		  }
		  
		  System.out.println(answerList.get(answerList.size()-1)+"마지막");
		  
		  return answerList.get(answerList.size()-1);
	   }
	  
	  class Digit{
		  int disitNumber;//자리수
		  List<String> bans;//자리수에 맞는 bans들
		  long count;//해당 자리수의 총 개수(bans를 제외)
		  
		  public Digit(int disitNumber) {
			  this.disitNumber=disitNumber;
			  bans=new ArrayList<String>();
			  count=(long)Math.pow(26,disitNumber);
		  }
		  public void addBan(String ban) {
			  bans.add(ban);
			  count--;
		  }
	  }
	  
	  //alphabet 로 dfs하면 사전순서를 보장해준다.
	  public void dfs(String alphabet,int size,long realN,StringBuilder word,List<String> bans) {
		  
		  if(answerList.size()==realN) {
			  return;
		  }

		  if(size==word.length()) {
			  
			  if(!bans.contains(word.toString())) {
				  answerList.add(word.toString());
			  }
			
			  //sets.add(word.toString());
			  return;
		  }
		  
		  for(int i=0; i<alphabet.length(); i++) {
			  if(answerList.size()==realN) {
				  return;
			  }
			  
			  char ch=alphabet.charAt(i);
			  StringBuilder newWord=new StringBuilder(word);
			  newWord.append(ch);
			  dfs(alphabet,size,realN,newWord,bans);
		  }
	  }
}
