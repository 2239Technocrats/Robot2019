/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
// Subsystem system
import edu.wpi.first.wpilibj.command.Subsystem;
// Motor controller
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.VelocityTalon;
// Commands
import frc.robot.commands.TDrive;
/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  public static final float MAX_VELOCITY = 1;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  VelocityTalon leftMotor1;
  VelocityTalon leftMotor2;
  VelocityTalon rightMotor1;
  VelocityTalon rightMotor2;
  SpeedControllerGroup left;
  SpeedControllerGroup right;
  DifferentialDrive drive;

  // Drivetrain public objects
  public Drivetrain () {
    leftMotor1 = new VelocityTalon(1);
    leftMotor2 = new VelocityTalon(2);
    rightMotor1 = new VelocityTalon(3);
    rightMotor2 = new VelocityTalon(4);
    leftMotor1.setExpiration(0.5);
    leftMotor2.setExpiration(0.5);
    rightMotor1.setExpiration(0.5);
    rightMotor2.setExpiration(0.5);
    left = new SpeedControllerGroup(leftMotor1, leftMotor2);
    right = new SpeedControllerGroup(rightMotor1, rightMotor2);
    drive = new DifferentialDrive(left, right);
    
  }

  public DifferentialDrive getDrive() {
      return drive;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new TDrive());
  }

  public void drive(float left, float right) {
    System.out.println(String.format("Left: %d\tRight: %d", left, right));
  }

}
