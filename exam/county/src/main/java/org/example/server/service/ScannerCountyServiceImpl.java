package org.example.server.service;

import org.example.web.dto.DataServerDto;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ScannerCountyServiceImpl implements ScannerCountyService {
  Thread thread;
  String name;
  int a, b, c, nr;
  private static final String baseURL = "http://localhost:8080/api";
  private RestTemplate restTemplate;
  boolean updated;

  public void setRestTemplate(RestTemplate restTemplate){
    updated = true;
    this.restTemplate = restTemplate;
    thread =
        new Thread(
            () -> {
              while (true) {
                try {
                  Thread.sleep(5000);
                  if (updated) {
                    System.out.println("------------------------------------");
                    HttpEntity<DataServerDto> studentDtoHttpEntity =
                        new HttpEntity<>(new DataServerDto(name, a, b, c, nr));
                    ResponseEntity<DataServerDto> response =
                        restTemplate.exchange(
                            baseURL + "/voting",
                            HttpMethod.POST,
                            studentDtoHttpEntity,
                            DataServerDto.class);
                    this.updated = false;
                  } else {
                    System.out.println("data not changed");
                  }
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });
    thread.start();
  }
  @Override
  public void postData(boolean started, String name, int a, int b, int c){
    this.name = name;
    this.a += a;
    this.b += b;
    this.c += c;
      this.nr += a + b + c;
      this.updated = true;

  }
}
