package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkLowLevel;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private final CANSparkMax m_intake;

    public Intake(CANSparkMax intake) {
        m_intake = intake;
    }

    public Command runIntake() {
        return runOnce(
            () -> {
                startIntake();
            }
        );
    }

    public Command stopIntake() {
        return runOnce(
            () -> {
                stopIntakeCommand();
            }
        );
    }

    public void startIntake() {
        m_intake.set(-Constants.IntakeSpeed);
    }

    public void stopIntakeCommand() {
        m_intake.set(0);
    }
}