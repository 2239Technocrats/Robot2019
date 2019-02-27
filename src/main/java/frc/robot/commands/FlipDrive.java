package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class FlipDrive extends Command{

    private boolean flipped;

    public FlipDrive(){
        if(Robot.drivetrain.isFlipped()){
            flipped = false;
        }
        else{
            flipped = true;
        }
    }

    @Override
    protected void execute(){
        Robot.drivetrain.setFlipped(flipped);
    }

    @Override 
    protected boolean isFinished(){
        return flipped = Robot.drivetrain.isFlipped();
    }
}