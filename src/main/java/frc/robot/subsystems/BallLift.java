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


public class BallLift extends PIDSubsystem{

    int position;

    WPI_TalonSRX left = Robot.drivetrain.leftLift;
    WPI_TalonSRX right = Robot.drivetrain.rightLift;
    SensorCollection lSensors = left.getSensorCollection();
    SensorCollection rSensors = right.getSensorCollection();

    public BallLift(){
        super("BallLiftPID", 0.7, 0.0, 0.0);
        setAbsoluteTolerance(1.0);
        getPIDController().setContinuous(false);
        getPIDController().setName("PIDSubsystem1", "PIDSubsystemController");
        LiveWindow.add(getPIDController());
        getPIDController().setInputRange(0.0, 90.0);
        getPIDController().setOutputRange(-1.0, 1.0);
        position = 0;
    }

    public void initDefaultCommand(){}

    public double returnPIDInput(){
        //TODO adapt to the actual inputs given from the range of motion of boxy boi
        return (lSensors.getAnalogInRaw()+rSensors.getAnalogInRaw())/2;
    }

    public void usePIDOutput(double output){
        
    }

    public void setHeight(int position){
        //0 for bottom
        //1 for rocket height
        //2 for cargo height
        this.position = position;

         new setBMHeight(position);
    }

}