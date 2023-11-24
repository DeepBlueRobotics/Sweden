// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Command;
import frc.robot.Subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class Autonomous extends CommandBase {
  public double currenttime;
  public Timer time = new Timer();
  public Drivetrain Drive;
  /** Creates a new Autonomous. */
  public Autonomous(Drivetrain Drive) {
    this.Drive = Drive;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time.start();
    currenttime = Timer.getFPGATimestamp();
    //auto is 15 secs
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(currenttime > 15){
      Drive.leftMotor.set(1);
      Drive.rightMotor.set(1);
    }
    else if(currenttime == 15){
      Drive.leftMotor.set(0);
      Drive.rightMotor.set(0); 
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
