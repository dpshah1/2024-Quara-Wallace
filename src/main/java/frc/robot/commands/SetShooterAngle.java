package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;


public class SetShooterAngle extends Command {
    
    private ShooterAngle m_shooterAngle;
    private PIDController pid;

    private final double kP = 0.01;
    private final double kI = 0;
    private final double kD = 0;


    public SetShooterAngle (ShooterAngle shooterAngle)
    {
        this.m_shooterAngle = shooterAngle;
        this.pid = new PIDController(kP, kI, kD);
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = pid.calculate(m_shooterAngle.getEncoderPosition(), m_shooterAngle.getAngleSetpoint());

    m_shooterAngle.setMotorSpeed(speed);
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
