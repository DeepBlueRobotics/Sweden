package frc.robot;


import org.carlmontrobotics.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;

import com.revrobotics.CANSparkMax;

//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;

public class Arcade extends TimedRobot {
    // CANSparkMax name = MotorControllerFactory.createSparkMax(motor port, MotorConfig.NEO/NEO_550);
    XboxController controller = new XboxController(0);
    CANSparkMax leftMotor1 = MotorControllerFactory.createSparkMax(0, MotorConfig.NEO);
    //CANSparkMax leftMotor2 = MotorControllerFactory.createSparkMax(1, MotorConfig.NEO);
    CANSparkMax rightMotor1 = MotorControllerFactory.createSparkMax(1, MotorConfig.NEO);
    
    private double startTime;

    @Override
    public void robotInit() {

    }

    @Override
    public void autonomousInit() {
        startTime = Timer.getFPGATimestamp();
    }
    
    @Override
    public void autonomousPeriodic() {
        // gets the time (in seconds)
        double time = Timer.getFPGATimestamp();

        if (time - startTime < 3) {
            leftMotor1.set(0.6);
            rightMotor1.set(-0.6);
        } else {
            leftMotor1.set(0);
            rightMotor1.set(0);
        }
    }

    @Override
    public void teleopInit() {

    }

    @Override
    public void teleopPeriodic() {
        // for this axis, up is negative, down is positive
        // slow speed down to 60% and turning to 30% for better controllability
        double speed = controller.getLeftY() * 0.6;
        double turn = controller.getRightY() * 0.3;

        // calculate power output
        double left = speed + turn;
        double right = speed - turn;

        // set motor speed
        leftMotor1.set(left);
        rightMotor1.set(-right);
    }

    @Override
    public void testInit() {

    }

    @Override
    public void testPeriodic() {

    }
}
