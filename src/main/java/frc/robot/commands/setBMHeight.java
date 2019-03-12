package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.BallLift;

import frc.robot.Robot;

public class setBMHeight extends Command{

    private int position;
    WPI_TalonSRX leftlift;
    WPI_TalonSRX rightlift;

    public setBMHeight(int position){
        this.position = position;
        requires(Robot.ballLift);
        requires(Robot.drivetrain);
    }

    @Override
    protected void initialize(){
        leftlift = Robot.Drivetrain.ballLift.getLeft();
        rightlift = Robot.Drivetrain.ballLift.getRight();
        rightlift.set(com.ctre.phoenix.motorcontrol.ControlMode.Follower,5);
    }

    @Override
    protected void execute() {
        rightlift.set(com.ctre.pheonix.motorcontrol.ControlMode.MotionMagic,position);
        System.out.println("Executing setBMHeight, setting at "+ Robot.oi.getJoystick().getRawAxis(1));
    }

    @Override
    protected boolean isFinished(){
        return true;
    }
}