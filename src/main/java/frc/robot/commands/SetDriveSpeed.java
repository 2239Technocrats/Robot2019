package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetDriveSpeed extends Command{

    private double targetSpeed;

    public SetDriveSpeed(double speed){
        targetSpeed = speed;
    }

    @Override
    protected void execute() {
        Robot.drivetrain.setSpeed(targetSpeed);
    }

    @Override
    protected boolean isFinished(){
        return Robot.drivetrain.speed == targetSpeed;
    }

}