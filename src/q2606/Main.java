package q2606;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N,E, cnt;
	static boolean[] visited;
	static boolean[][] map;
	
	public static void DFS(int v) {
		int i;
		
		for(i=1;i<N;i++) {
			if(visited[i]) continue;
			if(!map[v][i]) continue;
			
			cnt++;
			visited[i] = true;
			DFS(i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		int i;
		int u,v;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		E = Integer.parseInt(in.readLine());
		map = new boolean[N][N];
		visited = new boolean[N];
		
		for(i=0;i<E;i++) {
			st = new StringTokenizer(in.readLine());
			u = Integer.parseInt(st.nextToken()) - 1;
			v = Integer.parseInt(st.nextToken()) - 1;
			map[u][v] = true;
			map[v][u] = true;
		}
		
		cnt = 0;
		visited[0] = true;
		DFS(0);
		
		out.write(String.valueOf(cnt));
		out.flush();
		
		in.close();
		out.close();
	}
}
