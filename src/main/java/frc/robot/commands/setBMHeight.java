package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Robot;

public class setBMHeight extends Command{

    private int position;

    public setBMHeight(int position){
        this.position = position;
        requires(Robot.ballLiftLeft);
        requires(Robot.ballLiftRight);
    }

    @Override
    protected void initialize(){

    }

    @Override
    protected void execute() {
        Robot.ballLiftLeft.getLeft().set(com.ctre.phoenix.motorcontrol.ControlMode.MotionMagic,this.position);
        Robot.ballLiftRight.getRight().set(com.ctre.phoenix.motorcontrol.ControlMode.MotionMagic,this.position);
    }

    @Override
    protected boolean isFinished(){
        return true;
    }
}