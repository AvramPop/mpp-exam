package org.example.web.dto;

import lombok.*;

import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Builder
public class DataServerDto {
  private String countyName;
  private int a, b, c, nr;
}
