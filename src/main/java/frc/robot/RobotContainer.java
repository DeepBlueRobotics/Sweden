// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.Subsystems.IntakeOutake;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.GenericHID; 


public class RobotContainer {
  Drivetrain dt;
  IntakeOutake in = new IntakeOutake();
  XboxController controller = new XboxController(0);

  public RobotContainer(Drivetrain drivetrain) {
    dt = drivetrain;
    
    configureBindings(controller);  
  }

  private void configureBindings(XboxController controller){

    new JoystickButton(controller, Button.kRightBumper.value).onTrue(new InstantCommand(
      () -> {
        in.intake();
      }
      ));
    new JoystickButton(controller, Button.kRightBumper.value).onFalse(new InstantCommand(
      () -> {
        in.stopIntakeMotors();
      }
      ));
    new JoystickButton(controller, Button.kLeftBumper.value).onTrue(new InstantCommand(
      () -> {
        in.outake();
      }
      ));
    new JoystickButton(controller, Button.kLeftBumper.value).onFalse(new InstantCommand(
      () -> {
        in.stopOutakeMotors();
      }
      ));
    new JoystickButton(controller, Button.kB.value).onTrue(new InstantCommand(
      () -> {
        dt.slowmode(controller);
      }
      ));
    new JoystickButton(controller, Button.kA.value).onTrue(new InstantCommand(
      () -> {
        dt.drive(0, 0);
      }
      ));
  }


  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
