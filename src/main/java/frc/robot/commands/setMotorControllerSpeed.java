package frc.robot.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

public class setMotorControllerSpeed extends Command {

    SpeedController s;
    boolean done = false;

    public setMotorControllerSpeed(SpeedController s){
        this.s = s;

    }

    @Override
    protected void execute(){
        s.set(.25);
        done = true;
    }


    @Override
    protected boolean isFinished(){
        return done;
    }
}