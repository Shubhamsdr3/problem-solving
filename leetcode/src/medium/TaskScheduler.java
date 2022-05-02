package medium;

public class TaskScheduler {

    /**
     * TODO
     * @param tasks
     * @param n
     * @return
     */
    private static int leastInterval(char[] tasks, int n) {
        for (int i = 0; i < tasks.length; i++) {
            char task = tasks[i];
            int count = n;
            for (int j = i + 1; j < tasks.length; j++) {
                if (count > 0 && tasks[j] != task) { // there is different task
                    tasks[j] = 'a';
                } else { // idle

                }
                count--;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
