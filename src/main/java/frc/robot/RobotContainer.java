// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.Subsystems.IntakeOutake;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Autonomous;
//import edu.wpi.first.wpilibj.GenericHID; 

public class RobotContainer {
  private IntakeOutake in = new IntakeOutake();
  // in.IntakeOutake(intakeDirectionLeft, intakeDirectionRight);
  private XboxController controller = new XboxController(Constants.XBOX_CONTROLLER_PORT);
  private Drivetrain dt = new Drivetrain(controller);
  private Autonomous autonomous;
  // always initialize subsystems here

  public RobotContainer() {

    configureBindings();
  }

  private void configureBindings() {

    new JoystickButton(controller, Constants.INTAKE_BUTTON).onTrue(new InstantCommand(
        () -> {
          in.intake();
        })).onFalse(new InstantCommand(
            () -> {
              in.stopIntakeMotors();
            }));

    // if you let go of the button it will stop intaking or outaking

    new JoystickButton(controller, Constants.OUTAKE_BUTTON).onTrue(new InstantCommand(
        () -> {
          in.outake();
        })).onFalse(new InstantCommand(
            () -> {
              in.stopOutakeMotors();
            }));

    new JoystickButton(controller, Button.kB.value).onTrue(new InstantCommand(
        () -> {
          dt.slowmodeon = true;
          // turns on slowmode
        }));

    new JoystickButton(controller, Button.kA.value).onTrue(new InstantCommand(
        () -> {
          dt.slowmodeon = false;
          // this button changes mode back to regular driving
        }));
  }

  public Command getAutonomousCommand() {
    return new Autonomous(dt);
  }
}
