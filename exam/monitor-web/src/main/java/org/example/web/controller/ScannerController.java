package org.example.web.controller;

import org.example.web.dto.DataServerDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// import org.example.web.dto.SensorsDto;

@RestController
public class ScannerController {
  //
  //  @Autowired private SensorServiceCore sensorService;
  //
  //  @Autowired
  //  private SensorConverter sensorConverter;
  //
  @RequestMapping(value = "/api/voting", method = RequestMethod.POST)
  public DataServerDto getCountyData(@RequestBody DataServerDto dataServerDto) {
    System.out.println("National server received data:");
    System.out.println(dataServerDto.getCountyName());
    System.out.println(dataServerDto.getA());
    System.out.println(dataServerDto.getB());
    System.out.println(dataServerDto.getC());
    System.out.println(dataServerDto.getNr());
    return new DataServerDto();
    //    List<Sensor> sensors = sensorService.getAllSensors();
    //    return new SensorsDto(sensorConverter.convertModelsToDtos(sensors));
  }
  //
  //  @RequestMapping(value = "/names", method = RequestMethod.GET)
  //  public NamesDto getSensorNames() {
  //    List<String> sensors = sensorService.getAllSensorNames();
  //    return new NamesDto(sensorConverter.convertNamesToDto(sensors));
  //  }
  //
  //  @RequestMapping(value = "/sensors/{name}", method = RequestMethod.GET)
  //  public SensorsDto getSensorNames(@PathVariable String name) {
  //    List<Sensor> sensors = sensorService.findFirstFourForName(name);
  //    return new SensorsDto(sensorConverter.convertModelsToDtos(sensors));
  //  }
  //
  //  @RequestMapping(value = "/stop/{name}", method = RequestMethod.POST)
  //  public SensorsDto stopSensor(@PathVariable String name) {
  //    System.out.println("controller" + name);
  //    sensorService.stopSensor(name);
  //    return new SensorsDto();
  //  }
}
