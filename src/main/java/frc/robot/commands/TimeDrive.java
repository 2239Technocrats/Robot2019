package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

public class TimeDrive extends Command{

    private double time;
    private double speed;
    private boolean finished = false;
    Timer timer;

    public TimeDrive(double time, double speed){
        requires(Robot.drivetrain);
        this.time = time;
        this.speed = speed;
    }

    @Override
    protected void execute(){
        timer.start();
        while(timer.get() < time){
            Robot.drivetrain.drive((float)speed, (float)speed);
        }
        timer.reset();
        finished = true;
    }

    @Override
    protected boolean isFinished(){
        return finished;
    }

}