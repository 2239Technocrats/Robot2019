package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
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
