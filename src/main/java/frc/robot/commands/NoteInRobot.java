// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class NoteInRobot extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public NoteInRobot() {

  }



  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Button to emergency stop the intake
    if(RobotContainer.driverDashboard.getRawButton(1)) {
        return true;
    }

    if(RobotContainer.colorSensorSubsystem.getNoteProximity() < Constants.NOTE_DISTANCE) {
        return true;
    }

    return false;
  }
}
