/**
 * motors for succing and blowing the ball
 */
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.BallWheels;

public class BallManipulator extends Subsystem{

    public WPI_TalonSRX wheels = new WPI_TalonSRX(7);

    public BallManipulator(){

    }

    @Override
    protected void initDefaultCommand(){
        setDefaultCommand(new BallWheels(0));
    }

    public void setSpeed(double speed){
        wheels.set(speed);
    }

}