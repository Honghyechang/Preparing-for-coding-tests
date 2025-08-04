package 이진탐색;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution s=new Solution();
		s.solution(new int[] {1,2,3,4,5,6,7,8,9,10}, 11);
	}
	
	public int solution(int arr[], int n) {
		
		//arr 에서 n을 찾기
		
//		int result=Arrays.binarySearch(arr, n);
//		System.out.println(result);
		
//		# 이진탐색 두 가지 패턴 비교
//
//		## 1. 정확한 값 찾기 (첫 번째 코드)
//
//		```java
//		public int solution(int arr[], int n) {
//		    int start = 0;      // 포함
//		    int end = arr.length; // 미포함 (반열린구간)
//		    
//		    while(start < end) {  // start가 end와 같아지면 종료
//		        int mid = (start + end) / 2;
//		        int value = arr[mid];
//		        
//		        if(value == n) {
//		            return mid;  // 찾으면 즉시 종료
//		        }
//		        else if(value > n) {
//		            end = mid;    // mid 미포함
//		        } else {
//		            start = mid + 1; // mid+1부터 포함
//		        }
//		    }
//		    return -1; // 못 찾음
//		}
//		```
//
//		**특징:**
//		- `while(start < end)`: 반열린구간 `[start, end)`
//		- 정확한 값을 찾으면 **즉시 return**
//		- `end = mid` (mid 미포함), `start = mid + 1` (mid 제외)
//
//		---
//
//		## 2. 최적값 찾기 (징검다리 문제)
//
//		```java
//		public int solution(int distance, int rocks[], int n) {
//		    int start = 1;        // 최소 거리
//		    int end = distance;   // 최대 거리
//		    int answer = -1;      // 답 저장 변수
//		    
//		    while(start <= end) { // start가 end를 넘을 때까지
//		        int mid = (start + end) / 2;
//		        
//		        if(isValid(rocks, mid, n)) {
//		            answer = mid;     // 가능한 답 저장
//		            start = mid + 1;  // 더 큰 값 탐색
//		        } else {
//		            end = mid - 1;    // 더 작은 값 탐색
//		        }
//		    }
//		    return answer;
//		}
//		```
//
//		**특징:**
//		- `while(start <= end)`: 닫힌구간 `[start, end]`
//		- 조건을 만족하면 **답을 저장하고 계속 탐색**
//		- `start = mid + 1`, `end = mid - 1` (둘 다 mid 제외)
//
//		---
//
//		## 핵심 차이점
//
//		| 구분 | 정확한 값 찾기 | 최적값 찾기 |
//		|------|----------------|-------------|
//		| **목적** | 특정 값의 위치 | 조건을 만족하는 최적값 |
//		| **루프 조건** | `start < end` | `start <= end` |
//		| **범위 의미** | start, end는 **인덱스** | start, end는 **답의 범위** |
//		| **종료 조건** | 값 찾으면 즉시 return | 끝까지 탐색해서 최적값 찾기 |
//		| **답 저장** | 찾으면 즉시 return | answer 변수에 저장 후 계속 탐색 |
//
//		---
//
//		## 왜 `start <= end`를 쓸까?
//
//		징검다리 문제에서:
//		- **start, end는 인덱스가 아니라 답의 범위**
//		- 1부터 distance까지의 값 중에서 **최대한 큰 값**을 찾고 싶음
//		- 조건을 만족하는 값을 찾아도, **더 큰 값이 가능한지** 계속 확인해야 함
//
//		```java
//		// 예시: distance=25, 가능한 답의 범위 [1, 25]
//		start=1, end=25
//		mid=13 → 가능하다면 answer=13 저장, start=14로 더 큰 값 탐색
//		mid=19 → 가능하다면 answer=19 저장, start=20으로 더 큰 값 탐색  
//		mid=22 → 불가능하다면 end=21로 더 작은 값 탐색
//		...
//		```
//
//		---
//
//		## 범위 갱신이 `mid ± 1`인 이유
//
//		**닫힌구간 `[start, end]`**에서는:
//		- mid가 답이 아니라면 **mid는 제외**해야 함
//		- 따라서 `start = mid + 1`, `end = mid - 1`
//
//		**반열린구간 `[start, end)`**에서는:
//		- end가 이미 미포함이므로 `end = mid`
//		- start는 포함이므로 `start = mid + 1`
//
//		---
//
//		## 정리
//
//		1. **정확한 값/위치 찾기**: `while(start < end)`, 찾으면 즉시 return
//		2. **최적값 찾기**: `while(start <= end)`, answer 저장하며 끝까지 탐색
//

		return -1;
	}

}
