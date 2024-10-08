// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.Move;
import edu.wpi.first.wpilibj.ADIS16470_IMU;


public class Drivetrain extends SubsystemBase {
    /**
     * Creates a new ExampleSubsystem.
     */
    private ADIS16470_IMU m_imu;
    private WPI_VictorSPX m_rightLeader;
    private WPI_VictorSPX m_rightFollower;
    private WPI_VictorSPX m_leftLeader;
    private WPI_VictorSPX m_leftFollower;
    private DifferentialDrive m_drive;

    private boolean isShootingMode = true;


    public Drivetrain(WPI_VictorSPX rightLeader, WPI_VictorSPX rightFollower, WPI_VictorSPX leftLeader, WPI_VictorSPX leftFollower, ADIS16470_IMU imu) {
        // Initialize the motors
        m_rightLeader = rightLeader;
        m_rightFollower = rightFollower;
        m_leftLeader = leftLeader;
        m_leftFollower = leftFollower;

        m_rightLeader.setNeutralMode(NeutralMode.Brake);
        m_rightFollower.setNeutralMode(NeutralMode.Brake);
        m_leftLeader.setNeutralMode(NeutralMode.Brake);
        m_leftFollower.setNeutralMode(NeutralMode.Brake);


        // Invert the left leader
        m_leftLeader.setInverted(true);
        m_leftFollower.setInverted(true);

        // Set the Differential Drive Class
        m_drive = new DifferentialDrive(m_leftLeader, m_rightLeader);

        // Set the starting speed to 0
        m_drive.arcadeDrive(0, 0);
        m_imu = imu;
    }


    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        followMotor();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new Move(this));
    }

    // Allows the followers to follow the leader motors since MotorGroup is depracted.
    private void followMotor() {
        m_leftFollower.set(m_leftLeader.get());
        m_rightFollower.set(m_rightLeader.get());

    }


    public void flipDrivingMode() {
        if (isShootingMode) {

            isShootingMode = false;
        } else {

            isShootingMode = true;
        }
    }


    public void setMovement(double moveSpeed, double rotSpeed) {
        m_drive.arcadeDrive(moveSpeed, rotSpeed);

        if (!isShootingMode) {
            m_drive.arcadeDrive(-moveSpeed, -rotSpeed);
        }
    }

    public void stopMovement() {
        m_drive.arcadeDrive(0, 0);
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

    public double getIMUAngle() {
        return m_imu.getAngle();
    }

    public void resetIMU() {
        m_imu.reset();
    }
}
