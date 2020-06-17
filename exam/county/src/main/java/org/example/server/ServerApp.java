package org.example.server;

import org.example.server.domain.Sensor;
import org.example.server.infrastructure.HandlerManager;
import org.example.server.infrastructure.TCPServer;
//import org.example.server.service.ScannerService;
//import org.example.server.service.SensorService;
import org.example.server.service.ScannerCountyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApp {

  public static void main(String[] args) {

    System.out.println("server started");

    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext("org.example.server.config");
    ExecutorService executorService =
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    try{
      System.out.println("Enter county name: ");
      String name = input.readLine().strip();
      System.out.println("Enter county id: ");
      int id = Integer.parseInt(input.readLine().strip());
      ScannerCountyService scannerCountyService =
          context.getBean(ScannerCountyService.class);
      RestTemplate restTemplate = context.getBean(RestTemplate.class);
      scannerCountyService.setRestTemplate(restTemplate);
      try {
        TCPServer tcpServer = new TCPServer(executorService, 1234 + id);
        HandlerManager handlerManager =
            new HandlerManager(tcpServer, scannerCountyService, name, id, restTemplate);
        handlerManager.addHandlers();
        tcpServer.startServer();
        executorService.shutdown();
      } catch (RuntimeException ex) {
        ex.printStackTrace();
      }
    } catch(IOException e){
      e.printStackTrace();
    }

//
//    sensorService.setExecutorService(executorService);
//    ScannerService scannerService =
//        context.getBean(ScannerService.class);

//    scannerService.setExecutorService(executorService);

  }
}
