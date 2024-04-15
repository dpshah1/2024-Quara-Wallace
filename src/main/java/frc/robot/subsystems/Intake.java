package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkLowLevel;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import frc.robot.commands.IntakeAndBeltMovement;
import frc.robot.commands.Move;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private final CANSparkMax m_intake;
    private final CANSparkMax m_belt;

    public Intake(CANSparkMax intake, CANSparkMax belt) {
        m_intake = intake;
        m_belt = belt;
        m_intake.setSmartCurrentLimit(30);
        m_belt.setSmartCurrentLimit(30);
    }

    public Command runIntake() {
        return runOnce(
            () -> {
                System.out.println("Running the intake");
                startIntake();
            }
        );
    }

    public void initDefaultCommand() {
        setDefaultCommand(new IntakeAndBeltMovement(this));
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
        m_belt.set(-Constants.BELT_MOTOR_SPEED);
    }

    public void reverseIntake() {
        m_intake.set(Constants.IntakeSpeed);
        m_belt.set(Constants.BELT_MOTOR_SPEED);
    }

    public void stopIntakeCommand() {
        m_intake.set(0);
        m_belt.set(0);
    }
}