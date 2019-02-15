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
    public static final double CAMERA_HEIGHT;
    public static final double TAPE_HEIGHT;
    public static final double DIMENSION_RATIO;
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
        return Math.pi()-Math.()
    }    


    public double getDistance(){
        double heightdifference = CAMERA_HEIGHT-TAPE_HEIGHT;
        return heightdifference/Math.atan(ty.getDouble(0.0));
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new DriveToHatch());
    }
}
