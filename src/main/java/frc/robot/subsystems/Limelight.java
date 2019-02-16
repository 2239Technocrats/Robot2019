package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.commands.DriveToHatch;
import frc.robot.commands.TurnToBall;
import edu.wpi.first.wpilibj.SPI;
import java.lang.Thread;
import java.util.Arrays;
import java.lang.Math;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class Limelight extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    NetworkTable table;
    NetworkTableEntry tx;
    NetworkTableEntry ty;
    NetworkTableEntry ta;

    NetworkTableEntry width;
    public static final double CAMERA_HEIGHT = 24.5;
    public static final double TAPE_HEIGHT = 29;
    public static final double HALF_TAPE_WIDTH =5;
    public static final double DIMENSION_RATIO=2.541;
    // Drivetrain public objects
    public Limelight() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
    }

    public double[] getTapeLocation() {
        return new double[]{tx.getDouble(0.0),ty.getDouble(0.0),ta.getDouble(0.0)};
    }

    public double getAngle(){
        double phi = Math.sqrt(ta.getDouble(0.0)*DIMENSION_RATIO);
        return Math.PI-Math.asin(2*this.getDistance()*Math.sin(phi/2))-phi; 

    }    
//l/sin(180-phi-theta)=d/2sin(phi/2)

    public double getDistance(){
        double heightdifference = CAMERA_HEIGHT-TAPE_HEIGHT;
        return heightdifference/Math.tan(Math.toRadians(ty.getDouble(0.0)));
        
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new DriveToHatch());
    }
}
