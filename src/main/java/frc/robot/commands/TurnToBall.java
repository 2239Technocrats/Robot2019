
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.XboxController;

/**
 * An example command.  You can replace me with your own command.
 */
public class TurnToBall extends Command {
    /**
   *
   */

  private static final double PIXY_MIDPOINT = 1.65;
  /**
  *
  */

  private static final double BASE_FORWARD_POWER = 0.7;
  public static final double TURN_SPEED = 0.1;
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
  protected void execute() {
    System.out.println(Robot.pixy.getBallLocation()+"  ,  "+Robot.pixy.isDetected());
    if (Robot.pixy.isDetected()) {
      double distanceFromMidpoint;
      double turnPower;
      double location = Robot.pixy.getBallLocation();


      distanceFromMidpoint = Robot.pixy.getBallLocation()-PIXY_MIDPOINT;
      turnPower = TURN_SPEED*Math.pow(distanceFromMidpoint,3)/PIXY_MIDPOINT;
      System.out.println(distanceFromMidpoint);
      System.out.println(turnPower);
      //drive.tankDrive(-BASE_FORWARD_POWER-turnPower, 
      //                 -BASE_FORWARD_POWER+turnPower);
      //511drive.tankDrive(0, 0);
      System.out.println(String.format("Location: %f\tOffset: %f\tTurn Power: %f", Robot.pixy.getBallLocation(), distanceFromMidpoint, turnPower));
    } else {
      System.out.println("Ball not detected");
    }
  }

  private boolean isBallOnRight(double x) {
    return x > PIXY_MIDPOINT;
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
