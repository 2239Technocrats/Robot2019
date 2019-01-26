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
// Commands
import frc.robot.commands.TDrive;
/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  public static final float MAX_VELOCITY = 1;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX leftMotor1;
  WPI_TalonSRX leftMotor2;
  WPI_TalonSRX leftMotor3;
  WPI_TalonSRX rightMotor1;
  WPI_TalonSRX rightMotor2; 
  WPI_TalonSRX rightMotor3;
  SpeedControllerGroup left;
  SpeedControllerGroup right;
  DifferentialDrive drive;

  // Drivetrain public objects
  public Drivetrain () {
    leftMotor1 = new WPI_TalonSRX(1);
    leftMotor2 = new WPI_TalonSRX(2);
    leftMotor3 = new WPI_TalonSRX(3);
    rightMotor1 = new WPI_TalonSRX(4);
    rightMotor2 = new WPI_TalonSRX(5);
    rightMotor3 = new WPI_TalonSRX(6);
    leftMotor1.setExpiration(0.5);
    leftMotor2.setExpiration(0.5);
    leftMotor3.setExpiration(0.5);
    rightMotor1.setExpiration(0.5);
    rightMotor2.setExpiration(0.5);
    rightMotor3.setExpiration(0.5);
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
