package org.example.server.domain;


import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ScannerDto implements Serializable {

  private String name;

  private int countyId;

  private int a, b, c;


  }
