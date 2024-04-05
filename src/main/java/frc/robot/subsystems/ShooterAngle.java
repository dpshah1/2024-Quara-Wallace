package frc.robot.subsystems;


import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;



public class ShooterAngle extends SubsystemBase {
    private CANSparkMax m_shooterAngleMotor;
    public final double SPEAKER_ANGLE = 999; // test to find the actual angle
    public final double AMP_ANGLE = 999; // test to find the actual angle
    public final double REST_ANGLE = 999; // test to find the acutal angle 
    private double currentAngleSetpoint = REST_ANGLE;
    

    // public final double SPEAKER_SHOOT_SPEED = 0.8;
    // public final double AMP_SHOOT_SPEED = 0.3;

    public ShooterAngle(CANSparkMax shooterAngleMotor) {
        this.m_shooterAngleMotor = shooterAngleMotor;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public double getEncoderPosition() {
        return m_shooterAngleMotor.getEncoder().getPosition();
    }

    public double getAngleSetpoint() {
        return currentAngleSetpoint;
    }

    public void setAngleSetpoint(double newSetpoint) {
        currentAngleSetpoint = newSetpoint;
    }

    public void setMotorSpeed(double speed) {
        m_shooterAngleMotor.set(speed);
    }

    public Command setTestSpeed(double speed) {
        return runOnce(
            () -> {
                this.setMotorSpeed(speed);
            }
        );
    }

}
