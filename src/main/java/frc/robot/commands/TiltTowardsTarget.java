package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;


public class TiltTowardsTarget extends Command {
	private final Vision visionSubsystem;
	private final Drivetrain drivetrainSubsystem;

	private final double TILT_TOLERANCE = 0.5;
	private final double kP = 0.02; // might need adjusting

	private PIDController pid;

	public TiltTowardsTarget(Vision visionSubsystem, Drivetrain drivetrainSubsytem) {
		this.visionSubsystem = visionSubsystem;
		this.drivetrainSubsystem = drivetrainSubsytem;

		addRequirements(drivetrainSubsytem);
	}

	@Override
	public void initialize() {
		System.out.println("initialize");

		pid = new PIDController(kP, 0, 0);
		pid.setTolerance(TILT_TOLERANCE);
		pid.setSetpoint(0);
	}

	@Override
	public void execute() {
		System.out.println("execute");
		double offset = visionSubsystem.calcOffset();

		double rotSpeed = pid.calculate(offset);

		drivetrainSubsystem.setMovement(rotSpeed, 0);
	}

	@Override
	public void end(boolean interrupted) {
		System.out.println("end");
		drivetrainSubsystem.stopMovement();
	}

	@Override
	public boolean isFinished() {
		return pid.atSetpoint();
	}
}