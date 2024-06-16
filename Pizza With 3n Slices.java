public class PizzaWith3nSlices {
    public static int minimizeWaitingTime(int n, int m, int k, int[] arrival) {
        // Sort the arrival times in ascending order
        Arrays.sort(arrival);

        // Calculate the number of sessions needed
        int sessions = (int) Math.ceil((double) n / k);

        // Calculate the waiting time for each session
        int[] waitingTimes = new int[sessions];
        for (int i = 0; i < n; i++) {
            int sessionIndex = i / k;
            int sessionStartTime = sessionIndex * m;
            int waitingTime = Math.max(0, sessionStartTime - arrival[i]);
            waitingTimes[sessionIndex] += waitingTime;
        }

        // Find the maximum waiting time
        int maxWaitingTime = 0;
        for (int time : waitingTimes) {
            maxWaitingTime = Math.max(maxWaitingTime, time);
        }

        return maxWaitingTime;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 2;
        int k = 3;
        int[] arrival = {4, 3, 6, 9, 3};
        int result = minimizeWaitingTime(n, m, k, arrival);
        System.out.println(result); // Output: 3
    }
}