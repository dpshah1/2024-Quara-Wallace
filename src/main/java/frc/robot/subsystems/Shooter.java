package frc.robot.subsystems;


import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;



public class Shooter extends SubsystemBase {
    private CANSparkMax m_shooterAngleMotor;
    public final double SPEAKER_ANGLE = 999; // test to find the actual angle
    public final double AMP_ANGLE = 999; // test to find the actual angle

    public final double SPEAKER_SHOOT_SPEED = 0.8;
    public final double AMP_SHOOT_SPEED = 0.3;

    public Shooter(CANSparkMax shooterAngleMotor) {
        this.m_shooterAngleMotor = shooterAngleMotor;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public double getEncoderPosition() {
        return m_shooterAngleMotor.getEncoder().getPosition();
    }

    public void setMotorSpeed(double speed) {
        m_shooterAngleMotor.set(speed);
    }

    public void shootNote(boolean isSpeaker) {
        if(isSpeaker) {
            this.setMotorSpeed(SPEAKER_SHOOT_SPEED);
        }
        else {
            this.setMotorSpeed(AMP_SHOOT_SPEED);
        }
    }

}
