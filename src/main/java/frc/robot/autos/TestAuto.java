package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.*;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


public class TestAuto extends SequentialCommandGroup{
    public TestAuto() {
        addCommands(
            new DriveForTime(RobotContainer.drivetrain, 1, false),
            new TurnForAngle(RobotContainer.drivetrain, 25),
            new DriveForTime(RobotContainer.drivetrain, 2, true),
            new TurnForAngle(RobotContainer.drivetrain, -30)
        );
    }
}
