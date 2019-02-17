/**
 * motors for succing and blowing the ball
 */
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BallManipulator extends Subsystem{

    public WPI_TalonSRX wheels = new WPI_TalonSRX(7);

    public BallManipulator(){

    }

    @Override
    protected void initDefaultCommand(){
        
    }

    public void setSpeed(double speed){
        wheels.set(speed);
    }

}