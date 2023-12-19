package main.java.level2.미로탈출;

/**
 *
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
