class Solution {
    
   class KeyValue {
        int key;
        int value;

        public  KeyValue(int key, int value) {
            this.key = key;
            this.value = value;
        }}
    
    public boolean carPooling(int[][] trips, int capacity) {
     
        int n=trips.length;
        Map<Integer,Integer>map= new HashMap<>();
        Set<Integer>list= new HashSet<>();
      for(int i=0;i<n;i++){
        map.put(trips[i][1],map.getOrDefault((trips[i][1]),0)+trips[i][0]);
        map.put(trips[i][2],map.getOrDefault((trips[i][2]),0)-trips[i][0]);
        list.add(trips[i][2]);
        list.add(trips[i][1]);
      }
PriorityQueue<KeyValue> pq = new PriorityQueue<>(Comparator.comparingInt(k -> k.key));
for(Map.Entry<Integer,Integer>entry:map.entrySet()){
    pq.offer(new KeyValue(entry.getKey(),entry.getValue()));
}
     int curr=0;
    while(!pq.isEmpty()){
        curr+=pq.poll().value;
        if(curr>capacity){
            return false;
        }
    }
      return true;
        

    }
}