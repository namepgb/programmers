package main.java.level2.미로_탈출;

/**
 * {@link Solution}의 테스트케이스를 실행합니다.
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/159993">Programmers: 미로 탈출</a>
 * @author namepgb
 */
public class Main
{
	public static void main(String[] args)
	{
		testcase(new String[] { "SOOOL","XXXXO","OOOOO","OXXXX","OOOOE" });
		testcase(new String[] { "LOOXS","OOOOX","OOOOO","OOOOO","EOOOO" });
	}
	
	static void testcase(String[] maps)
	{
		Solution s = new Solution();
		int n = s.solution(maps);
		System.out.println(n);
	}
}
