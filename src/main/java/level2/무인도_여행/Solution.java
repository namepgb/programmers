package main.java.level2.무인도_여행;

import java.util.*;

/**
 * BFS를 사용해 전체 공간에서 고립된 영역을 탐색합니다.
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/154540">Programmers: 무인도 여행</a>
 * @author namepgb
 */
public class Solution
{
	public class Node
	{
		public int x, y;
		public int food;
		
		public Node(int x, int y, int food)
		{
			this.x = x;
			this.y = y;
			this.food = food;
		}
	}
	
	 public int[] solution(String[] maps)
	{
		int h = maps.length;
		int w = maps[0].length();
		boolean[][] visited = new boolean[h][w];
		
		List<Integer> answer = new ArrayList<>();
		for (int y = 0; y < h; ++y)
		{
			for (int x = 0; x < w; ++x)
			{
				if (visited[y][x])
					continue;
				int food = bfs(maps, x, y, h, w, visited);
				if (0 < food)
					answer.add(food);
			}
		}
		
		if (answer.isEmpty())
			answer.add(-1);
		
		return Arrays.stream(answer.toArray(new Integer[answer.size()])).mapToInt(Integer::intValue).sorted().toArray();
	}
	
	public int bfs(String[] maps, int bx ,int by, int h, int w, boolean[][] visited)
	{
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
		char c = maps[by].toCharArray()[bx];
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(bx, by, c - 48));
		visited[by][bx] = true;
		if (c == 'X')
			return 0;
		
		int food = 0;
		while (!q.isEmpty())
		{
			Node n = q.poll();
			food += n.food;
			
			for (int i = 0; i < 4; ++i)
			{
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= w || ny >= h)
					continue;
				if (visited[ny][nx])
					continue;
				char nc = maps[ny].toCharArray()[nx];
				if (nc == 'X')
					continue;
				q.offer(new Node(nx, ny, nc - 48));
				visited[ny][nx] = true;
			}
		}
		
		return food;
	}
}
