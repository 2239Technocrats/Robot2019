
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.OI;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * An example command.  You can replace me with your own command.
 */
public class TDrive extends Command {
    DifferentialDrive drive;
    XboxController controller;
    Joystick joystick;
    boolean flipped;
    public double speed = Robot.drivetrain.speed;
  public TDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      drive = Robot.drivetrain.getDrive();
      controller = Robot.oi.getXboxController();
      joystick = Robot.oi.getJoystick();
      flipped = Robot.drivetrain.isFlipped();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    speed = Robot.drivetrain.speed;
    System.out.println(speed);
    // System.out.println("execute(); on tankdrive");
    if (Robot.drivetrain.mode){
      drive.tankDrive(-1*controller.getRawAxis(1)*speed, -1*controller.getRawAxis(5)*speed, false);
    } else {
      if (Robot.drivetrain.controller == 0){
        if(flipped){
          drive.arcadeDrive(-1*controller.getRawAxis(1)*speed, -1*controller.getRawAxis(0)*speed, false);
        }
        else{
          drive.arcadeDrive(controller.getRawAxis(0)*speed, controller.getRawAxis(1)*speed, false);
        }
      } else{
        if(flipped){
          drive.arcadeDrive(-1*controller.getRawAxis(1)*speed, controller.getRawAxis(4)*speed, false);
        }
        else{
          drive.arcadeDrive(controller.getRawAxis(1)*speed, -1*controller.getRawAxis(4)*speed, false);
        }
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
