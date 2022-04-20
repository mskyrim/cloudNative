import com.rose.msgservice.ping.GrpcPingServiceGrpc;
import com.rose.msgservice.ping.PingRequest;
import com.rose.msgservice.ping.PingResponse;
import io.grpc.ManagedChannelBuilder;

import java.util.LongSummaryStatistics;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GrpcModeBench {

    public static void main(String[] args) throws InterruptedException {
        LongSummaryStatistics requestSummaryStatistics = rungRPCBench("localhost", 6065, 10000, 10);
        CallStatistics.printStatistics(requestSummaryStatistics, "gRPC bench of running " + 10000 + " request");
    }

    public static LongSummaryStatistics rungRPCBench(final String host, final int port, final int nbRequests, final int nbThreads) throws InterruptedException {
        LongSummaryStatistics requestSummaryStatistics = new LongSummaryStatistics();
        var managedChannel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();
        GrpcPingServiceGrpc.GrpcPingServiceBlockingStub stub = GrpcPingServiceGrpc.newBlockingStub(managedChannel);
        var countDownLatch = new CountDownLatch(nbRequests);
        var threadExecutorService = Executors.newFixedThreadPool(nbThreads);

        for (int i = 0; i < nbRequests; i++) {
            //doGrpcRequestMultiThreads(requestSummaryStatistics, stub, countDownLatch, threadExecutorService, i);
            doGrpcRequestMainThread(requestSummaryStatistics, stub, i);
        }

        return requestSummaryStatistics;
    }

    private static void doGrpcRequestMultiThreads(LongSummaryStatistics requestSummaryStatistics, GrpcPingServiceGrpc.GrpcPingServiceBlockingStub stub, CountDownLatch countDownLatch, ExecutorService threadExecutorService, int index) throws InterruptedException {
        threadExecutorService.submit(() -> {
            long startProcessingTime = System.currentTimeMillis();
            var param = "Hello " + index;
            PingResponse response = stub.ping(PingRequest.newBuilder().setMessage(param).build());
            System.out.println("Response is " + response);
            long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;
            requestSummaryStatistics.accept(totalProcessingTime);
            System.out.println("Request " + index + " done in : " + totalProcessingTime);
            countDownLatch.countDown();
        });
        countDownLatch.await();
        threadExecutorService.shutdown();
    }

    private static void doGrpcRequestMainThread(LongSummaryStatistics requestSummaryStatistics, GrpcPingServiceGrpc.GrpcPingServiceBlockingStub stub, int index) {
        long startProcessingTime = System.currentTimeMillis();
        var param = "Hello " + index;
        PingResponse response = stub.ping(PingRequest.newBuilder().setMessage(param).build());
        //System.out.println("Response is " + response);
        long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;
        requestSummaryStatistics.accept(totalProcessingTime);
        //System.out.println("Request " + index + " done in : " + totalProcessingTime);
    }

}
