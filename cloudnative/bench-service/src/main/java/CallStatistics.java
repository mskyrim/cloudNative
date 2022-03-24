import java.util.LongSummaryStatistics;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public class CallStatistics {
    static void printStatistics(LongSummaryStatistics requestSummaryStatistics, CountDownLatch countDownLatch, ExecutorService threadExecutorService) {
        try {
            countDownLatch.await();
            // Use various methods to obtain the data
            System.out.println("The count of values is "
                    + requestSummaryStatistics.getCount());
            System.out.println("The average of values is "
                    + requestSummaryStatistics.getAverage());
            System.out.println("The sum of values is "
                    + requestSummaryStatistics.getSum());
            System.out.println("The maximum of values is "
                    + requestSummaryStatistics.getMax());
            System.out.println("The minimum of values is "
                    + requestSummaryStatistics.getMin());
            threadExecutorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}