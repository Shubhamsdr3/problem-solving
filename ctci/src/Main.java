import java.util.*;


class Job {
    int start, profit, finish;

    Job(int start,int profit, int finish) {
        this.start = start;
        this.profit = profit;
        this.finish = finish;
    }
};

class Main {

    public static int findLastNonConflictingJob(List<Job> jobs, int n) {
        for (int i = n - 1; i >= 0; i--) {
            if (jobs.get(i).finish <= jobs.get(n).start) {
                return i;
            }
        }
        return -1;
    }

    private static int maxProfit(List<Job> jobs, int n) {
        Collections.sort(jobs, Comparator.comparingInt(x -> x.finish));

        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return jobs.get(0).profit;
        }
        int index = findLastNonConflictingJob(jobs, n);
        int incl = jobs.get(n).profit + maxProfit(jobs, index);
        int excl = maxProfit(jobs, n - 1);
        return Math.max(incl, excl);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        List<Job> list = new ArrayList<>();
        while (testCase > 0) {
            int tasks = sc.nextInt();
            while (tasks > 0) {
                list.add(new Job(sc.nextInt(), sc.nextInt(), sc.nextInt()));
                tasks--;
            }

            System.out.println(maxProfit(list, list.size() - 1));
            testCase--;
        }

    }
}