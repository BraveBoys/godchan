package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class FindShortCut {
	static int V,E,Start,INF=Integer.MAX_VALUE;
    static int dist[];
    static ArrayList<Point> arrList[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        arrList = new ArrayList[V+1];
        dist = new int[V+1];
        for(int i=1; i<=V; i++)
            arrList[i] = new ArrayList<>();
        for(int i=1; i<=V; i++)
            dist[i] = INF;
        
        Start = Integer.parseInt(br.readLine());
        dist[Start] = 0;
        
        for(int e=0; e<E; e++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            arrList[u].add(new Point(v, val));
        }
        solve();
        for(int i=1; i<=V; i++) {
            if(dist[i] == INF)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }
    
    public static void solve() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        // PriorityQueue = (Vertex, weight)
        pq.add(new Point(Start, 0));
        
        while(!pq.isEmpty()) {
            Point po = pq.poll();
            
            // �����Ϸ��� �ϴ� ���� PQ���� poll�� ����� ������ ���� �� ���� X
            if(dist[po.vertex] < po.val)
                continue;
            
            // ���� ��忡 ����� Vertex�� ���� �� ArrayList�� �ݺ����� ���� Ž���ϸ� �� ���� ������ ������ �� �ִٸ� �����ϸ鼭 PQ�� �־��ش�.
            for(int i=0; i<arrList[po.vertex].size(); i++) {
                int tmpIndex = arrList[po.vertex].get(i).vertex;
                int tmpDist = po.val + arrList[po.vertex].get(i).val;
                
                if(dist[tmpIndex] > tmpDist) {
                    dist[tmpIndex] = tmpDist;
                    pq.add(new Point(tmpIndex, tmpDist));
                }
            }
        }
    }
    
    // �켱����ť�� ���ϰ� ����ϱ� ���� ���ı��� ����
    public static class Point implements Comparable<Point>{
        int vertex;
        int val;
        public Point(int v, int val) {
            this.vertex=v;
            this.val=val;
        }
        @Override
        public int compareTo(Point o) {
            if(this.val > o.val)
                return 1;
            // TODO Auto-generated method stub
            return 0;
        }
        
    }
}