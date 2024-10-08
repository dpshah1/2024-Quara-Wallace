// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;
import frc.robot.Constants;

/** An example command that uses an example subsystem. */
public class DriveForTime extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain m_drive;
  private Timer m_timer;
  private double m_time;
  private boolean m_forward;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveForTime(Drivetrain drive, double time, boolean forward) {
    m_drive = drive;
    m_timer = new Timer();
    m_time = time;
    m_forward = !forward;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_forward) {
        m_drive.setMovement(Constants.AUTO_MOVE_SPEED, 0);
    }
    else {
        m_drive.setMovement(-Constants.AUTO_MOVE_SPEED, 0);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.stopMovement();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_timer.hasElapsed(m_time)) {
        return true;
    }

    return false;
  }
}

