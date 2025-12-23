package BackTracking;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<String> permuteString(String s) {
        List<String> result = new ArrayList<>();
        char[] arr = s.toCharArray();
        solve(arr, 0, result);
        return result;
    }

    private void solve(char[] arr, int index, List<String> result) {
        if (index == arr.length) {
            result.add(new String(arr)); 
            return;
        }

        for (int i = index; i < arr.length; i++) {
            // swap
            char temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

            solve(arr, index + 1, result);

            // backtrack
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}

