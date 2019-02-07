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
    double counter;
    double averageVoltage;
    boolean isDetected = false;
    // Drivetrain public objects
    public Pixy() {
        pixy_x = new AnalogInput(0);
        pixy_x.setOversampleBits(2);
        pixy_x.setAverageBits(2);
        pixy_on = new DigitalInput(0);
        counter = 0;
    }

    public double getBallLocation() {
        if (counter%20==0){
            averageVoltage = pixy_x.getAverageVoltage();
        }
        counter +=1 ;
        return averageVoltage;
    }

    public boolean isDetected() {
        if (counter%20==0){
            isDetected = pixy_on.get();
        }
        counter +=1 ;
        return isDetected;
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new TurnToBall());
    }
}
