// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ShooterAngle;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class LowerShooterAngle extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShooterAngle m_shooterAngle;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public LowerShooterAngle(ShooterAngle shooterAngle) {
    m_shooterAngle = shooterAngle;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_shooterAngle);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooterAngle.setMotorSpeed(m_shooterAngle.calculateSpeed());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooterAngle.setMotorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_shooterAngle.isInRange();
  }
}
