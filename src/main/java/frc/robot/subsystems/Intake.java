package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private final WPI_TalonSRX topIntakeMotor;
    private final WPI_TalonSRX bottomIntakeMotor;

    public Intake() {
        topIntakeMotor = new WPI_TalonSRX(Constants.TopIntakeMotor);
        bottomIntakeMotor = new WPI_TalonSRX(Constants.BottomIntakeMotor);
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