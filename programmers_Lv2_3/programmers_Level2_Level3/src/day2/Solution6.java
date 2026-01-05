package day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution6 {

	long max=Integer.MIN_VALUE;
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	Solution6 s=new Solution6();
	//System.out.println(Arrays.toString("1+b*c-d".split("\\+|\\*|-",0)));
	s.solution("100-200*300-500+20");
	
	//System.out.println("100".matches("\\d+"));

}
public long solution(String expression) {
	//+,-* 조합 구하고 , 스택으로 계산하기
	operationCollaboration(new char[] {'+','*','-'},new boolean[3],0,new char[3]);
	StringTokenizer st=new StringTokenizer(expression,"*+-",true);
	List<String> expressionList=new ArrayList<String>();
	while(st.hasMoreTokens()) {
		expressionList.add(st.nextToken());
	}
	
	
	for(char[] collabo : collabotationList) {
		Map<String,Integer> maps=new HashMap<String,Integer>();
		maps.put(collabo[0]+"", 1);
		maps.put(collabo[1]+"", 2);
		maps.put(collabo[2]+"", 3); // 우선순위가 클수록 높다.
		
		long result=calculate(expressionList,maps);
		if(result>max) {
			max=result;
		}
	}
	
	return max;
	
}

public long calculate(List<String>  expression,Map<String,Integer> maps) {
	
	StringBuilder sb=new StringBuilder();
	List<String> changeExpress=new ArrayList<String>();
	Stack<String> stack=new Stack<String>();
	for(String exp: expression) {
		if(exp.matches("\\d+")) {
			changeExpress.add(exp);
			//System.out.print(exp);
		}else {
			while(!stack.isEmpty()) {
				String peek=stack.peek();
				if(maps.get(exp)<=maps.get(peek)) {
					changeExpress.add(stack.pop());
				//	System.out.print(exp);
				}
				else {
					break;
				}
			}
			stack.push(exp);
		}
	}
	
	while(!stack.isEmpty()) {
		String pop=stack.pop();
		changeExpress.add(pop);
		//System.out.print(pop);
	}
	
	
	
	
	
	//이제 연산하기
	Stack<Long> calStack=new Stack<Long>();
	for(String exp: changeExpress) {
		if(exp.matches("\\d+")) {
			calStack.push(Long.parseLong(exp));
		}else {
			long one=calStack.pop();
			long two=calStack.pop();
			//System.out.println("one : "+one + " two : "+two);
			
			if(exp.equals("+")) {
				calStack.push(two+one);
			}else if(exp.equals("*")) {
				calStack.push(two*one);
			}else if(exp.equals("-")) {
				calStack.push(two-one);
			}
		}
	}
	long result=calStack.pop();
	//System.out.println("result : "+result + " , abs : "+Math.abs(result));
	return Math.abs(result);
}

List<char[]> collabotationList=new ArrayList<char[]>();


public void operationCollaboration(char[] operations, boolean used[], int selectIndex, char[] selectchar) {
	if(selectIndex==3) {
		collabotationList.add(selectchar.clone());
	//	System.out.println(Arrays.toString(selectchar));
		return;
	}
	
	for(int i=0; i<operations.length; i++) {
		if(!used[i]) {
			selectchar[selectIndex]=operations[i];
			used[i]=true;
			
			
			operationCollaboration(operations,used,selectIndex+1,selectchar);
			used[i]=false;
		}
	}
}
}
