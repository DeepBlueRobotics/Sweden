// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.Subsystems.IntakeOutake;
import frc.robot.Command.Autonomous;
import frc.robot.Command.BackwardsIntake;
//import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.GenericHID; 


public class RobotContainer {
  private IntakeOutake in = new IntakeOutake();
 // private BackwardsIntake Back = new BackwardsIntake(in);
 // in.IntakeOutake(intakeDirectionLeft, intakeDirectionRight);
  private XboxController controller = new XboxController(Constants.XBOX_CONTROLLER_PORT);
  private XboxController controller2 = new XboxController(Constants.XBOX_CONTROLLER_PORT2);  
  private Drivetrain dt = new Drivetrain(controller);
  boolean backward;
//always initialize subsystems here


  public RobotContainer() {
    
    configureBindings();  
  }
  // when this button is pressed a certain line of code will be called
  private void configureBindings(){

    new JoystickButton(controller2, Constants.INTAKE_BUTTON).onTrue(new InstantCommand(
      () -> {
        in.intake();
      }  
      )).onFalse(new InstantCommand(
      () -> {
        in.stopIntakeMotors();
      }
      ));

        //if you let go of the button it will stop intaking or outaking

    new JoystickButton(controller2, Constants.OUTAKE_BUTTON).onTrue(new InstantCommand(
      () -> {
        in.outake();
      }
      )).onFalse(new InstantCommand(
      () -> {
        in.stopOutakeMotors();
      }  
      ));

      new JoystickButton(controller2, Constants.BACKWARDS_BUTTON).onTrue(new BackwardsIntake(in));

    //make a button that turns intake motors backwards for a few seconds really slowly (button X)
    //5% power for 0.2 seconds
    //Make a method in intakeoutake file (look at slowmode in drivetrain file to reference) and call it in the lambda here
    //figure out how to make it a timer
      
    new JoystickButton(controller, Constants.SLOWMODE).onTrue(new InstantCommand(
      () -> {
        dt.slowmodeon = true;
        //turns on slowmode
      }
      ));

    new JoystickButton(controller, Constants.REGULAR_DRIVE).onTrue(new InstantCommand(
      () -> {
        dt.slowmodeon = false;
        //this button changes mode back to regular driving
      }
      ));
    }
  


  public Command getAutonomousCommand() {
    return new Autonomous(dt);
  }
}
