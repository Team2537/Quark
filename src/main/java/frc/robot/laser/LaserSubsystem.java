package frc.robot.laser;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LaserSubsystem extends SubsystemBase {
    private DigitalOutput laser = new DigitalOutput(0);
    LaserSubsystem(){}

    public void laserOn() {
        laser.set(true);
    }
    public void laserOff() {
        laser.set(false);
    }
}
