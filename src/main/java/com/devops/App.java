package com.devops;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class App {
    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", port), 0);

        server.createContext("/", exchange -> {
            String html = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>DevOps CI/CD Project</title>
                  <style>
                    * { box-sizing: border-box; }
                    body { margin: 0; font-family: Arial, sans-serif; background: #101827; color: #f8fafc; }
                    main { max-width: 760px; margin: 10vh auto; padding: 36px; }
                    .card { padding: 34px; border: 1px solid #334155; border-radius: 18px; background: #1e293b; }
                    .tag { display: inline-block; padding: 7px 12px; border-radius: 20px; background: #14532d; color: #bbf7d0; }
                    h1 { font-size: 2.4rem; margin: 22px 0 12px; }
                    p { color: #cbd5e1; line-height: 1.7; }
                    li { margin: 10px 0; color: #e2e8f0; }
                    footer { margin-top: 26px; color: #94a3b8; font-size: .9rem; }
                  </style>
                </head>
                <body>
                  <main>
                    <section class="card">
                      <span class="tag">Deployment successful</span>
                      <h1>Hello, DevOps Engineer!</h1>
                      <p>This Java application was built with Maven, packaged into a Docker image,
                         and deployed through a Jenkins Declarative CI/CD pipeline.</p>
                      <h2>Pipeline tools</h2>
                      <ul>
                        <li>Git &amp; GitHub</li>
                        <li>Jenkins Declarative Pipeline</li>
                        <li>Java 21 &amp; Maven</li>
                        <li>Docker &amp; Docker Hub</li>
                        <li>Docker Compose</li>
                      </ul>
                      <footer>DevOps CI/CD Portfolio Project · Version 1.0.0</footer>
                    </section>
                  </main>
                </body>
                </html>
                """;
            byte[] response = html.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            exchange.getResponseHeaders().set("Cache-Control", "no-store");
            exchange.sendResponseHeaders(200, response.length);
            try (var output = exchange.getResponseBody()) {
                output.write(response);
            }
        });

        server.start();
        System.out.println("DevOps CI/CD app started on port " + port);
    }
}
