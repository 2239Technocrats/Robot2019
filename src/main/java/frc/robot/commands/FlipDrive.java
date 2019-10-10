package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
/**
 * FlipDrive flips the direction of the controls
 */
 public class FlipDrive extends Command{

    private boolean flipped;

    public FlipDrive(){
        
    }

    @Override
    protected void execute(){
        if(Robot.drivetrain.isFlipped()){
            Robot.drivetrain.setFlipped(false);
        }
        else{
            Robot.drivetrain.setFlipped(true);
        }
    }

    @Override 
    protected boolean isFinished(){
        return true;
    }
}