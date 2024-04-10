package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class CenterAutoTwoNote extends SequentialCommandGroup {
    public CenterAutoTwoNote() {
        addCommands(
            new DriveForTime(RobotContainer.drivetrain, 1, false);
            RobotContainer.shooter.shootCommand();

            new ParallelCommandGroup(
                new DriveForTime(RobotContainer.drivetrain, 1, false);
                new IntakeNote();
            );

            new DriveForTime(RobotContainer.drivetrain, 1, true);
            RobotContainer.shooter.shootCommand();
            new DriveForTime(RobotContainer.drivetrain, 1, false);
        );
    }
    
}
