package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.BallManipulator;

public class BallWheels extends Command{

    double speed;

    public BallWheels(double speed){
        this.speed = speed;
        requires(Robot.ballManipulator);
    }

    protected void execute(){
        Robot.ballManipulator.setSpeed(speed);
        System.out.println("BallWheels are being set to:" + speed);
    }

    @Override
    protected boolean isFinished(){
        return true;
    }
}