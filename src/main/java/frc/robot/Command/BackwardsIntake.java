// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.Command;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Subsystems.IntakeOutake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class BackwardsIntake extends CommandBase {
  public double currenttime;
  public Timer time = new Timer();
  public IntakeOutake inout;

  //public void timer(){
  //}

  public BackwardsIntake(IntakeOutake inout) {
    this.inout = inout;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time.reset();
    time.start();
    currenttime = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //double timenow;
    //timenow = Timer.getFPGATimestamp();
    //double currenttime = timenow-starttime;
      inout.intakeleftMotor.set(inout.intakeBackwardLeft);
      inout.intakerightMotor.set(inout.intakeBackwardRight);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(currenttime >= 0.2){
      inout.intakeleftMotor.set(0);
      inout.intakerightMotor.set(0);
      return true;
    }
    return false;
  }
}
