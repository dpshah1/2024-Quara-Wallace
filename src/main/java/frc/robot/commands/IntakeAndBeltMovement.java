package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
public class IntakeAndBeltMovement extends Command {
    private Intake m_intake;
    public IntakeAndBeltMovement(Intake intake) {
        this.m_intake = intake;
        addRequirements(m_intake);
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(RobotContainer.driverDashboard.getRawButton(11))
    {
        m_intake.startIntake();
        System.out.println("started intake nmovement");
    }
    else if(RobotContainer.driverDashboard.getRawButton(12)) {
        m_intake.reverseIntake();
        System.out.println("reverse intake movement");
    }
    else {
        m_intake.stopIntakeCommand();
        System.out.println("stop intake movement");
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

