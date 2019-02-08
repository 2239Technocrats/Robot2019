
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.OI;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import java.util.Arrays;

/**
 * An example command.  You can replace me with your own command.
 */
public class TurnToBall extends Command {
    public static final double TURN_SPEED=0.1;
    DifferentialDrive drive;
    XboxController testXbox;
  public TurnToBall() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);
    requires(Robot.pixy);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    drive = Robot.drivetrain.getDrive();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute(){
    System.out.println(Robot.pixy.getBallLocation()+"  ,  "+Robot.pixy.isDetected());
    if (Robot.pixy.isDetected()){
      if(Robot.pixy.getBallLocation()>1.45){
        drive.tankDrive(-0.7+TURN_SPEED*Math.pow((Robot.pixy.getBallLocation()-1.65),3)/1.65, -0.7-TURN_SPEED*Math.pow((Robot.pixy.getBallLocation()-1.65),2)/1.65);
      }else{
        drive.tankDrive(-0.7-TURN_SPEED*Math.pow((1.65-Robot.pixy.getBallLocation()),3)/1.65, -0.7+TURN_SPEED*Math.pow((1.65-Robot.pixy.getBallLocation()),2)/1.65);
      }
    }
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
