package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class TurnAround extends Command{

    private boolean finished;
    private double time;
    private double speed;
    Timer timer = new Timer();

    public TurnAround(double time, double speed){
        this.time = time;
        this.speed = speed;
        timer.start();
    }

    @Override
    protected void execute(){
        Robot.drivetrain.drive((float)speed, (float)-speed);
    }

    @Override
    protected boolean isFinished(){
        if(timer.get()<time){
            return false;
        }else{
            return true;
        }
    }

}