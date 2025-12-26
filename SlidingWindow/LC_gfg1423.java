package SlidingWindow;
class Solution {
    public int maxScore(int[] cardPoints, int k) {
      int n = cardPoints.length;
      
      int totalSum = 0;
      for(int x : cardPoints){
          totalSum += x;
      }

      int windowSize = n - k;
      //if(windowSize == 0) return totalSum;
    
      int windowsum = 0;
      for(int i = 0 ; i < windowSize; i++){
        windowsum += cardPoints[i];
      }

      int minWindowSum = windowsum;

      for(int i = windowSize; i < n ; i++){
        windowsum += cardPoints[i];
        windowsum -= cardPoints[i - windowSize];
        minWindowSum = Math.min(minWindowSum , windowsum);
        
      }
      return totalSum - minWindowSum;
        
    }
}
