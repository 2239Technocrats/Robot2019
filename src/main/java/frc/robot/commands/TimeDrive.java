package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

public class TimeDrive extends Command{

    private double time = 0;
    private double speed = 0;
    private boolean finished = false;
    private Timer timer = new Timer();
    private DifferentialDrive drive;

    public TimeDrive(double time, double speed){
        requires(Robot.drivetrain);
        this.time = time;
        this.speed = speed;
        drive = Robot.drivetrain.getDrive();
        timer.start();
    }

    @Override
    protected void execute(){
        Robot.drivetrain.drive((float)speed, (float)speed);
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