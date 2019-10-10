package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;

public class SetBMSpeed extends Command{


    public SetBMSpeed(){
        requires(Robot.ballLift);
    }


    @Override
    protected void execute() {
        if(Robot.oi.getXboxController().getRawButton(3) && Robot.oi.getXboxController().getRawAxis(2) > 0){
            
            Robot.ballLift.left.set(-.5*Robot.oi.getXboxController().getRawAxis(2));
            System.out.println("Setting Left to "+(-.5*Robot.oi.getXboxController().getRawAxis(2)));
            Robot.ballLift.right.set(.5*Robot.oi.getXboxController().getRawAxis(2));
            System.out.println("Setting Right to "+(.5*Robot.oi.getXboxController().getRawAxis(2)));
            Robot.ballManipulator.setSpeed(.25);
        }
        else if(Robot.oi.getXboxController().getRawButton(3) && Robot.oi.getXboxController().getRawAxis(3) > 0){
            
            Robot.ballLift.left.set(.5*Robot.oi.getXboxController().getRawAxis(3));
            System.out.println("Setting Left to "+(-.5*Robot.oi.getXboxController().getRawAxis(3)));
            Robot.ballLift.right.set(-.5*Robot.oi.getXboxController().getRawAxis(3));
            System.out.println("Setting Right to "+(.5*Robot.oi.getXboxController().getRawAxis(3)));
        }

        else{
            Robot.ballLift.left.set(0);
            Robot.ballLift.right.set(0);
        }
        
    }

    @Override
    protected boolean isFinished(){
        return true;
    }
}