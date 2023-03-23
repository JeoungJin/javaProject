package com.shinhan.day05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 기지국 {
	static int N;
	static int AnswerN;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("sample_input1.txt"));
		char[][] map = null;
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int n = 1; n <= testCase; n++) {
			N = sc.nextInt();
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

			// 구현
			System.out.println();
			int range = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'A')
						range = 1;
					else if (map[i][j] == 'B')
						range = 2;
					else if (map[i][j] == 'C')
						range = 3;
					else
						continue;
					
					for (int k = 1; k <= range; k++) {
						if (i - k >= 0 && map[i - k][j] == 'H')
							map[i - k][j] = 'X';
						if (j - k >= 0 && map[i][j - k] == 'H')
							map[i][j - k] = 'X';
						if (i + k < N && map[i + k][j] == 'H')
							map[i + k][j] = 'X';
						if (j + k < N && map[i][j + k] == 'H')
							map[i][j + k] = 'X';
					}
				}
			}

			// 출력
			AnswerN = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'H')
						AnswerN++;
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.out.println(n + "...결과=>" + AnswerN);
		}
	}
}
