package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class FlipDrive extends Command{

    private boolean flipped;

    public FlipDrive(boolean state){
        flipped = state;
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