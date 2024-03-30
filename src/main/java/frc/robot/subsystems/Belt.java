// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class Belt extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private WPI_VictorSPX m_leftBelt;
  private WPI_VictorSPX m_rightBelt;

  

  public Belt(WPI_VictorSPX leftBelt, WPI_VictorSPX rightBelt) {
    m_leftBelt = leftBelt;
    m_rightBelt = rightBelt;

    // Inverts
    m_leftBelt.follow(m_rightBelt, true);
  }



  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public Command moveUp() {
    return runOnce(
        () -> {
        m_rightBelt.set(BELT_MOTOR_SPEED);
        System.out.println("Belt up");
        });
  }


}