package server.controller;

import server.model.SensorData;
import server.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DataController {

    @Autowired
    private SensorDataService service;

    @PostMapping("/data")
    @ResponseBody
    public String receiveData(@RequestBody SensorData data) {
        service.addSensorData(data);
        return "Data received successfully!";
    }

    @GetMapping("/dashboard")
    public String viewDashboard(org.springframework.ui.Model model) {
        List<SensorData> sensorDataList = service.getAllSensorData();
        model.addAttribute("sensorDataList", sensorDataList);
        return "dashboard";
    }
}
