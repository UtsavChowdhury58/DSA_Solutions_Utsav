import java.util.PriorityQueue;



class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder()); // Max heap
        double sum = 0;
        int count = 0;
        
        for (int num : nums) {
            sum += num;
            pq.add((double) num); // Convert to double
        }
        
        // int half = (int) (sum / 2);
        double nsum = sum;
        
        while (nsum > sum/2) {
            double a = pq.poll();
            nsum -= a;
            a /= 2;
            pq.add(a);
            nsum += a;
            count++;
        }
        
        return count;
    }
}
