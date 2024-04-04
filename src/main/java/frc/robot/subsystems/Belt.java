// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Belt extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private CANSparkMax m_belt;

  public Belt(CANSparkMax belt) {
    m_belt = belt;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Command moveUp() {
    return runOnce(
        () -> {
          m_belt.set(Constants.BELT_MOTOR_SPEED);
          System.out.println("Belt up");
        });
  }

  public Command stopBelt() {
    return runOnce(
        () -> {
          m_belt.set(0);
          System.out.println("Belt stop");
        });
  }

}