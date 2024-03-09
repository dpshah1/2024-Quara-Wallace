// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Drivetrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

    private WPI_VictorSPX m_rightLeader; 
    private WPI_VictorSPX m_rightFollower; 
    private WPI_VictorSPX m_leftLeader; 
    private WPI_VictorSPX m_leftFollower;
    private DifferentialDrive m_drive;


  public Drivetrain(WPI_VictorSPX rightLeader, WPI_VictorSPX rightFollower, WPI_VictorSPX leftLeader, WPI_VictorSPX leftFollower) {
    // Initialize the motors
    m_rightLeader = rightLeader;
    m_rightFollower = rightFollower;
    m_leftLeader = leftLeader;
    m_leftFollower = leftFollower;
    
    // Invert the left leader
    m_leftLeader.setInverted(true);

    // Set the Differential Drive Class
    m_drive = new DifferentialDrive(m_leftLeader, m_rightLeader);

    // Set the starting speed to 0
    m_drive.arcadeDrive(0, 0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    followMotor();

  }

  // Allows the followers to follow the leader motors since MotorGroup is depracted. 
  private void followMotor() {
    m_leftFollower.set(m_leftLeader.get());
    m_rightFollower.set(m_rightLeader.get());

  }


  public void setMovement(double moveSpeed, double rotSpeed) {
    m_drive.arcadeDrive(moveSpeed, rotSpeed);
  }

  public void stopMovement() {
    m_drive.arcadeDrive(0, 0);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
