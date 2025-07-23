package 수식최대화;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	static List<String> collraboration=new ArrayList<String>();

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//	Solution s=new Solution();
//	int n=s.solution("100-200*300-500+20");
//	System.out.println("가장 큰값 " + n);
//
//	}

	public long solution(String expression) {
		  collraboration.clear();
		
		String exp=seekExpression(expression);
		makeCollraboration("",exp);
		
		return maxResult(expression);
	}
	
	public String seekExpression(String expression) {
		
		String exp="";
		
		for(int i=0; i<expression.length(); i++) {
			String get=expression.substring(i,i+1);
			if((get.equals("+")||get.equals("-")||get.equals("*")) &&(exp.contains(get)==false)) {
				exp+=get;
			}
		}
	
		return exp;
	}
	
	public void makeCollraboration(String prefix,String remaining) {
		if(remaining.length()==0) {
			collraboration.add(prefix);
			return ;
		}
		
		for(int i=0; i<remaining.length(); i++) {
			String newPrefix=prefix+remaining.substring(i,i+1);
			String newRemaining=remaining.substring(0,i)+remaining.substring(i+1);
			makeCollraboration(newPrefix,newRemaining);
			
		}
		
	}
	
	public long maxResult(String expression) {
		long max=Integer.MIN_VALUE;
		for(int i=0; i<collraboration.size(); i++) {
			long m=Math.abs( calculate(collraboration.get(i),expression));
			//System.out.println(collraboration.get(i)+"일 때 계산 결과 "+m);
			if(m>max) {
				max=m;
			}
		}
		return max;
	}
	
	public long calculate(String priority, String expression) {
		
		//1)우선순위에의해 중위 -> 후위로 바꾸기
		String rearExpression=midToRear(priority,expression);
		//System.out.println(priority+"일 때 후위 : "+rearExpression);
		//2)후위를 계산하기
		long result=rearCalculate(rearExpression);
		return result;
	}
	
	public String midToRear(String priority, String expression) {
		
		Map<String,Integer> priorityMap=new HashMap<String,Integer>();
		for(int i=0; i<priority.length();i ++) {
			String get=priority.substring(i,i+1);
			priorityMap.put(get, priority.length()-i);
		}
		
		
		Pattern p=Pattern.compile("\\d+|[+\\-*]");
		Matcher m=p.matcher(expression);
		Stack<String> stack=new Stack<String>();
		String midToRearStr="";
		
		while(m.find()) {
			String str=m.group();
			
			
			if(priority.contains(str)) {
				
				while(!stack.isEmpty()&&(priorityMap.get(str) <= priorityMap.get(stack.peek()))) {
					String pop=stack.pop();
					midToRearStr+=pop+" ";
				}
				
				stack.push(str);
				
			}else {
				//숫자
				midToRearStr+=str+" ";
			}
		}
		
		while(!stack.isEmpty()) {
			String pop=stack.pop();
			midToRearStr+=pop+" ";
		}
		return midToRearStr.trim();
		
	}
	
	public long rearCalculate(String rearExpression) {
		
		String strs[]=rearExpression.split(" ");
		Stack<String> stack=new Stack<String>();
		
		for(int i=0; i<strs.length; i++) {
			String str=strs[i];
			switch (str) {
			case "+": 
				long a=Long.parseLong(stack.pop());
				long b=Long.parseLong(stack.pop());
				long c=a+b;
				stack.push(Long.toString(c));
				break;
			case "-": 
				long e=Long.parseLong(stack.pop());
				long f=Long.parseLong(stack.pop());
				long g=f-e;
				stack.push(Long.toString(g));
				break;
			case "*": 
				long h=Long.parseLong(stack.pop());
				long j=Long.parseLong(stack.pop());
				long k=h*j;
				stack.push(Long.toString(k));
				break;
				
			default:
				stack.push(str);
				
			}
		}
		
		return Long.parseLong(stack.pop());
		
	}
}
