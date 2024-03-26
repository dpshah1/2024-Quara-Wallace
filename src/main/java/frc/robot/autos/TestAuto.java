package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.*;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


public class TestAuto extends SequentialCommandGroup{
    public TestAuto() {
        addCommands(
            new DriveForTime(RobotContainer.drivetrain, 2, true),
            new Delay(2),
            new TurnForAngle(RobotContainer.drivetrain, -90),
            new DriveForTime(RobotContainer.drivetrain, 0.5, true)
        );
    }
}
