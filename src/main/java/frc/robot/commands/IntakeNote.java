package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


public class IntakeNote extends SequentialCommandGroup {
    public IntakeNote() {
        addCommands(
            RobotContainer.belt.moveUp(),
            RobotContainer.intake.runIntake(),
            new NoteInRobot(),
            RobotContainer.intake.stopIntake(),
            RobotContainer.belt.stopBelt()
        );
    }
}
