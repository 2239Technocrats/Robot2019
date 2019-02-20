package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;

public class SetBMSpeed extends Command{

    private int position;

    public SetBMSpeed(double speed){
        this.position = position;
        requires(Robot.ballLift);
        requires(Robot.drivetrain);
    }

    @Override
    protected void initialize(){

    }

    @Override
    protected void execute() {
        Robot.ballLift.left.set(Robot.oi.getJoystick().getRawAxis(1));
        Robot.ballLift.right.set(-Robot.oi.getJoystick().getRawAxis(1));
        System.out.println("Executing setBMHeight, setting at "+ Robot.oi.getJoystick().getRawAxis(1));
    }

    @Override
    protected boolean isFinished(){
        return false;
    }
}