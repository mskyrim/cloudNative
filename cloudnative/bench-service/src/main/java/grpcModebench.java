import com.rose.msgservice.ping.GrpcPingServiceGrpc;
import com.rose.msgservice.ping.PingRequest;
import com.rose.msgservice.ping.PingResponse;
import io.grpc.ManagedChannelBuilder;

import java.util.LongSummaryStatistics;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

public class grpcModebench {

    public static void main(String[] args) throws InterruptedException {
        LongSummaryStatistics requestSummaryStatistics = new LongSummaryStatistics();
        var managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 6065)
                .usePlaintext()
                .build();
        GrpcPingServiceGrpc.GrpcPingServiceBlockingStub stub = GrpcPingServiceGrpc.newBlockingStub(managedChannel);
        var countDownLatch = new CountDownLatch(100);
        var threadExecutorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            threadExecutorService.submit(() -> {
                long startProcessingTime = System.currentTimeMillis();
                var param = "Hello";
                PingResponse response = stub.ping(PingRequest.newBuilder().setMessage(param).build());
                System.out.println("Response is " + response);
                long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;
                requestSummaryStatistics.accept(totalProcessingTime);
                System.out.println("Request " + countDownLatch.getCount() + " done in : " + totalProcessingTime);
                countDownLatch.countDown();

            });
        }

        CallStatistics.printStatistics(requestSummaryStatistics, countDownLatch, threadExecutorService);
    }

}
