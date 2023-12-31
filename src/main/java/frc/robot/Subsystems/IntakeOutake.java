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
//import edu.wpi.first.wpilibj.Timer;

public class IntakeOutake extends SubsystemBase {
  public CANSparkMax intakerightMotor = MotorControllerFactory.createSparkMax(Constants.INTAKE_RIGHT_MOTOR_PORT, MotorConfig.NEO);
  public CANSparkMax intakeleftMotor = MotorControllerFactory.createSparkMax(Constants.INTAKE_LEFT_MOTOR_PORT, MotorConfig.NEO);
  public CANSparkMax outakerightMotor = MotorControllerFactory.createSparkMax(Constants.OUTAKE_RIGHT_MOTOR_PORT, MotorConfig.NEO_550);
  public CANSparkMax outakeleftMotor = MotorControllerFactory.createSparkMax(Constants.OUTAKE_LEFT_MOTOR_PORT, MotorConfig.NEO_550);
  
  public double intakeBackwardLeft = Constants.INTAKE_BACKWARD_LEFT;
  public double intakeBackwardRight = Constants.INTAKE_BACKWARD_RIGHT;

  private double intakeDirectionLeft = 1;
  private double intakeDirectionRight = -1;
  //move to constants
  double timenow;
   double starttime;


  /* Creates a new shooter. */
  public IntakeOutake() {
    intakerightMotor.setInverted(false);
    outakerightMotor.setInverted(true);  
    outakeleftMotor.setInverted(true);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("IntakeDirLeft",intakeDirectionLeft);
    SmartDashboard.putNumber("IntakeDirRight",intakeDirectionRight);
    SmartDashboard.putNumber("OutakeDirLeft", -intakeDirectionLeft);
    SmartDashboard.putNumber("OutakeDirRight", -intakeDirectionRight);
    //for the simulator, not necessary for robot function persay
  }

// check if motors spin right way, if not invert it with the above method (setInverted)
  public void intake() {
    intakeleftMotor.set(intakeDirectionLeft);
    intakerightMotor.set(intakeDirectionRight);
  }

  public void stopIntakeMotors() {
    intakeleftMotor.set(0);
    intakerightMotor.set(0);
  }

  public void outake() {
    outakeleftMotor.set(-intakeDirectionLeft);
    outakerightMotor.set(-intakeDirectionRight);
  }

  public void stopOutakeMotors() {
    outakeleftMotor.set(0);
    outakerightMotor.set(0);
  }

  /*/public void backwardmode() {
    starttime = Timer.getFPGATimestamp();
    timenow = Timer.getFPGATimestamp();
    /
    time.reset();
    if(time > 0.2){
      intakeleftMotor.set(intakeBackwardLeft);
      intakerightMotor.set(intakeBackwardRight);
    }
    else if(time == 0.2){
      intakeleftMotor.set(0);
      intakerightMotor.set(0);
  }
  }/*/
}