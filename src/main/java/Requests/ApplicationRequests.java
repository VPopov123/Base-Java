package Requests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.net.URL;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class ApplicationRequests {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static final HttpClient httpClient = HttpClient.newBuilder()
                                                    .executor(executorService)
                                                    .version(HttpClient.Version.HTTP_2)
                                                    .connectTimeout(Duration.ofSeconds(10))
                                                    .build();

    public static void main(String[] args) throws Exception {
        List<URI> targets = Arrays.asList(
                new URI("https://swapi.dev/api/people/1"),
                new URI("https://swapi.dev/api/starships/2"),
                new URI("https://swapi.dev/api/planets/3"),
                new URI("https://swapi.dev/api/species/4"),
                new URI("https://swapi.dev/api/starships/12"),
                new URI("https://swapi.dev/api/people/6"),
                new URI("https://swapi.dev/api/starships/10"),
                new URI("https://swapi.dev/api/planets/8"),
                new URI("https://swapi.dev/api/species/9"),
                new URI("https://swapi.dev/api/starships/13"));
        List<CompletableFuture<String>> result = targets.stream()
                                                        .map(url -> httpClient.sendAsync(
                                                                HttpRequest.newBuilder(url).build(),
                                                                HttpResponse.BodyHandlers.ofString())

                                                                .thenApply(HttpResponse::body))
                                                                .collect(Collectors.toList());

        for (var future: result) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
