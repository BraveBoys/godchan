package test;

import java.util.HashMap;

public class SensorMap {
   HashMap<String, SensorData> sensormap;
   
   public SensorMap() {
      this.sensormap = new HashMap<String, SensorData>();
      sensormap.put("flame1", new SensorData(20, 20));
      sensormap.put("flame3", new SensorData(21,21));
   }

   public HashMap<String, SensorData> getSensormap() {
      return sensormap;
   }
   
   
}