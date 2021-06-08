package frc.robot.camera;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.cscore.UsbCamera;


// import edu.wpi.cscore.VideoSource.ConnectionStrategy;


public class Camera extends Thread {
    CameraServer camServer;
    UsbCamera cam0;
    static Camera instance;

    private Camera() {
        // Camera server manages all cameras and streams
        camServer = CameraServer.getInstance();
        // Start serving front camera (USB port 0)
        cam0 = camServer.startAutomaticCapture("cameras", 0);

    }

    public static Camera getInstance() {
       if (instance == null) {
           instance = new Camera();
           instance.start();        
       }
       return instance;
    }


    public void startCameras() {
            camServer.getServer().setSource(cam0);
    }

       
        



    // Run method is invoked when start method is called
    public void run() {
        while (true) {
            // run forever
        }
    }
}
