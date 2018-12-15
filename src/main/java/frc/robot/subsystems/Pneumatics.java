package frc.robot.subsystems;

// Base subsystem class
import edu.wpi.first.wpilibj.command.Subsystem;
// Robot's compressor
import edu.wpi.first.wpilibj.Compressor;
// Solenoids
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics extends Subsystem {
    Compressor compressor;
    Solenoid grabber;
    // initalizes compressor
    public void initalizeCompressor() {
        compressor.start();
        compressor.setClosedLoopControl(true);
    }
    // move grabber
    public void setGrabber(boolean state) {
        grabber.set(state);
    }
    // get grabber state
    public boolean getGrabber() {
        return grabber.get();
    }

    public Pneumatics() {
        compressor = new Compressor();
        grabber = new Solenoid(14, 2);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

