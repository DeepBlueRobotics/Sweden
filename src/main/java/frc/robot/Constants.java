// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
        public static final int LEFT_MOTOR_PORT = 15;
        public static final int RIGHT_MOTOR_PORT = 13;
        
        //change speed when and when not intaking to be accurate values
        public static final double SPEED_WHEN_NOT_INTAKING = 0.45;
        public static final double SPEED_WHEN_INTAKING = 0.3;
        public static final int XBOX_CONTROLLER_PORT = 1;
        public static final int XBOX_CONTROLLER_PORT2 = 2;

        //public static final JoystickButton x1 = new JoystickButton(null, XBOX_CONTROLLER_PORT);
        //public static final JoystickButton x2 = new JoystickButton(null, XBOX_CONTROLLER_PORT2);

        public static final int INTAKE_RIGHT_MOTOR_PORT = 16;
        public static final int INTAKE_LEFT_MOTOR_PORT = 3;
        public static final int OUTAKE_RIGHT_MOTOR_PORT = 5;        
        public static final int OUTAKE_LEFT_MOTOR_PORT = 11;

        public static final double INTAKE_BACKWARD_LEFT = -0.05;
        public static final double INTAKE_BACKWARD_RIGHT = 0.05;

        //JoystickButton INTAKE_BUTTON = new JoystickButton(driver, Constants.OI.kButtonANum);
        /*/ public static final class Driver{
            public static int port = 1;
            public static final int REGULAR_DRIVE = Button.kA.value;
            public static final int SLOWMODE = Button.kB.value;

        }
        public static final class Manipulator{
            public static int port = 2;
            public static final int BACKWARDS_BUTTON = Button.kX.value;
            public static final int INTAKE_BUTTON = Button.kRightBumper.value;
            public static final int OUTAKE_BUTTON = Button.kLeftBumper.value;
        }/*/ 
        //public static final int INTAKE_BUTTON = x2.kRightBumper.value;
        //public static final int OUTAKE_BUTTON = x2.kLeftBumper.value;
        //public static final int SLOWMODE = x1.kB.value;
        //public static final int REGULAR_DRIVE = x1.kA.value;
        //public static final int BACKWARDS_BUTTON = x2.kX.value;

        public static final int INTAKE_BUTTON = Button.kRightBumper.value;
        public static final int OUTAKE_BUTTON = Button.kLeftBumper.value;
        //change to right trigger not right bumper and etc.
        public static final int SLOWMODE = Button.kB.value;
        public static final int REGULAR_DRIVE = Button.kA.value;
        public static final int BACKWARDS_BUTTON = Button.kX.value;
        //backwards is supposed to be automated???????!!!!!


    //public static final double backbuttonDriveSpeedMultiplier = 0.05;


    public final class Drivetrain {
        public static final double halfDriveSpeedMultiplier = 0.15;
        public static final double halfTurnSpeedMultiplier = 0.3;
    }
}
