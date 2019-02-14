
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
// Subsystem system
import edu.wpi.first.wpilibj.command.Subsystem;
// Motor controller
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.VelocityTalon;
import edu.wpi.first.wpilibj.Solenoid;
// Commands
import frc.robot.commands.TDrive;

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
}
