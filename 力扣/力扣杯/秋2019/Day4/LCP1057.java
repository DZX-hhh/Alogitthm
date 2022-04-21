package 力扣.力扣杯.秋2019.Day4;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LCP1057 {

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length; // n <= m
        int m = bikes.length;

        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> {
            //优先级(距离,工人索引,自行车索引)
            if (a.distance != b.distance) return a.distance - b.distance;
            if (a.worker != b.worker) return a.worker - b.worker;
            return a.bike - b.bike;
        });
        //每个工人的分配的自行车的索引
        int[] answer = new int[n];
        //工人的索引
        Set<Integer> workerPool = new HashSet<>();
        //自行车的索引
        Set<Integer> bikePool = new HashSet<>();

        for (int i = 0; i < n; i++) workerPool.add(i);
        for (int i = 0; i < m; i++) bikePool.add(i);


        //计算每个工人和每个自行车的距离
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Pair p = new Pair(i, j, workers[i], bikes[j]);
                heap.offer(p);
            }
        }

        while (workerPool.size() > 0) {
            Pair p = heap.poll();
            //开始分配,,如果分配了就需要将对应的工人索引和自行车索引去掉,唯一分配
            if (workerPool.contains(p.worker) && bikePool.contains(p.bike)) {
                answer[p.worker] = p.bike;
                workerPool.remove(p.worker);
                bikePool.remove(p.bike);
            }
        }
        return answer;
    }

    /**
     * @param worker 工人坐标
     * @param bike   自行车坐标
     * @return 距离
     */
    private int manhattanDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    class Pair {
        int worker;
        int bike;
        int distance;

        /**
         * @param worker 工人索引
         * @param bike   自行测索引
         * @param wc     工人坐标
         * @param bc     自行车坐标
         */
        Pair(int worker, int bike, int[] wc, int[] bc) {
            this.worker = worker;
            this.bike = bike;
            distance = manhattanDistance(wc, bc);
        }
    }
}
