package org.example.sensor.ui;

import org.example.sensor.service.ScannerClientService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/** Console based user interface for the client. */
public class Console {
  private ScannerClientService sensorClientService;
  private HashMap<String, Runnable> dictionaryOfCommands;
  private ExecutorService executorService;

  public Console(ScannerClientService sensorClientService, ExecutorService executorService) {
    this.sensorClientService = sensorClientService;
    this.executorService = executorService;
    // I use lambda methods with a hash table to not to make if statements
    // if the thing fails it gets a null pointer exception
    // which means not a valid command
  }

  /** Take specific user input and print server's answer to the call getLabProblemById call. */
//  private void shutDownServer() {
//    studentService.shutDownServer();
//    System.exit(0);
//  }

  public void run() {
//    while (true) {
//      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//      try {
//        String inputString = input.readLine();
//        dictionaryOfCommands.get(inputString).run();
//      } catch (ConnectException ex) {
//        System.out.println(ex.getMessage());
//      } catch (IOException ex) {
//        System.out.println("Error with input!");
//      } catch (NullPointerException ex) {
//        System.out.println("Not a vaild comand");
//      }
//    }
    addScanner();
  }

  /** Take specific user input and print server's answer to the call addStudent call. */
  private void addScanner() {
    System.out.println("Read scanner {name, id}");
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    try {
      System.out.println("Enter name: ");
      String name = input.readLine().strip();
      System.out.println("Enter county id: ");
      int id = Integer.parseInt(input.readLine().strip());

      sensorClientService.sendData(name, id);

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
