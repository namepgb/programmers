package main.java.level2.무인도_여행;

import java.util.Arrays;

/**
 * {@link Solution}의 테스트케이스를 실행합니다.
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/154540">Programmers: 무인도 여행</a>
 * @author namepgb
 */
public class Main
{
	public static void main(String[] args)
	{
		testcase(new String[] { "X591X","X1X5X","X231X", "1XXX1" });
		testcase(new String[] { "XXX","XXX","XXX" });
	}
	
	static void testcase(String[] maps)
	{
		Solution s = new Solution();
		int[] n = s.solution(maps);
		System.out.println(Arrays.toString(n));
	}
}
