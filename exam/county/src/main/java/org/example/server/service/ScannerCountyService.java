package org.example.server.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

public interface ScannerCountyService {

  void postData(boolean started, String name, int a, int b, int c);
  public void setRestTemplate(RestTemplate restTemplate);
}
