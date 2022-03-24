import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LongSummaryStatistics;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

public class HttpModeBench {

    public static void main(String[] args) throws InterruptedException {
        LongSummaryStatistics requestSummaryStatistics = new LongSummaryStatistics();
        var countDownLatch = new CountDownLatch(100);
        var threadExecutorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            threadExecutorService.submit(() -> {
                long startProcessingTime = System.currentTimeMillis();
                var httpClient = HttpClient.newBuilder().build();
                try {
                    var param = """
                            {
                                "ping": "Hello"
                            }
                            """;
                    var httpRequest = HttpRequest.newBuilder(new URI("http://localhost:3001/ping"))
                            .POST(HttpRequest.BodyPublishers.ofString(param))
                            .header("Content-Type", "application/json;charset=UTF-8")
                            .build();
                    HttpResponse<String> stringHttpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                    System.out.println(stringHttpResponse.body());
                    long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;
                    requestSummaryStatistics.accept(totalProcessingTime);
                    System.out.println("Request " + countDownLatch.getCount() + " done in : " + totalProcessingTime);
                    countDownLatch.countDown();
                } catch (IOException | InterruptedException | URISyntaxException e) {
                    e.printStackTrace();
                }
            });
        }

        CallStatistics.printStatistics(requestSummaryStatistics, countDownLatch, threadExecutorService);
    }
}
