package 수식최대화_67257;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	List<String[]> collaboratins=new ArrayList<String[]>();

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Solution s=new Solution();
//		//System.out.println(Arrays.toString("1+b*c-d".split("\\+|\\*|-",0)));
//		s.solution("100-200*300-500+20");
//		
//		//System.out.println("100".matches("\\d+"));
//
//	}
	public long solution(String expression) {
		
		StringTokenizer stk=new StringTokenizer(expression,"+-*",true);
		List<String> listToken=new ArrayList<String>();
		while(stk.hasMoreTokens()){
			String token=stk.nextToken().trim();
			listToken.add(token);
		}
		String []expressionByOperation=listToken.stream().toArray(String[]::new);
		
		
		//System.out.println(Arrays.toString(expressionByOperation));
		//연산자 순서를 모두 구한다.
		createOpCollaboration(new String[] {"+","-","*"},new String[3],new boolean[3],0);
		
		long max=Integer.MIN_VALUE;
		
		for(String[] opPriority : collaboratins) {
			Map<String,Integer> map =new HashMap<String, Integer>();
			for(int i=0; i<opPriority.length; i++) {
				map.put(opPriority[i],i+1);
			}
			String[] rearExpression=toRearByPriority(map,expressionByOperation);
		//	System.out.println("후위표현식 : "+Arrays.toString(rearExpression));
			long result=calRearExpreesion(rearExpression);
			//System.out.println(Arrays.toString(opPriority)+"일 때 결과 "+result);
			if(max<result) {
				max=result;
			}
		}
		System.out.println(max);
		return max;
	}
	
	public long calRearExpreesion(String[] rearExpression) {
		Stack<String> stack=new Stack<String>();
		for(String exp : rearExpression) {
			if(exp.matches("\\d+")) {
				stack.add(exp);
			}else {
				long strToLongOne=Long.parseLong(stack.pop());
				long strToLongTwo=Long.parseLong(stack.pop());
				
				// two  - one 순서 주의
				if(exp.equals("+")) {
					stack.add(strToLongTwo+strToLongOne+"");
				}else if(exp.equals("-")) {
					stack.add(strToLongTwo-strToLongOne+"");
				}else if(exp.equals("*")) {
					stack.add(strToLongTwo*strToLongOne+"");
				}
				
				
			}
			
			
		}
		
		//최종적으로
		long answer=Long.parseLong(stack.pop());
		return Math.abs(answer);
		
		
		
	}
	//우선순위에 따른 후위 표현식
	public String[]  toRearByPriority(Map<String,Integer> priority,String[]expressions) {
		
		List<String> rearExpression=new ArrayList<String>();
		Stack<String> stack=new Stack<String>();
		
		for(String exp : expressions) {
			if(exp.matches("\\d+")) {
				//숫자라면
				rearExpression.add(exp);
			}else {
				while(!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(exp)) {
					rearExpression.add(stack.pop());
				}
				stack.add(exp);
			}
		}
		while(!stack.isEmpty()) {
			rearExpression.add(stack.pop());
		}
		
		String changeString[]=rearExpression.stream()
											.toArray(String[]::new);
		
		//System.out.println(Arrays.toString(changeString));
		return changeString;
	}
	
	
	
	public void createOpCollaboration(String [] operations,String select[] , boolean used[],int depth) {
		if(depth==operations.length) {
	//		System.out.println(Arrays.toString(select));
			collaboratins.add(select.clone());
			return;
		}
		
		for(int i=0; i<operations.length; i++) {
			
			if(!used[i]) {
				select[depth]=operations[i];
				used[i]=true;
				
				createOpCollaboration(operations,select,used,depth+1);
				used[i]=false;
			}
			
		}
		
		
	}
}
