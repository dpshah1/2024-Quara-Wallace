package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.subsystems.Drivetrain;
import frc.robot.Constants;

public class TurnForAngle extends Command {
    private final Drivetrain drivetrain;
    private final double angleChange;
    private PIDController pidController;

    public TurnForAngle(Drivetrain drivetrain, double angleChange) {
        this.drivetrain = drivetrain;
        this.angleChange = angleChange;
        addRequirements(drivetrain);

        pidController = new PIDController(Constants.KP_TURN_ANGLE, Constants.KI_TURN_ANGLE, Constants.KD_TURN_ANGLE);
    }

    @Override
    public void initialize() {
        pidController.reset();
        drivetrain.resetGyro();
    }

    @Override
    public void execute() {
        double error = angleChange - drivetrain.getGyroAngle();

        double speed = pidController.calculate(error);

        drivetrain.setMovement(speed, 0);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stopMovement();
    }

    @Override
    public boolean isFinished() {
        return pidController.atSetpoint();
    }
}