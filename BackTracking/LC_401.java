package BackTracking;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> results = new ArrayList<>();

        for(int hour = 0 ; hour <= 11; hour++){
            for(int minute = 0 ; minute <= 59; minute++){

                int hourBits = Integer.bitCount(hour);
                int minuteBits = Integer.bitCount(minute);

                if(hourBits + minuteBits == turnedOn){
                    String time = hour + ":" + (minute < 10 ? "0" + minute : minute);
                    results.add(time);
                }

            }
        }
        return results;
        
    }
}
