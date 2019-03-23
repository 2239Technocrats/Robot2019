package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;

public class SetBMSpeed extends Command{

    // private double speed;

    public SetBMSpeed(/*double speed*/){
        // this.speed = speed;
        requires(Robot.ballLift);
    }


    @Override
    protected void execute() {
        if(Robot.oi.getJoystick().getRawButton(3)){
            
            Robot.ballLift.left.set(-Robot.oi.getJoystick().getRawAxis(1));
            Robot.ballLift.right.set(-Robot.oi.getJoystick().getRawAxis(1));
            // Robot.ballLift.getLift().tankDrive(-Robot.oi.getJoystick().getRawAxis(1), Robot.oi.getJoystick().getRawAxis(1));
        }else if(Robot.oi.getXboxController().getRawButton(3)){
            Robot.ballLift.left.set(Robot.oi.getXboxController().getRawAxis(0));
            Robot.ballLift.right.set(Robot.oi.getXboxController().getRawAxis(0));
        }else{
            Robot.ballLift.getLift().arcadeDrive(0, 0);
        }
        
        System.out.println("Executing setBMSpeed, setting at "+ Robot.oi.getJoystick().getRawAxis(1));
    }

    @Override
    protected boolean isFinished(){
        return true;
    }
}