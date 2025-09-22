package 문자열압축_60057;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution("abcabcabcabcdededededede");
//	}
	
	public int solution(String s) {
		int min=Integer.MAX_VALUE;
		
		if(s.length()==1) {
			return 1;
		}
		
		for(int i=1; i<s.length(); i++) {
			StringBuilder sb=new StringBuilder();
			int wordLength=i; //wordLength짜르는 단위가 되는것이다.
			
			int j;
			//String before=s.substring(0,wordLength);
			int count=1;
			if(i==6) {
		//		System.out.println(i);
			}
			
			int n=s.length()/wordLength;
			int namejiStartIndex=-1;
			if(s.length()%wordLength!=0) {
				namejiStartIndex=n*wordLength;
			}
		//	System.out.println(i+"일 경우 몫 : "+ n +" 나머지 namejiStartIndex: "+namejiStartIndex);
			//최소 n번만큼은 돌려야한다.
			
			String beforeWord=null;
			int startIndex=0;
			int number=1;
			for(int k=1; k<=n; k++) {
				String currentWord=s.substring(startIndex,k*wordLength);
				startIndex=startIndex+wordLength;
				if(beforeWord==null) {
					beforeWord=currentWord;
					continue;
				}
				
				
				if(beforeWord.equals(currentWord)) {
					number++;
				}else {
					sb.append(number==1? beforeWord : number+beforeWord);	
					beforeWord=currentWord;
					number=1;
					
				}
				
				
				
			}
			//결국 마지막은 추가를 안한상태일것이다.
			sb.append(number==1? beforeWord : number+beforeWord);
			
			//나머지
			if(namejiStartIndex!=-1) {
				sb.append(s.substring(namejiStartIndex));
			}
			
			if(sb.toString().length() <min) {
				min=sb.toString().length();
				//System.out.println("업데이트 : "+sb.toString());
			}
			
		//	System.out.println("단어개수"+i+"개로 짜른 결과 : "+sb.toString());
			
			
			
		}
		
		System.out.println(min);
		return min;
	}

}
