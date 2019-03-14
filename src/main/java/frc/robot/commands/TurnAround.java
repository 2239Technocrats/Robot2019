package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class TurnAround extends Command{

    private boolean finished;
    private double time;
    private double speed;
    Timer timer;

    public TurnAround(double time, double speed){
        this.time = time;
        this.speed = speed;
    }

    @Override
    protected void execute(){
        timer.start();
        while(timer.get() < time){
            Robot.drivetrain.drive((float)speed, (float)-speed);
        }
        timer.reset();
        finished = true;
    }

    @Override
    protected boolean isFinished(){
        return finished;
    }

}