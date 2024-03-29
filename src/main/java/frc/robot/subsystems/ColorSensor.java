package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ColorSensor extends SubsystemBase {
    

    ColorSensorV3 m_colorSensor;

    public ColorSensor(ColorSensorV3 colorSensor)
    {
        m_colorSensor = colorSensor;
    }

    @Override
    public void periodic() {
        Color detectedColor = m_colorSensor.getColor();

        double IR = m_colorSensor.getIR();

        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("IR", IR);
        
    }

    


}
