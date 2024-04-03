// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class OperatorConstants {
        public static final int kDriverControllerPort = 0;

    }

  // Controller ports
  public static final int XBOX_PORT = 0;
  
  //Belt
  public static final double BELT_MOTOR_SPEED = 1.5;
  public static final int leftBelt = 50; //FIND THE ACTUAL VALUE
  public static final int rightBelt = 60;

  // Drivetrain stuff
  public static final int RightLeader = 6;
  public static final int RightFollower = 2;
  public static final int LeftLeader = 4;
  public static final int LeftFollower = 3;
  public static final int TopIntakeMotor = 1;
  public static final int BottomIntakeMotor = 1;
  public static final int SHOOTER_MOTOR_PORT = 7;

  public static final double MOVE_SPEED = 0.5;
  public static final double ROTATION_SPEED = 0.5;
  public static final double IntakeSpeed = 0.5;


    // Shooter angle
    public static final int SHOOTER_ANGLE_PORT = 25; // find the actual id

    // Shooter

    // Drive for time
    public static final double AUTO_MOVE_SPEED = 0.5;

    // Turn for angle
    public static final double KP_TURN_ANGLE = 0.01;
    public static final double KI_TURN_ANGLE = 0.0;
    public static final double KD_TURN_ANGLE = 0.0;

    public static final int BOTTOM_INTAKE_PORT = 999; // find out actual

    public static final int TOP_INTAKE_PORT = 999; // find out actual

    public static final int JOYSTICK_PORT = 1;

    public static final int NOTE_DISTANCE = 5; // not sure what the units are, but need to find the distance of the note
}
