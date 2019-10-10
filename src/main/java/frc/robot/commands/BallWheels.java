package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.BallManipulator;

public class BallWheels extends Command{

    double speed;

    public BallWheels(double speed){
        this.speed = speed;
        requires(Robot.ballManipulator);
    }

    protected void execute(){
        if(Robot.oi.getXboxController().getRawAxis(2) > 0  && !Robot.oi.getXboxController().getRawButton(3)){
            Robot.ballManipulator.setSpeed(Robot.oi.getXboxController().getRawAxis(2));
        }else if(Robot.oi.getXboxController().getRawAxis(3) > 0  && !Robot.oi.getXboxController().getRawButton(3)){
            Robot.ballManipulator.setSpeed(-Robot.oi.getXboxController().getRawAxis(3));
        }else if(Robot.oi.getXboxController().getRawButton(3)  && Robot.oi.getXboxController().getRawAxis(3) > 0){
            Robot.ballManipulator.setSpeed(-.5*Robot.oi.getXboxController().getRawAxis(3));
        }else{
        Robot.ballManipulator.setSpeed(speed);
        SmartDashboard.putNumber("BallWheels are being set to:", speed);
        }

    }

    @Override
    protected boolean isFinished(){
        return true;
    }
}