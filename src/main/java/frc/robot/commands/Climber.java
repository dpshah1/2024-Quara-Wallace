package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Climber {
    private WPI_TalonSRX climberMotor;

    public Climber(WPI_TalonSRX climberMotor) {
        this.climberMotor = climberMotor;
        this.climberMotor.setNeutralMode(NeutralMode.Brake); // Set the motor to brake mode
    }

    public void climb() {
        climberMotor.set(1.0);
    }

    public void unclimb() {
        climberMotor.set(-1.0);
    }

    public void stopClimbing() {
        climberMotor.set(0.0);
    }
}