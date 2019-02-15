package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.OI;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.*;
import java.util.Arrays;

/**
 * An example command.  You can replace me with your own command.
 */
public class DriveToHatch extends Command {
    /**
     *
     */

    public static final double FORWARD_SPEED = -0.7;
    public static final double TURN_SPEED = 0.01;
    DifferentialDrive drive;
    XboxController testXbox;
  public DriveToHatch() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.limelight);
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    drive = Robot.drivetrain.getDrive();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute(){
    double[] limelightdata = Robot.limelight.getTapeLocation();
    //System.out.println(String.format("Limelight X: %f", limelightdata[0]));

    if (isTargetVisible(limelightdata)) {
      double percentError = limelightdata[0]/25;
      SmartDashboard.putNumber("PercentError", percentError);
      if(percentError>=0){
        drive.tankDrive(FORWARD_SPEED*(1-percentError), FORWARD_SPEED);
        SmartDashboard.putNumber("DriveLeft", FORWARD_SPEED);
        SmartDashboard.putNumber("DriveRight", FORWARD_SPEED*(1-percentError));
      }else{
        drive.tankDrive(FORWARD_SPEED, FORWARD_SPEED*(1+percentError));
        SmartDashboard.putNumber("DriveLeft", FORWARD_SPEED*(1+percentError));
        SmartDashboard.putNumber("DriveRight", FORWARD_SPEED);
      }
    } else {
      drive.tankDrive(0,0);
    }

    SmartDashboard.putBoolean("TargetVisible", isTargetVisible(limelightdata));
    SmartDashboard.putNumber("LimelightX",limelightdata[0]);
    SmartDashboard.putNumber("LimelightY",limelightdata[1]);
    SmartDashboard.putNumber("LimelightArea", limelightdata[2]);
    System.out.println("Executing DriveToHatch");
  }

  private boolean isTargetVisible(double[] data) {
    return data.length > 2 && data[2] > 0.01;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // System.out.println("isFinished(); on exampleCommand")
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
