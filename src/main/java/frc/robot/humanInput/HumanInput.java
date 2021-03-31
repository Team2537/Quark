package frc.robot.humanInput;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class HumanInput {

    public static XboxController xbox;

    public HumanInput() {

        xbox = new XboxController(0);
    }

    public static double getLeftXBox() {
        return xbox.getY(Hand.kLeft);
    }

    public static double getRightXBox() {
        return xbox.getY(Hand.kRight);
    }
    
}
