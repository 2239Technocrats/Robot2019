package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
// Subsystem system
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
// Motor controller
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.SensorCollection;

import frc.robot.Robot;
// Commands
import frc.robot.commands.setBMHeight;


public class BallLift extends Subsystem{

    int position;

    public WPI_TalonSRX left;
    public WPI_TalonSRX right;
    public SpeedControllerGroup lift;

    public BallLift(){
        //right.set(com.ctre.phoenix.motorcontrol.ControlMode.Follower,5);

        left = new WPI_TalonSRX(5);
        right = new WPI_TalonSRX(6);
        left.setExpiration(0.5);
        right.setExpiration(0.5);
        lift = new SpeedControllerGroup(left, right);
    }

    public void initDefaultCommand(){
        //setDefaultCommand(new setBMHeight(0));
    }


    public void usePIDOutput(double output){
        left.pidWrite(output);
    }
    
    public WPI_TalonSRX getLeft(){
        return left;
    }

    public WPI_TalonSRX getRight(){
        return right;
    }

    public void setHeight(int position){
        //0 for bottom
        //1 for rocket height
        //2 for cargo height
        this.position = position;

         new setBMHeight(position);
    }

}