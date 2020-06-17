package org.example.server.infrastructure;

//import org.example.server.service.ScannerService;
//import org.example.server.service.SensorService;

import java.util.Random;

public class HandlerManager {
  private final TCPServer server;
//  private final ScannerService scannerService;
  boolean keepGoing = true;
  String toShutdown;
  //  private final StudentService studentService;

  public HandlerManager(TCPServer server) {
    this.server = server;
//    this.scannerService = scannerService;
  }

  private void addScannerHandler() {
    server.addHandler(
        MessageHeader.SCANNER_ADD,
        (request) -> {
          //          System.out.println("received" + request.getBody());
          String[] parsedRequest = request.getBody().split(",");
          //          try {
          System.out.println("RECEIVED");
          System.out.println(parsedRequest[0]);
          System.out.println(Integer.parseInt(parsedRequest[2]));
          System.out.println(Integer.parseInt(parsedRequest[3]));
          System.out.println(Integer.parseInt(parsedRequest[4]));
          try{
            Thread.sleep(new Random().nextInt(4000));
          } catch(InterruptedException e){
            e.printStackTrace();
          }
          return new Message("", "");
          //            scannerService.saveScanner(
          //                parsedRequest[0],
          //                Integer.parseInt(parsedRequest[1]),
          //                Integer.parseInt(parsedRequest[2]),
          //                Integer.parseInt(parsedRequest[3]),
          //                Integer.parseInt(parsedRequest[4]));
          //          } catch (InterruptedException e) {
          //            e.printStackTrace();
          //          }
          //          if (keepGoing) {
          //            return new Message(MessageHeader.OK_REQUEST, "");
          //          } else {
          //            if (parsedRequest[0].equals(toShutdown)) {
          //              System.out.println("dying");
          //              return new Message(MessageHeader.CLIENT_SHUTDOWN, toShutdown);
          //            }
          //            return new Message(MessageHeader.OK_REQUEST, "");
          //          }
        });
  }

//  private void addScannerHandler() {
//    server.addHandler(
//        MessageHeader.SCANNER_ADD,
//        (request) -> {
//          String[] parsedRequest = request.getBody().split(",");
//          try {
//            scannerService.saveSensor(
//                parsedRequest[0],
//                Integer.parseInt(parsedRequest[1]),
//                Integer.parseInt(parsedRequest[2]));
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
//          if (keepGoing) {
//            return new Message(MessageHeader.OK_REQUEST, "");
//          } else {
//            if (parsedRequest[0].equals(toShutdown)) {
//              System.out.println("dying");
//              return new Message(MessageHeader.CLIENT_SHUTDOWN, toShutdown);
//            }
//            return new Message(MessageHeader.OK_REQUEST, "");
//          }
//        });
//  }

  public void addHandlers() {
    addScannerHandler();
    serverShutdownHandler();
  }

  private void serverShutdownHandler() {
    server.addHandler(
        MessageHeader.CLIENT_SHUTDOWN,
        (request) -> {
          System.out.println("received" + request.getBody());
          keepGoing = false;
          toShutdown = request.getBody();
          System.out.println(toShutdown);
          return new Message(MessageHeader.BAD_REQUEST, "");
        });

  }
}
