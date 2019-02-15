package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.Robot;

public class ToggleDrivingMode extends Command{

    public boolean finished;

    @Override
    protected void execute() {
        if (Robot.drivetrain.mode){
            Robot.drivetrain.setMode(false);
        } else {
            Robot.drivetrain.setMode(true);
        } 
    }

    @Override
    protected boolean isFinished(){
        return finished;
    }

}