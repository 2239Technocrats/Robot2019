package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class TurnAround extends Command{

    private double speed = Robot.drivetrain.speed;

    public TurnAround(){
        requires(Robot.drivetrain);
    }

    @Override
    protected void execute(){
        Robot.drivetrain.left.set(speed);
        Robot.drivetrain.right.set(speed);
    }

    @Override
    protected boolean isFinished(){
        return false;
    }

}