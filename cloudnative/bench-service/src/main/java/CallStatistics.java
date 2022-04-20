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

    static void printStatistics(LongSummaryStatistics requestSummaryStatistics, final String title) {
        // Use various methods to obtain the data
        System.out.println("=================================");
        System.out.println("============" + title + "================");
        System.out.println("=================================");
        System.out.println("The count of values : "
                + requestSummaryStatistics.getCount());
        System.out.println("The average of values : "
                + requestSummaryStatistics.getAverage());
        System.out.println("The sum of values : "
                + requestSummaryStatistics.getSum());
        System.out.println("The maximum of values : "
                + requestSummaryStatistics.getMax());
        System.out.println("The minimum of values : "
                + requestSummaryStatistics.getMin());
        System.out.println("=================================");
    }
}