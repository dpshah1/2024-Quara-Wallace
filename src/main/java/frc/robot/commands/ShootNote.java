// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.*;;

/** An example command that uses an example subsystem. */
public class ShootNote extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Shooter m_shooter;
  private boolean isOver;
  private Timer t;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShootNote(Shooter shooter) {
    m_shooter = shooter;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isOver = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.xController.getBButton()) {
        m_shooter.shootNote(true);

        // add code to wait for 1.5 seconds
        waitForTime(1.5);
    }
    else if (RobotContainer.xController.getXButton()) {
        m_shooter.shootNote(false);

        // add code to wait for 1.5 seconds
        waitForTime(1.5);
    }
    
    
  }

  private void waitForTime(double timeInSeconds) {
    // do stuff
    t = new Timer();

    t.restart();

    while (!t.hasElapsed(timeInSeconds)) {
        // wait
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
