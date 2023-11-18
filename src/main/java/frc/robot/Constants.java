// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController.Button;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
        public static final int LEFT_MOTOR_PORT = 0;
        public static final int RIGHT_MOTOR_PORT = 3;
        
        //TODO: change speed when and when not intaking to be accurate values
        public static final double SPEED_WHEN_NOT_INTAKING = 0.45;
        public static final double SPEED_WHEN_INTAKING = 0.3;
        public static final int XBOX_CONTROLLER_PORT = 2;

        public static final int INTAKE_RIGHT_MOTOR_PORT = 19;
        public static final int INTAKE_LEFT_MOTOR_PORT = 9;
        public static final int OUTAKE_RIGHT_MOTOR_PORT = 1;
        public static final int OUTAKE_LEFT_MOTOR_PORT = 20;

        public static final int INTAKE_BUTTON = Button.kRightBumper.value;
        public static final int OUTAKE_BUTTON = Button.kLeftBumper.value;

    public final class Drivetrain {
        public static final double halfDriveSpeedMultiplier = 0.15;
        public static final double halfTurnSpeedMultiplier = 0.3;
    }
}
