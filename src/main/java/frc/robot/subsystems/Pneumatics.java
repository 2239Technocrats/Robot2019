package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
    //collection of all of the solenoid index:port on PCM
    public Solenoid[] allSolenoids = new Solenoid[1];

    public Solenoid literallyTheOnlySolenoidCuzOurRobotIsTrash;
    // Solenoid public objects
    public Pneumatics () {
        literallyTheOnlySolenoidCuzOurRobotIsTrash = new Solenoid(0);
        allSolenoids[0] = literallyTheOnlySolenoidCuzOurRobotIsTrash;
    }
  
    public Solenoid getSolenoid(int index) {
        return allSolenoids[index];
    }
  
    @Override
    public void initDefaultCommand() {}
  
    public void toggleSolenoid(int index, boolean status){
        allSolenoids[index].set(status);
    }
  
  }
  