class Solution {
    public long continuousSubarrays(int[] nums) {
     
       long count=0;
       int start=0;
       int end=0;
        PriorityQueue<Integer> minH = new PriorityQueue<>();//minheap
        PriorityQueue<Integer> maxH = new PriorityQueue<>((a, b) -> b - a);

        while(end<nums.length){
            maxH.offer(nums[end]);
             minH.offer(nums[end]);
             while((maxH.peek()-minH.peek()>2)&&maxH.isEmpty()==false&&minH.isEmpty()==false)
             {
                maxH.remove(nums[start]);
                minH.remove(nums[start]);
                start++;
             }
              count+= end*1L-start*1L+ 1*1L;
             end++;
        }
        return count;
    }
}