import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LongSummaryStatistics;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpModeBench {

    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        LongSummaryStatistics requestSummaryStatistics = runHttpBench("localhost", 3001, 10000, 10);
        CallStatistics.printStatistics(requestSummaryStatistics, "REST HTTP bench of running " + 10000 + " request");
    }

    public static LongSummaryStatistics runHttpBench(final String host, final int port, final int nbRequests, final int nbThreads) throws InterruptedException, URISyntaxException, IOException {
        var requestSummaryStatistics = new LongSummaryStatistics();
        var countDownLatch = new CountDownLatch(nbRequests);
        var threadExecutorService = Executors.newFixedThreadPool(nbThreads);
        var httpClient = HttpClient.newBuilder().build();

        for (int i = 0; i < nbRequests; i++) {
            var param = """
                    {
                        "ping": "Hello %d"
                    }
                    """.formatted(i);
            var httpRequest = HttpRequest.newBuilder(new URI("http://" + host + ":" + port + "/ping"))
                    .POST(HttpRequest.BodyPublishers.ofString(param))
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .build();
            //doHttpRequest(requestSummaryStatistics, countDownLatch, httpClient, httpRequest, threadExecutorService, i);
            doHttpRequestMainThread(requestSummaryStatistics, httpClient, httpRequest, i);
        }
        return requestSummaryStatistics;
    }

    private static void doHttpRequest(LongSummaryStatistics requestSummaryStatistics, CountDownLatch countDownLatch, HttpClient httpClient, HttpRequest httpRequest, ExecutorService threadExecutorService, int index) throws IOException, InterruptedException {
        threadExecutorService.submit(() -> {
            try {
                long startProcessingTime = System.currentTimeMillis();
                HttpResponse<String> stringHttpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                System.out.println(stringHttpResponse.body());
                long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;
                requestSummaryStatistics.accept(totalProcessingTime);
                System.out.println("Request " + index + " done in : " + totalProcessingTime);
                countDownLatch.countDown();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        countDownLatch.await();
        threadExecutorService.shutdown();
    }

    private static void doHttpRequestMainThread(LongSummaryStatistics requestSummaryStatistics, HttpClient httpClient, HttpRequest httpRequest,int index) throws IOException, InterruptedException {
        long startProcessingTime = System.currentTimeMillis();
        HttpResponse<String> stringHttpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        //System.out.println(stringHttpResponse.body());
        long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;
        requestSummaryStatistics.accept(totalProcessingTime);
        //System.out.println("Request " + index + " done in : " + totalProcessingTime);

    }
}
