package frc.robot.driveSys;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class DriveSubsystem extends SubsystemBase {
    
    private static WPI_TalonSRX backLeftTalon, frontLeftTalon, backRightTalon, frontRightTalon;
    private static ControlMode controlMode;
    private static FeedbackDevice feedbackDevice;
    private static MecanumDrive driveMecanum;

    public DriveSubsystem() {

        backLeftTalon = new WPI_TalonSRX(0);
        frontLeftTalon = new WPI_TalonSRX(1);
        backRightTalon = new WPI_TalonSRX(2);
        frontRightTalon = new WPI_TalonSRX(3);

        controlMode = ControlMode.PercentOutput;
        feedbackDevice = FeedbackDevice.QuadEncoder;

        backLeftTalon.configSelectedFeedbackSensor(feedbackDevice, 0, 0);
        frontLeftTalon.configSelectedFeedbackSensor(feedbackDevice, 0, 0);
        backRightTalon.configSelectedFeedbackSensor(feedbackDevice, 0, 0);
        frontRightTalon.configSelectedFeedbackSensor(feedbackDevice, 0, 0);

        driveMecanum = new MecanumDrive(frontLeftTalon, backLeftTalon, frontRightTalon, backRightTalon);
    }

    public void setMecanumDriveSpeed(double verticalSpeed, double horizontalSpeed, double zRotation) {
        driveMecanum.driveCartesian(verticalSpeed, horizontalSpeed, zRotation);
    }

    public void setPolarDriveSpeed(double magnitude, double angle, double zRotation) {
        driveMecanum.drivePolar(magnitude, angle, zRotation);
    }

    public void setMecanumDriveSpeed() {
        setMecanumDriveSpeed(0, 0, 0);
    }

    public void stopMotors() {
        backLeftTalon.set(controlMode, 0);
        frontLeftTalon.set(controlMode, 0);
        backRightTalon.set(controlMode, 0);
        frontRightTalon.set(controlMode, 0);
    }

    public void resetEncoders() {
        frontLeftTalon.setSelectedSensorPosition(0);
        backLeftTalon.setSelectedSensorPosition(0);
        frontRightTalon.setSelectedSensorPosition(0);
        backRightTalon.setSelectedSensorPosition(0);
    }

    public double getBackLeftEncoder() {
        return backLeftTalon.getSelectedSensorPosition();
    }

    public double getFrontLeftEncoder() {
        return frontLeftTalon.getSelectedSensorPosition();
    }

    public double getBackRightEncoder() {
        return backRightTalon.getSelectedSensorPosition();
    }

    public double getFrontRightEncoder() {
        return frontRightTalon.getSelectedSensorPosition();
    }

    public void displayEncoderValues() {
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