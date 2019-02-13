package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
// Subsystem system
import edu.wpi.first.wpilibj.command.Subsystem;
// Motor controller
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// Commands
import frc.robot.commands.setBMHeight;


public class BallManipulator extends Subsystem{

    int position;

    public BallManipulator(){
        position = 0;
    }

    public void initDefaultCommand(){

    }

    public void setWheels(double speed){

    }

    public void setHeight(int position){
        //0 for bottom
        //1 for rocket height
        //2 for cargo height
        this.position = position;

         new setBMHeight(position);
    }

}