/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package main.java.frc.robot.commands;

import java.sql.Driver;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class TestDriveChain extends Command {
  double value;
  public TestDriveChain(double amount) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);
    value = amount;
  }
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("initialize(); on TestDriveChain");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("execute(); on TestDriveChain");
    Robot.drivetrain.driveForwardLeft(value);
    Robot.drivetrain.driveForwardRight(value);
  }
   // Called repeatedly when this Command is scheduled to run
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    System.out.println("isFinished(); on TestDriveChain");
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
