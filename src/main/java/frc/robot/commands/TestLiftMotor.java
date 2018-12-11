/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.sql.Driver;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class TestLiftMotor extends Command {
  public TestLiftMotor() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);
  }
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("initialize(); on TestLiftMotor");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("execute(); on TestLiftMotor");
    Robot.drivetrain.moveLiftMotor(-1.0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    System.out.println("isFinished(); on TestLiftMotor");
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
