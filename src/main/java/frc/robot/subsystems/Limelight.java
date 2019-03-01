package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import java.lang.Math;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Limelight extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Ca ..ll these from Commands.
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
        double phi = Math.sqrt(Math.toRadians(ta.getDouble(0.0))*DIMENSION_RATIO);
        double l = this.getDistance();
        double d = this.HALF_TAPE_WIDTH;
        
        SmartDashboard.putNumber("result of getAngle()", Math.PI-Math.asin(2*l*Math.sin(2*l*Math.sin(phi/2)/d)));
        return Math.PI-Math.asin(2*l*Math.sin(2*l*Math.sin(phi/2)/d));  
    }    

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
