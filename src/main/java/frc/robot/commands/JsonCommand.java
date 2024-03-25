package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Timer;

import java.nio.file.Paths;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

public class JsonCommand extends Command {
    private final Drivetrain m_drivetrain;
    private List<Map<String, String>> commands;
    private int currentCommandIndex;
    private Timer timer;

    public JsonCommand(Drivetrain drivetrain) {
        this.m_drivetrain = drivetrain;
        addRequirements(m_drivetrain);
        this.currentCommandIndex = 0;
        this.timer = new Timer();
        try {
            ObjectMapper mapper = new ObjectMapper();
            this.commands = mapper.readValue(Paths.get("commands.json").toFile(), new TypeReference<List<Map<String, String>>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
        if (currentCommandIndex < commands.size()) {
            Map<String, String> command = commands.get(currentCommandIndex);
            String action = command.get("action");
            double time = Double.parseDouble(command.get("time").replace("s", ""));
            if (timer.get() >= time) {
                if ("forward".equals(action)) {
                    m_drivetrain.setMovement(1, 0);
                } else if ("left".equals(action)) {
                    m_drivetrain.setMovement(0, -1);
                } else if ("right".equals(action)) {
                    m_drivetrain.setMovement(0, 1);
                }
                currentCommandIndex++;
                timer.reset();
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
        m_drivetrain.stopMovement();
    }

    @Override
    public boolean isFinished() {
        return currentCommandIndex >= commands.size();
    }
}