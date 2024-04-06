package frc.robot.subsystems;


import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.Move;
import frc.robot.commands.ShooterAngleMovement;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        m_shooterAngleMotor.setIdleMode(IdleMode.kBrake);
        m_shooterAngleMotor.getEncoder().setPosition(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Shooter angle position: ", m_shooterAngleMotor.getEncoder().getPosition());
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

    public void initDefaultCommand() {
        setDefaultCommand(new ShooterAngleMovement(this));
    }

    public Command setTestSpeed(double speed) {
        return runOnce(
            () -> {
                this.setMotorSpeed(speed);
            }
        );
    }
    public boolean isInRange()
    {
        if(Math.abs(getEncoderPosition() - Constants.target) < 10)
        {
            return true;
        }
        return false;
    }

    public double calculateSpeed() {
        if(this.getEncoderPosition() - Constants.target > 0) {
            return 0.1;
        }
        else {
            return -0.1;
        }
    }

}
