package sensordatavirtualisation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mikemarshall
 */

/* This class holds the sensor data read from the file
 * It does not include the sensor data for recordings that have errors
 *  - errors are logged separately
 */

public class SensorData {

    public int timeOfRecording;
    public int deviceType;
    public int deviceSoftwareVersion;
    public int receiver;
    public int transmitterAddress;
    public int sensorData[];
 
    public SensorData(int theTime, int theType, int theVersion, int theVia, int theAddress, int theSensorData[])
    {
        timeOfRecording = theTime;
        deviceType = theType;
        deviceSoftwareVersion = theVersion;
        receiver = theVia;
        transmitterAddress = theAddress;
        System.arraycopy(theSensorData, 0, sensorData, 0, 10);
    }
}
