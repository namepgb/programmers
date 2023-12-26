package main.java.level2.이모티콘_할인_행사;

import java.util.Arrays;

/**
 * {@link Solution}의 테스트케이스를 실행합니다.
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/150368">Programmers: 이모티콘 할인 행사</a>
 * @author namepgb
 */
public class Main
{
	public static void main(String[] args)
	{
		testcase(new int[][] {{40, 10000}, {25, 10000}}, new int[] { 7000, 9000 });
		testcase(new int[][] {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}}, new int[] { 1300, 1500, 1600, 4900 });
		testcase(new int[][] {{25, 2900}}, new int[] { 1300, 1500, 1600, 4900 });
	}
	
	static void testcase(int[][] users, int[] emoticons)
	{
		Solution s = new Solution();
		int[] n = s.solution(users, emoticons);
		System.out.println(Arrays.toString(n));
	}
}
