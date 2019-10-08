package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
// Subsystem system
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
// Motor controller
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.Robot;
import frc.robot.commands.SetBMPosition;


public class BallLift extends Subsystem{

    int position;

    public DifferentialDrive LIFT_NowInArcadeDrive;
    public WPI_TalonSRX left;
    public WPI_TalonSRX right;
    public SpeedControllerGroup lift;

    public DigitalInput limitSwitchState = new DigitalInput(1);

    public final double kP = 0.5;
    public final double kI = 0;
    public final double kD = 0;
    public final double kF = 0;

    public final double cruiseVelocity = 15000;
    public final double acceleration = 6000;
    public final double percentDeadband = .001;

    public final int tickrate = 4096;

    public final int timeoutMs = 50;

    public BallLift(){
        //right.set(com.ctre.phoenix.motorcontrol.ControlMode.Follower,5);
        
        left = new WPI_TalonSRX(5);
        right = new WPI_TalonSRX(6);
        left.setExpiration(0.5);
        right.setExpiration(0.5);
        lift = new SpeedControllerGroup(left, right);
        right.configFactoryDefault();
        right.follow(left);
        left.configFactoryDefault();
        left.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, timeoutMs);
        left.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, timeoutMs);
        left.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, timeoutMs);
        left.configNeutralDeadband(percentDeadband, timeoutMs);
        left.selectProfileSlot(0, 0);
        left.config_kP(0, kP, timeoutMs);
        left.config_kI(0, kI, timeoutMs);
        left.config_kD(0, kD, timeoutMs);
        left.config_kI(0, kF, timeoutMs);
        left.setSelectedSensorPosition(0, 0, timeoutMs);

    }

    public void initDefaultCommand(){
        //setDefaultCommand(new SetBMPosition(0));
    }


    // public void usePIDOutput(double output){
    //     left.pidWrite(output);
    // }
    
    public WPI_TalonSRX getLeft(){
        return left;
    }

    public WPI_TalonSRX getRight(){
        return right;
    }


    // public DifferentialDrive getLift(){
    //     return LIFT_NowInArcadeDrive;
    // }
}