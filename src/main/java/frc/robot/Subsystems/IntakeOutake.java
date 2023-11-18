// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems ;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//import edu.wpi.first.wpilibj.XboxController;
import org.carlmontrobotics.lib199.MotorControllerFactory;
import com.revrobotics.CANSparkMax;
//import frc.robot.Constants;
import org.carlmontrobotics.MotorConfig;

public class IntakeOutake extends SubsystemBase {
  private CANSparkMax intakerightMotor = MotorControllerFactory.createSparkMax(Constants.INTAKE_RIGHT_MOTOR_PORT, MotorConfig.NEO);
  private CANSparkMax intakeleftMotor = MotorControllerFactory.createSparkMax(Constants.INTAKE_LEFT_MOTOR_PORT, MotorConfig.NEO);
  private CANSparkMax outakerightMotor = MotorControllerFactory.createSparkMax(Constants.OUTAKE_RIGHT_MOTOR_PORT, MotorConfig.NEO_550);
  private CANSparkMax outakeleftMotor = MotorControllerFactory.createSparkMax(Constants.OUTAKE_LEFT_MOTOR_PORT, MotorConfig.NEO_550);

  double intakeDirectionLeft = 1;
  double intakeDirectionRight = -1;
 



  /* Creates a new shooter. */
  public IntakeOutake() {
    intakerightMotor.setInverted(true);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("IntakeDirLeft",intakeDirectionLeft);
    SmartDashboard.putNumber("IntakeDirRight",intakeDirectionRight);
    SmartDashboard.putNumber("OutakeDirLeft", -intakeDirectionLeft);
    SmartDashboard.putNumber("OutakeDirRight", -intakeDirectionRight);
  }

// check if motors spin right way, if not invert it with the above method (setInverted)
  public void intake(double SPEED_WHEN_NOT_INTAKING) {
    intakeleftMotor.set(intakeDirectionLeft);
    intakerightMotor.set(intakeDirectionRight);
    double intakeLeftOutput = intakeleftMotor.get();
    double intakeRightOutput = intakerightMotor.get();

    if (intakeLeftOutput <= Constants.SPEED_WHEN_NOT_INTAKING && intakeRightOutput >= Constants.SPEED_WHEN_NOT_INTAKING){
      stopIntakeMotors();
    }
  }

  public void stopIntakeMotors() {
    intakeleftMotor.set(0);
    intakerightMotor.set(0);
  }

  public void outake(double SPEED_WHEN_INTAKING) {
    outakeleftMotor.set(-intakeDirectionLeft);
    outakerightMotor.set(-intakeDirectionRight);
    double outakeLeftOutput = outakeleftMotor.get();
    double outakeRightOutput = outakerightMotor.get();

    if(outakeLeftOutput >= Constants.SPEED_WHEN_INTAKING && outakeRightOutput >= Constants.SPEED_WHEN_INTAKING)
     stopOutakeMotors();
  }

  public void stopOutakeMotors() {
    outakeleftMotor.set(0);
    outakerightMotor.set(0);
  }

  }