// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// Imports subsystems and commands

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.autos.*;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // Drivetrain motors
  public static WPI_VictorSPX rightLeader = new WPI_VictorSPX(Constants.RightLeader);
  public static WPI_VictorSPX rightFollower = new WPI_VictorSPX(Constants.RightFollower);
  public static WPI_VictorSPX leftLeader = new WPI_VictorSPX(Constants.LeftLeader);
  public static WPI_VictorSPX leftFollower = new WPI_VictorSPX(Constants.LeftFollower);
  public static WPI_VictorSPX shooterMotor = new WPI_VictorSPX(Constants.SHOOTER_MOTOR_PORT);
  public static ADIS16470_IMU imu = new ADIS16470_IMU();

  public static Drivetrain drivetrain = new Drivetrain(rightLeader, rightFollower, leftLeader, leftFollower, imu);
  public static Move move = new Move(drivetrain);


  //public static ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  public static XboxController xController = new XboxController(Constants.XBOX_PORT);
  public static Joystick driverDashboard = new Joystick(Constants.JOYSTICK_PORT);

  //public static ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public static CANSparkMax shooterAngleMotor = new CANSparkMax(Constants.SHOOTER_ANGLE_PORT, CANSparkLowLevel.MotorType.kBrushless);
  public static ShooterAngle shooterAngle = new ShooterAngle(shooterAngleMotor);

  public static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  public static NetworkTableEntry tx = table.getEntry("tx");
  public static NetworkTableEntry ty = table.getEntry("ty");
  public static NetworkTableEntry ta = table.getEntry("ta");
  public static Vision vision = new Vision(table);

  public static TiltTowardsTarget tilt = new TiltTowardsTarget(vision, drivetrain);

  public static TestAuto auto = new TestAuto();
  
  
  public static WPI_VictorSPX leftBelt = new WPI_VictorSPX(Constants.leftBelt);
  public static WPI_VictorSPX rightBelt = new WPI_VictorSPX(Constants.rightBelt);
  public static Belt belt = new Belt(leftBelt, rightBelt);






  /// network table

  Test t = new Test(shooterAngleMotor);

    public static I2C.Port i2cPort = I2C.Port.kOnboard;
    public static ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
    public static ColorSensor colorSensorSubsystem = new ColorSensor(colorSensor);






  
  public static WPI_TalonSRX topIntake = new WPI_TalonSRX(Constants.TOP_INTAKE_PORT);
  public static WPI_TalonSRX bottomIntake = new WPI_TalonSRX(Constants.BOTTOM_INTAKE_PORT);
  public static Intake intake = new Intake();

  public static Shooter shooter = new Shooter(shooterMotor);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    CommandScheduler.getInstance().setDefaultCommand(drivetrain, move);

  }



  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // A to start intake, B to stop intake
    new JoystickButton(xController, 1).onTrue(intake.runIntake());
    new JoystickButton(xController, 2).onTrue(intake.stopIntake());
    new JoystickButton(xController, 3).onTrue(shooter.shootCommand());
    new JoystickButton(xController, 4).onTrue(tilt);
    new JoystickButton(xController, 5).onTrue(t.doHi());
    new JoystickButton(xController, 3).whileTrue(belt.moveUp());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public TestAuto getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return auto;
  }
}
