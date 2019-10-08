
package frc.robot.subsystems;

// Subsystem system
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Solenoid;

public class ExtendoHatch extends Subsystem {

    Solenoid solenoid;
    public ExtendoHatch(){
        solenoid = new Solenoid(1);
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
