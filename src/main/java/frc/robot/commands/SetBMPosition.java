package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.BallManipulator;

public class SetBMPosition extends Command{

    int position;

    public SetBMPosition(int position){
        this.position = position;
        requires(Robot.ballManipulator);
    }

    protected void execute(){
        System.out.println("setting lift position to "+position);
        Robot.ballLift.getLeft().set(ControlMode.MotionMagic, position);
    }

    @Override
    protected boolean isFinished(){
        return true;
    }
}