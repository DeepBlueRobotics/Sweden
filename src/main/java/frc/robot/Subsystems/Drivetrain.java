// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;
//import frc.robot.RobotContainer;
import org.carlmontrobotics.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  
  private CANSparkMax leftMotor = MotorControllerFactory.createSparkMax(Constants.LEFT_MOTOR_PORT, MotorConfig.NEO);
  private CANSparkMax rightMotor = MotorControllerFactory.createSparkMax(Constants.RIGHT_MOTOR_PORT, MotorConfig.NEO);
  private XboxController controller;
  public boolean slowmodeon = false;

  public Drivetrain(XboxController controller) {
    this.controller = controller;
  } 

  @Override
  public void periodic() {
    //SmartDashborad.(get/put)Number(key: "",);
    // This method will be called once per scheduler run
    if (slowmodeon) slowmode();
    else drive();
  }

  public void drive(){ 
    leftMotor.set(controller.getLeftY());
    rightMotor.set(controller.getRightY());
    //double leftJoystickPosition = -controller.getLeftY();
    //double rightJoystickPosition = controller.getRightY();
   //dt.drive(leftJoystickPosition, rightJoystickPosition);
  }

  public void slowmode() {
  double right = -controller.getRightY() * Constants.halfDriveSpeedMultiplier;
  double left = controller.getLeftY() * Constants.halfTurnSpeedMultiplier;
  leftMotor.set(-left);
  rightMotor.set(right);
}
}
