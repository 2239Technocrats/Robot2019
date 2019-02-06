package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.commands.TurnToBall;
import edu.wpi.first.wpilibj.SPI;
import java.lang.Thread;
import java.util.Arrays;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;

public class Pixy extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    AnalogInput pixy_x;
    DigitalInput pixy_on;

    // Drivetrain public objects
    public Pixy() {
        pixy_x = new AnalogInput(0);
        pixy_x.setOversampleBits(4);
        pixy_x.setAverageBits(4);
        pixy_on = new DigitalInput(0);
    }

    public double getBallLocation() {
        return pixy_x.getAverageVoltage();
    }

    public boolean isDetected() {
        return pixy_on.get();
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TurnToBall());
    }
}
