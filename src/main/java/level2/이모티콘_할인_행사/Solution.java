package main.java.level2.이모티콘_할인_행사;

import java.util.*;

/**
 * 중복 순열을 구하고 문제에서 요구하는 최적의 수를 구합니다.
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/150368">Programmers: 이모티콘 할인 행사</a>
 * @author namepgb
 */
public class Solution
{
	public void dupPermutation(int[] target, List<Integer> result, int remain)
	{
		if (0 == remain)
		{
			permutations.add(new ArrayList<>(result));
			return;
		}
		
	for (int i = 0; i < target.length; ++i)
		{
			result.add(target[i]);
			dupPermutation(target, result, remain - 1);
			result.remove(result.size() - 1);
		}
	}
	
	static List<List<Integer>> permutations = new ArrayList<>();
	
	public int[] solution(int[][] users, int[] emoticons)
	{
		int[] discounts = new int[] { 10, 20, 30, 40 };
		// 중복 순열을 구합니다.
		dupPermutation(discounts, new ArrayList<>(), emoticons.length);
		
		// 모든 경우의 수를 계산합니다.
		List<Integer[]> answer = new ArrayList<>();
		for (List<Integer> permutation : permutations)
		{
			// c: 이모티콘 플러스 서비스 가입, p: 이모티콘 구매 가격
			int c = 0, p = 0;
			for (int[] user : users)
			{
				int paid = 0;
				for (int i = 0; i < permutation.size(); ++i)
				{
					int discount = permutation.get(i);
					if (discount < user[0])
						continue;
					int discounted = (int) (emoticons[i] * (1.0f - (discount / 100.0f)));
					paid += discounted;
				}
				
				// 이모티콘 플러스 서비스에 가입합니다.
				if (user[1] <= paid) ++c;
				// 이모티콘 구매 가격을 누적시킵니다.
				else p += paid;
			}
			
			if (0 < c || 0 < p)
				answer.add(new Integer[] { c, p });
		}
		
		// 문제에서 요구하는 최적의 수를 0번 인덱스로 정렬합니다.
		Collections.sort(answer, (lp, rp) -> {
			if (lp[0] == rp[0]) {
				return lp[1] < rp[1] ? 1 : (lp[1] > rp[1]) ? -1 : 0;
			} else {
				return lp[0] < rp[0] ? 1 : (lp[0] > rp[0]) ? -1 : 0;
			}
		});

		return Arrays.stream(answer.get(0)).mapToInt(Integer::intValue).toArray();
	}
}
