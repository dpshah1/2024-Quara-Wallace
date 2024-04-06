package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
    private WPI_VictorSPX m_leftClimb;
    private WPI_TalonSRX m_rightClimb;

    public Climber(WPI_VictorSPX leftClimb, WPI_TalonSRX rightClimb) {
        m_leftClimb = leftClimb;
        m_rightClimb = rightClimb;
        m_leftClimb.setNeutralMode(NeutralMode.Brake); // Set the motor to brake mode
        m_rightClimb.setNeutralMode(NeutralMode.Brake);

        // m_rightClimb.setInverted(false);
        // m_leftClimb.follow(m_rightClimb);
    }

    public void climb() {
        m_rightClimb.set(0.6);
        m_leftClimb.set(0.6);
    }

    public void unclimb() {
        m_rightClimb.set(-0.6);
        m_leftClimb.set(-0.6);
    }

    public void stopClimbing() {
        m_rightClimb.set(0);
        m_leftClimb.set(0);
    }

    public Command retractClimb() {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return runOnce(
            () -> {
            climb();
            });
    }

    public Command extendClimb() {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return runOnce(
            () -> {
            unclimb();
            });
    }

    public Command stopClimb() {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return runOnce(
            () -> {
            stopClimbing();
            });
    }


}