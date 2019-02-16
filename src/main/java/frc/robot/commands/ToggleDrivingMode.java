package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.Robot;

public class ToggleDrivingMode extends Command{

    public boolean finished = false;

    @Override
    protected void execute() {
        if (Robot.drivetrain.mode){
            Robot.drivetrain.setMode(false);
            finished = true;
        } else {
            Robot.drivetrain.setMode(true);
            finished = true;
        } 
    }

    @Override
    protected boolean isFinished(){
        return finished;
    }

}