// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import org.carlmontrobotics.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  CANSparkMax leftMotor = MotorControllerFactory.createSparkMax(0, MotorConfig.NEO);
  CANSparkMax rightMotor = MotorControllerFactory.createSparkMax(1, MotorConfig.NEO);

  public Drivetrain() {
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setVoltage(double outputVolts){
    leftMotor.set(0.5);
   // leftMotor2.set(0.5);
    rightMotor.set(0.5);  
    //rightMotor2.set(0.5);
  }

  public void drive(double leftJoystickPosition, double rightJoystickPosition){ 
    leftMotor.set(leftJoystickPosition);
    rightMotor.set(rightJoystickPosition);
  }


public void slowmode(XboxController controller) {
  double right = -controller.getRightY() * Constants.halfDriveSpeedMultiplier;
  double left = controller.getLeftY() * Constants.halfTurnSpeedMultiplier;
  leftMotor.set(-left);
  rightMotor.set(right);
}
}
