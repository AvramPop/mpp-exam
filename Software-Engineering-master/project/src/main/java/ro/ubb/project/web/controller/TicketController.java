package ro.ubb.project.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.project.web.dto.DataServerDto;

import java.util.List;

@RestController
//@RequestMapping("/api/ticket")
public class TicketController {

    @RequestMapping(value = "/api/voting", method = RequestMethod.POST)
    public DataServerDto getCountyData(@RequestBody DataServerDto dataServerDto) {
        System.out.println("National server received data:");
        System.out.print(dataServerDto.getCountyName() + " ");
        System.out.print(dataServerDto.getA() + " ");
        System.out.print(dataServerDto.getB() + " ");
        System.out.print(dataServerDto.getC() + " ");
        System.out.print(dataServerDto.getNr() + "\n");
        return new DataServerDto();
        //    List<Sensor> sensors = sensorService.getAllSensors();
        //    return new SensorsDto(sensorConverter.convertModelsToDtos(sensors));
    }
}
