package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Floyd {
	static int N, M;
	static int[][] dist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// �ʱ�ȭ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		// �÷��̵� �ʱ� �Ÿ� ���̺� �ʱ�ȭ
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// �ڱ� �ڽ����� ���� ���� �ּ� ����� 0�̴�.
				if (i == j) {
					dist[i][j] = 0;
					continue;
				}
				// �ڱ� �ڽ����� ���� ��츦 �����ϰ�� �ſ� ū ��(N���� ��带 ��� ���ļ� ������ �� ū ��).
				dist[i][j] = 100_000_000;
			}
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			// ���� ��ΰ� �ϳ��� �ƴ� �� �ִ�. ���� �� �� �ּ� ����� �����صθ� �ȴ�.
			dist[a][b] = Math.min(dist[a][b], cost);
			dist[b][a] = Math.min(dist[b][a], cost);
		}

		// �÷��̵� ���� �˰���
		// ��带 1������ N������ ���İ��� ��츦 ��� ����Ѵ�.
		for (int k = 0; k < N; k++) {
			// ��� i���� j�� ���� ���.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// k��° ��带 ���İ��� ����� ���� ��뺸�� �� ���� ��� ����
					// �Ǵ� ������ �ȵǾ��ִ� ���(INF) ���� ��� ����.
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		// ���
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// ������ �ȵǾ� �ִ� ���
				if (dist[i][j] == 100_000_000) {
					System.out.print("INF ");
				} else {
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
