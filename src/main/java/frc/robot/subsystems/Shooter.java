package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj2.command.Command;

import static edu.wpi.first.wpilibj2.command.Commands.runOnce;

public class Shooter extends SubsystemBase {
    private CANSparkMax motor;
    private double SPEAKER_SPEED = 0.8;
    private double AMP_SPEED = 0.3;

    public Shooter(CANSparkMax motor) {
        this.motor = motor;
        this.motor.setSmartCurrentLimit(30);
    }

    public Command shootCommand() {
        return runOnce(
            () -> {
                //shoot();
                motor.set(-1.0);
                System.out.println("Running shoot command");
            }
        );
    }

    public Command stopShoot() {
        return runOnce(
            () -> {
                //shoot();
                motor.set(0);
                System.out.println("Stop shoot");
            }
        );
    }

    public void shoot() {
        if (RobotContainer.shooterAngle.getAngleSetpoint() == RobotContainer.shooterAngle.SPEAKER_ANGLE) {
            motor.set(SPEAKER_SPEED);
        } else if (RobotContainer.shooterAngle.getAngleSetpoint() == RobotContainer.shooterAngle.AMP_ANGLE){
            motor.set(AMP_SPEED);
        } else {
            motor.set(0.1);
        }
    }
}