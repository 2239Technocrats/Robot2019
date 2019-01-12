
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.OI;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * An example command.  You can replace me with your own command.
 */
public class MDrive extends Command {
    MecanumDrive drive;
    XboxController testXbox;
  public MDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      drive = Robot.drivetrain.getDrive();
      testXbox = Robot.oi.getXboxController();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("execute(); on tankdrive");
    drive.driveCartesian(testXbox.getRawAxis(1), testXbox.getRawAxis(0), testXbox.getRawAxis(4));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    System.out.println("isFinished(); on exampleCommand");
    return true;
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
