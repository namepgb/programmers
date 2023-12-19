package main.java.level2.미로탈출;

import java.util.*;

/**
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/159993">Programmers: </a>
 *
 */
public class Solution
{
	public class Node
	{
		public int x, y;
		public int cost;
		
		public Node(int x, int y, int cost)
		{
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	public int solution(String[] maps) {
		int sx = 0, sy = 0, lx = 0, ly = 0, ex = 0, ey = 0;
		for (int y = 0; y < maps.length; ++y)
		{
			char[] s = maps[y].toCharArray();
			for (int x = 0; x < s.length; ++x)
			{
				char c = s[x];
				switch (c)
				{
					case 'S' -> {
						sx = x;
						sy = y;
					}
					case 'L' -> {
						lx = x;
						ly = y;
					}
					case 'E' -> {
						ex = x;
						ey = y;
					}
				}
			}
		}
		
		int toL = bfs(maps, sx, sy, lx, ly);
		if (toL <= -1) return -1;
		int toE = bfs(maps, lx, ly, ex, ey);
		if (toE <= -1) return -1;
		return toL + toE;
	}
	
	public int bfs(String[] maps, int bx, int by, int gx, int gy)
	{
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
		int h = maps.length;
		int w = maps[0].length();
		int x = bx, y = by;
		boolean[][] visited = new boolean[h][w];
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0));
		visited[y][x] = true;
		
		while (!q.isEmpty())
		{
			Node n = q.poll();
			if (n.x == gx && n.y == gy)
				return n.cost;
			for (int i = 0; i < 4; ++i)
			{
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= w || ny >= h)
					continue;
				char[] s = maps[ny].toCharArray();
				char c = s[nx];
				if (!visited[ny][nx] && 'X' != c)
				{
					visited[ny][nx] = true;
					q.offer(new Node(nx, ny, n.cost + 1));
				}
			}
		}
		
		return -1;
	}
}
