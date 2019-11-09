package greedyalgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * From CLRS:
 * Every job takes one unit of time.
 * We get profit only when completes the job within the given deadline.
 */
public class JobSequencing {

    private static void jobScheduling(List<Job> jobArray, int n) {
        // Sort the array based on their profit in decreasing order.
        jobArray.sort((o1, o2) -> o2.getProfit() - o1.getProfit());

        List<Job> result = new ArrayList<>(jobArray.size());
        Optional<Job> maxDeadlineJob = jobArray.stream().max(Comparator.comparing(Job::getDeadLine));
        boolean[] slots = new boolean[maxDeadlineJob.orElse(null).getDeadLine()];

        for (int i=0; i<n -1; i++) {
            for (int j= Math.min(n, jobArray.get(i).getDeadLine()) - 1; j >= 0; j--) {
                if (!slots[i]) {
                    result.add(jobArray.get(i));  // Add this job to result
                    slots[j] = true; // Make this slot occupied
                    break;
                }
            }
        }
        for (int k=0; k<n -1; k++) {
            if (slots[k]) {
                System.out.println(result.get(k));
            }
        }
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job('a', 2, 100));
        jobs.add(new Job('b', 1, 19));
        jobs.add(new Job('c', 2, 27));
        jobs.add(new Job('d', 1, 25));
        jobs.add(new Job('e', 3, 15));
        int n = jobs.size();
        jobScheduling(jobs, 3);
    }

    static class Job {

        private char jobId;

        private int deadLine;

        private int profit;

        Job(char jobId, int deadLine, int profit) {
            this.jobId = jobId;
            this.deadLine = deadLine;
            this.profit = profit;
        }

        public int getJobId() {
            return jobId;
        }

        int getDeadLine() {
            return deadLine;
        }

        int getProfit() {
            return profit;
        }
    }
}


