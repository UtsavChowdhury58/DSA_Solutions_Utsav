class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] count=new int [n];
        int[][]connect= new int [n][n];
        for(int []road:roads){
            count [road[0]]++;
             count [road[1]]++;
             connect[road[0]][road[1]]=1;
             connect[road[1]][road[0]]=1;
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int road=count[i]+count[j]-connect[i][j];
                max=Math.max(max,road);
            }
        }
        return max;
    }
}