package org.example.sensor.service;

import org.example.sensor.infrastructure.TCPClient;
import org.example.server.domain.ScannerDto;
import org.example.server.infrastructure.Message;
import org.example.server.infrastructure.MessageHeader;
import org.example.server.infrastructure.StringEntityFactory;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class ScannerClientService {
  private final ExecutorService executorService;
  private final TCPClient tcpClient;
  public ScannerClientService(ExecutorService executorService, TCPClient tcpClient){
    this.executorService = executorService;
    this.tcpClient = tcpClient;
  }

  public void sendData(String name, int id) throws InterruptedException{
    boolean stop = false;
//    var wrapper = new Object(){ boolean stop = false; };
    while (true) {
      int a = ThreadLocalRandom.current().nextInt(0, 2);
      int b = ThreadLocalRandom.current().nextInt(0, 2);
      int c = ThreadLocalRandom.current().nextInt(0, 2);
      ScannerDto scanner = ScannerDto.builder().name(name).countyId(id).a(a).b(b).c(c).build();
      executorService.submit(
          () -> {
            Message request =
                new Message(MessageHeader.SCANNER_ADD, StringEntityFactory.scannerToFileLine(scanner));
            request.setPORT(id);
            Message response = tcpClient.sendAndReceive(request);
          });
      Thread.sleep(new Random().nextInt(5000));
    }
  }
}
