package frc.robot.nav;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Robot;


//!!!!!!!!!!!!!!!!DO NOT TRY TO TURN 180 DEGREES!!!!!!!!!!!!!!!!!!!!!!

public class RotateCommand extends CommandBase {

  private double startingAngle;
  private double currentAngle;
  private double targetAngle;
  private double deltaAngle;

  private static final double DEFAULT_PERCENT_OUTPUT = 0.3;
  private static final double MIN_PERCENT_OUTPUT = 0.10;
  private static final double ANGLE_kP = 1.30;
  private static final double TOLERANCE = 1.5; // degrees

  public RotateCommand(double angle) {
    addRequirements(Robot.driveSys);
    targetAngle = angle;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      // Navx.getInstance().updateTotalAngle();
      Navx.getInstance().reset();
      Navx.getInstance().reset();
      startingAngle = Navx.getInstance().getYaw();
      currentAngle = Navx.getInstance().getYaw();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      currentAngle = Navx.getInstance().getYaw();
      if(targetAngle >= 175 && currentAngle < 0) {
        currentAngle = 360 + Navx.getInstance().getYaw();
      } else if (targetAngle <= -175 && currentAngle > 0){
        currentAngle = Navx.getInstance().getYaw() - 360;
      }
      deltaAngle = (targetAngle - currentAngle);
      double power = DEFAULT_PERCENT_OUTPUT;
      power = Math.min(Math.abs(power), (Math.abs(deltaAngle) / (targetAngle - startingAngle) * power * ANGLE_kP)) * Math.signum(deltaAngle);
      power = Math.max(Math.abs(power), Math.abs(MIN_PERCENT_OUTPUT)) * Math.signum(power);

      
      Robot.driveSys.setMecanumDriveSpeed(0, 0, -power * Math.signum(deltaAngle));
      
      System.out.println(deltaAngle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
      Robot.driveSys.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Math.abs(deltaAngle) <= TOLERANCE);                
  }
}