package frc.robot.driveSys;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    
    private static TalonSRX backLeftTalon, frontLeftTalon, backRightTalon, frontRightTalon;
    private static ControlMode controlMode;
    private static FeedbackDevice feedbackDevice;

    public DriveSubsystem() {

        backLeftTalon = new TalonSRX(0);
        frontLeftTalon = new TalonSRX(1);
        backRightTalon = new TalonSRX(2);
        frontRightTalon = new TalonSRX(3);

        controlMode = ControlMode.PercentOutput;
        feedbackDevice = FeedbackDevice.QuadEncoder;

        backLeftTalon.configSelectedFeedbackSensor(feedbackDevice, 0, 0);
        frontLeftTalon.configSelectedFeedbackSensor(feedbackDevice, 0, 0);
        backRightTalon.configSelectedFeedbackSensor(feedbackDevice, 0, 0);
        frontRightTalon.configSelectedFeedbackSensor(feedbackDevice, 0, 0);

    }

    public void setLeftTalons(double speed) {
        backLeftTalon.set(controlMode, speed);
        frontLeftTalon.set(controlMode, speed);
    }

    public void setRightTalons(double speed) {
        backRightTalon.set(controlMode, speed);
        frontRightTalon.set(controlMode, speed);
    }

    public void setTalons(double speed) {
        setLeftTalons(speed);
        setRightTalons(speed);
    }

    public static double getBackLeftEncoder() {
        return backLeftTalon.getSelectedSensorPosition();
    }

    public static double getFrontLeftEncoder() {
        return frontLeftTalon.getSelectedSensorPosition();
    }

    public static double getBackRightEncoder() {
        return backRightTalon.getSelectedSensorPosition();
    }

    public static double getFrontRightEncoder() {
        return frontRightTalon.getSelectedSensorPosition();
    }

    public static void displayEncoderValues() {
        System.out.println("Back Left Encoder Value: " + getBackLeftEncoder());
        System.out.println("Front Left Encoder Value: " + getFrontLeftEncoder());
        System.out.println("Back Right Encoder Value: " + getBackRightEncoder());
        System.out.println("Front Right Encoder Value: " + getFrontRightEncoder());
    }
    
    //get encoder distances


    @Override
    public void periodic() {
        setDefaultCommand(new DriveCommand());
    }

}