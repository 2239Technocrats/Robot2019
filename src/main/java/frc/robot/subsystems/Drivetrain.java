/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
// Subsystem system
import edu.wpi.first.wpilibj.command.Subsystem;
// Motor controller
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX leftFollowerMotor2;
  WPI_TalonSRX leftFollowerMotor1;
  WPI_TalonSRX rightFollowerMotor2;
  WPI_TalonSRX rightFollowerMotor1;
  WPI_TalonSRX leftLeaderMotor;
  WPI_TalonSRX rightLeaderMotor;
  WPI_TalonSRX grabberWheelsRight;
  WPI_TalonSRX grabberWheelsLeft;
  WPI_TalonSRX lift;
  DifferentialDrive drive;
  SpeedControllerGroup left;
  SpeedControllerGroup right;
  // moves the lift motor
  public void moveLiftMotor(double amount) {
      lift.set(amount);
  }

  public void driveForwardLeft(double amount) {
      leftLeaderMotor.set(amount);
      leftFollowerMotor1.set(amount);
      leftFollowerMotor2.set(amount);
  }

  public void driveForwardRight(double amount) {
    rightLeaderMotor.set(amount);
    rightFollowerMotor1.set(amount);
}

  // Drivetrain public objects
  public Drivetrain () {
    leftFollowerMotor2 = new WPI_TalonSRX(1);
	leftFollowerMotor1 = new WPI_TalonSRX(5);
	rightFollowerMotor2 = new WPI_TalonSRX(6);
	rightFollowerMotor1 = new WPI_TalonSRX(2);
    leftLeaderMotor = new WPI_TalonSRX(3);
	rightLeaderMotor = new WPI_TalonSRX(4);
	grabberWheelsRight = new WPI_TalonSRX(9);
	grabberWheelsLeft = new WPI_TalonSRX(7);
    lift = new WPI_TalonSRX(10);
    left = new SpeedControllerGroup(leftLeaderMotor, leftFollowerMotor1, leftFollowerMotor2);
    right = new SpeedControllerGroup(rightLeaderMotor, rightFollowerMotor1, rightFollowerMotor2);
    drive = new DifferentialDrive(left, right);
  }

  public DifferentialDrive getDrive() {
      return drive;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

}
