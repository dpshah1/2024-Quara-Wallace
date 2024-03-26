package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;

public class SetSpeakerMode extends Command {
    
    private ShooterAngle m_shooter;
    private PIDController pid;

    private double kP = 0.1;
    private double kI = 0;
    private double kD = 0;

    public SetSpeakerMode(ShooterAngle shooter) {
        this.m_shooter = shooter;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        pid = new PIDController(kP, kI, kD);
        pid.setSetpoint(m_shooter.SPEAKER_ANGLE);
        pid.setTolerance(0.5);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_shooter.setMotorSpeed(pid.calculate(m_shooter.getEncoderPosition()));
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_shooter.setMotorSpeed(0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if(pid.atSetpoint()) {
            return true;
        }
        
        return false;
    }
}
