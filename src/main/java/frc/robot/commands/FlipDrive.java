package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class FlipDrive extends Command{

    private boolean flipped;

    public FlipDrive(){
        
    }

    @Override
    protected void execute(){
        if(Robot.drivetrain.isFlipped()){
            flipped = false;
        }
        else{
            flipped = true;
        }
        Robot.drivetrain.setFlipped(flipped);
    }

    @Override 
    protected boolean isFinished(){
        return flipped = Robot.drivetrain.isFlipped();
    }
}