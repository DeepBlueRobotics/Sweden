// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import org.carlmontrobotics.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;

import com.revrobotics.CANSparkMax;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  CANSparkMax leftMotor1 = MotorControllerFactory.createSparkMax(0, MotorConfig.NEO);
  //CANSparkMax leftMotor2 = MotorControllerFactory.createSparkMax(1, MotorConfig.NEO);
  CANSparkMax rightMotor1 = MotorControllerFactory.createSparkMax(1, MotorConfig.NEO);
 // CANSparkMax rightMotor2 = MotorControllerFactory.createSparkMax(3, MotorConfig.NEO);


       // Joystick leftJoystick = new Joystick(0);
       // Joystick rightJoystick = new Joystick(1);
  //please work please

  public Drivetrain() {
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //double leftJoystickPosition = leftJoystick.getY(); // 1
    //double rightJoystickPosition = rightJoystick.getY(); // 0
   // this.drive(leftJoystickPosition, rightJoystickPosition); 
    // this.drive(1, 0)
  }

  public void setVoltage(double outputVolts){
    leftMotor1.set(0.5);
   // leftMotor2.set(0.5);
    rightMotor1.set(0.5);  
    //rightMotor2.set(0.5);
  }

  public void drive(double leftJoystickPosition, double rightJoystickPosition){ 
    leftMotor1.set(leftJoystickPosition);
   // leftMotor2.set(leftJoystickPosition);
    rightMotor1.set(rightJoystickPosition);
   // rightMotor2.set(rightJoystickPosition); 
  }
}
  
