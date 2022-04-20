import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LongSummaryStatistics;

public class BenchCompare {

    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        LongSummaryStatistics httpRequestSummaryStatistics = HttpModeBench.runHttpBench("localhost", 3001, 10000, 1);
        Thread.sleep(2000);
        LongSummaryStatistics gRpcSummaryStatistics = GrpcModeBench.rungRPCBench("localhost", 6065, 10000, 1);
        CallStatistics.printStatistics(httpRequestSummaryStatistics, "REST HTTP bench of running " + 10000 + " requests");
        CallStatistics.printStatistics(gRpcSummaryStatistics, "gRPC bench of running " + 10000 + " requests");
    }
}
