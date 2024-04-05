package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ShooterAngle;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;

public class TurnToAngle extends Command {
    private ShooterAngle m_shooterAngle;
    private PIDController pid;
    private double m_angleSetpoint;

    public TurnToAngle(ShooterAngle shooterAngle, double angleSetpoint) {
        this.m_shooterAngle = shooterAngle;
        this.m_angleSetpoint = angleSetpoint;
    }

    @Override
    public void initialize() {
        pid = new PIDController(0.01, 0, 0);
        pid.setSetpoint(m_angleSetpoint);
        pid.setTolerance(5); // fix this later
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_shooterAngle.setMotorSpeed(pid.calculate(m_shooterAngle.getEncoderPosition()));
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_shooterAngle.setMotorSpeed(0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return pid.atSetpoint();
    }


}
