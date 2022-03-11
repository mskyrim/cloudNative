import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpModeBench {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        var httpClient = HttpClient.newBuilder().build();

        var httpRequest = HttpRequest.newBuilder(new URI("http://localhost:3001/message"))
                .GET()
                .header("Content-Type", "application/json;charset=UTF-8")
                .build();

        HttpResponse<String> stringHttpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(stringHttpResponse.body());
    }
}
