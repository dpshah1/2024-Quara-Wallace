package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkLowLevel;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private final CANSparkMax topIntakeMotor;
    private final CANSparkMax bottomIntakeMotor;

    public Intake() {
        topIntakeMotor = new CANSparkMax(Constants.TOP_INTAKE_PORT, CANSparkLowLevel.MotorType.kBrushless);
        bottomIntakeMotor = new CANSparkMax(Constants.BOTTOM_INTAKE_PORT, CANSparkLowLevel.MotorType.kBrushless);
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
        topIntakeMotor.set(-Constants.IntakeSpeed);
        bottomIntakeMotor.set(Constants.IntakeSpeed);
    }

    public void stopIntakeCommand() {
        topIntakeMotor.set(0);
        bottomIntakeMotor.set(0);
    }
}