package Queue;
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int timereq = 0 ;

        int tk = tickets[k];
        for(int i = 0 ; i < tickets.length; i++){
            if(i <= k){
                timereq += Math.min(tickets[i] , tk);
            }
            else{
                timereq += Math.min(tickets[i] , tk - 1);
            }
        }
        return timereq;
        
    }
}
