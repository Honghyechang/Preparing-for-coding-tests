package 교점에별만들기;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    
	
	public static void main(String[] args) {
        Solution solution = new Solution();  // 인스턴스 생성
        
        // 테스트 케이스
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] result = solution.solution(line);  // 인스턴스 메소드 호출
        
        System.out.println("결과:");
        for (String s : result) {
            System.out.println("\"" + s + "\"");
        }
    }
    
    
    public String[] solution(int[][] line) {
        // 1. 교점부터 구하기
        List<Point> points = intersection(line);
        
        // 교점이 없는 경우 처리
        if (points.isEmpty()) {
            return new String[]{"*"};
        }
        
        Point minPoint = minPoint(points);
        Point maxPoint = maxPoint(points);
        
        int width = maxPoint.x - minPoint.x + 1;
        int height = maxPoint.y - minPoint.y + 1;
        
        char star[][] = new char[height][width];
        for (char[] chars : star) {
            Arrays.fill(chars, '.');
        }
        
        for (Point p : points) {
            int x = (p.x - minPoint.x);
            int y = (maxPoint.y - p.y);
            star[y][x] = '*';
        }
        
        String[] result = new String[star.length];
        for (int i = 0; i < height; i++) {
            result[i] = new String(star[i]);
        }
        return result;
    }
    
    private Point maxPoint(List<Point> points) {
        if (points.isEmpty()) return new Point(0, 0);
        
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        for (Point p : points) {
            if (p.x > x) {
                x = p.x;
            }
            if (p.y > y) {
                y = p.y;
            }
        }
        return new Point(x, y);
    }
    
    private Point minPoint(List<Point> points) {
        if (points.isEmpty()) return new Point(0, 0);
        
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for (Point p : points) {
            if (p.x < x) {
                x = p.x;
            }
            if (p.y < y) {
                y = p.y;
            }
        }
        return new Point(x, y);
    }
    
    private List<Point> intersection(int[][] line) {
        List<Point> points = new ArrayList<Point>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                
                // long 사용으로 오버플로우 방지
                long a1 = line[i][0], b1 = line[i][1], c1 = line[i][2];
                long a2 = line[j][0], b2 = line[j][1], c2 = line[j][2];
                
                long det = a1 * b2 - a2 * b1;
                if (det == 0) {
                    continue;  // 평행선
                }
                
                // 크래머 공식
                long numX = b1 * c2 - b2 * c1;
                long numY = a2 * c1 - a1 * c2;
                
                // 정수 좌표인지 확인
                if (numX % det != 0 || numY % det != 0) {
                    continue;
                }
                
                int x = (int)(numX / det);
                int y = (int)(numY / det);
                
                Point p = new Point(x, y);
                points.add(p);
            }
        }
        return points;
    }
    
    // 내부 클래스로 Point 정의
    class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}