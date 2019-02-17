package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
// Subsystem system
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
// Motor controller
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.SensorCollection;

import frc.robot.Robot;
// Commands
import frc.robot.commands.setBMHeight;


public class BallLiftLeft extends PIDSubsystem{

    int position;

    public WPI_TalonSRX left = Robot.drivetrain.leftLift;
    public WPI_TalonSRX right = Robot.drivetrain.rightLift;
    SensorCollection lSensors = left.getSensorCollection();
    SensorCollection rSensors = right.getSensorCollection();

    public BallLiftLeft(){
        super("BallLiftLeftPID", 0.7, 0.0, 0.0);
        setAbsoluteTolerance(1.0);
        getPIDController().setContinuous(false);
        getPIDController().setName("PIDSubsystem1", "PIDSubsystemControllerLeft");
        LiveWindow.add(getPIDController());
        getPIDController().setInputRange(0.0, 90.0);
        getPIDController().setOutputRange(-1.0, 1.0);
        position = 0;
    }

    public void initDefaultCommand(){
        //TODO
    }

    public double returnPIDInput(){
        //TODO adapt to the actual inputs given from the range of motion of boxy boi
        return (lSensors.getAnalogInRaw());
    }

    public void usePIDOutput(double output){
        left.pidWrite(output);
    }
    
    public WPI_TalonSRX getLeft(){
        return left;
    }

    public WPI_TalonSRX getRight(){
        return right;
    }

    public void setHeight(int position){
        //0 for bottom
        //1 for rocket height
        //2 for cargo height
        this.position = position;

         new setBMHeight(position);
    }

}