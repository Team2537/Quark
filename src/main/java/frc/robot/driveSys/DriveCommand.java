package frc.robot.driveSys;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;


public class DriveCommand extends CommandBase {
    
    public DriveCommand() {
        addRequirements(Robot.driveSys);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        Robot.driveSys.setMecanumDriveSpeed();
        Robot.driveSys.displayEncoderValues();
    }

    @Override
    public void end(final boolean interrupted) {
        Robot.driveSys.stopMotors();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
