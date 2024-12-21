package server.service;

import server.model.SensorData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorDataService {
    private final List<SensorData> sensorDataList = new ArrayList<>();

    public void addSensorData(SensorData data) {
        sensorDataList.add(data);
    }

    public List<SensorData> getAllSensorData() {
        return sensorDataList;
    }
}
