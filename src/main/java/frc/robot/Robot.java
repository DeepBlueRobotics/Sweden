// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


//import com.revrobotics.CANSparkMax;
import frc.robot.Subsystems.Drivetrain;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

//import edu.wpi.first.wpilibj.XboxController;


public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

 
  private RobotContainer m_robotContainer;
  private Drivetrain dt = new Drivetrain();

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer(dt);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  //Joystick leftJoystick = new Joystick(0);
  //Joystick rightJoystick = new Joystick(1);

  @Override
  public void teleopPeriodic() {
    double leftJoystickPosition = -m_robotContainer.controller.getLeftY();
    double rightJoystickPosition = m_robotContainer.controller.getRightY();
    //double leftJoystickPosition = leftJoystick.getY(); // 1
    //double rightJoystickPosition = rightJoystick.getY(); // 0
    dt.drive(leftJoystickPosition, rightJoystickPosition);
  }

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}
}
