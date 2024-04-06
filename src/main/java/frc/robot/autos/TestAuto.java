package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


public class TestAuto extends SequentialCommandGroup{
    public TestAuto() {
        addCommands(
            new DriveForTime(RobotContainer.drivetrain, 2, false),
            new Delay(0.5),
            new TurnForAngle(RobotContainer.drivetrain, -90),
            new Delay(0.5),
            new DriveForTime(RobotContainer.drivetrain, 1, true),
            new Delay(0.5),
            new LowerShooterAngle(RobotContainer.shooterAngle),
            new Delay(0.5),
            new DriveForTime(RobotContainer.drivetrain, 0.25, true),
            RobotContainer.shooter.shootCommand()
        );
    }
}
