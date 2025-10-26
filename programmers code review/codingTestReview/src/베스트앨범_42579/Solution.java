package 베스트앨범_42579;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500});
//	}
//
//	
	 public int[] solution(String[] genres, int[] plays) {
		 
		 Map<String,Music> musicMap=new HashMap<String,Music>();
		 List<Music> musicList=new ArrayList<Solution.Music>();
		 
		 for(int i=0; i<genres.length; i++) {
			 String genre=genres[i];
			 int index=i;
			 int play=plays[i];
			 
			 if(!musicMap.containsKey(genre)) {
				 Music m =new Music(genre);
				 musicList.add(m);
				 musicMap.put(genre,m);
			 }
			 
			 Music music=musicMap.get(genre);
			 music.add(index,play);
			 
		 }
		 
		 
		 //musicList 정렬하기
		 Collections.sort(musicList,(a,b)->b.sum - a.sum);
		 List<Integer> answer=new ArrayList<Integer>();
		 
		 for(Music music : musicList) {
			 
			 //music의 indexAndPlay정렬하기
			 music.listSort();
			 if(music.indexAndPlay.size()==1) {
				 answer.add(music.indexAndPlay.get(0)[0]);
			 }else {
				 answer.add(music.indexAndPlay.get(0)[0]);
				 answer.add(music.indexAndPlay.get(1)[0]);
			 }
		 }
		 
		 int answerArr[]=answer.stream()
				 .mapToInt(i->i.intValue())
				 .toArray();
		 System.out.println(Arrays.toString(answerArr));
		 
		 
		 
	        return answerArr;
	   }
	 
	 class Music
	 {
		 String genre;
		 int sum=0;
		 
		 //인덱스 와 스트림 수를 알아야한다.
		 List<int[]> indexAndPlay;
		 
		 public Music(String genre) {
			 this.genre=genre;
			 indexAndPlay=new ArrayList<int[]>();
		 }
		 
		 public void add(int index, int play) {
			 int arr[]= {index,play};
			 sum+=play;
			 indexAndPlay.add(arr);
		 }
		 
		 public void listSort() {
			 Collections.sort(indexAndPlay,(a,b)->{
				 
				 if(a[1]!=b[1]) {
					 return b[1]-a[1];
				 }
				 return a[0]-b[0];
				 
			 });
		 }
		 
	 }
}
