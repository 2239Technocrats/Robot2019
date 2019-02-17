
package frc.robot.subsystems;

// Subsystem system
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Solenoid;

public class HatchManipulator extends Subsystem {

    Solenoid solenoid;
    public HatchManipulator(){
        solenoid = new Solenoid(0);
    }

    public void initDefaultCommand(){

    }

    public void setState(boolean state){
        solenoid.set(state);
    }

    public boolean getState() {
        return solenoid.get();
    }
}
