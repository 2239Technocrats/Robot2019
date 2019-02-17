package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.BallManipulator;

public class BallWheels extends Command{

    double speed;

    public BallWheels(double speed){
        this.speed = speed;
    }

    protected void execute(){
        Robot.ballManipulator.wheels.set(speed);
    }

    @Override
    protected boolean isFinished(){
        return true;
    }
}