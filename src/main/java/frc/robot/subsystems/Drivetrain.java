/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
// Subsystem system
import edu.wpi.first.wpilibj.command.Subsystem;
// Motor controller
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX frontLeftMotor;
  WPI_TalonSRX backLeftMotor;
  WPI_TalonSRX frontRightMotor;
  WPI_TalonSRX backRightMotor; 
  MecanumDrive drive;

  // Drivetrain public objects
  public Drivetrain () {
    frontLeftMotor = new WPI_TalonSRX(1);
    backLeftMotor = new WPI_TalonSRX(2);
    frontRightMotor = new WPI_TalonSRX(3);
    backRightMotor = new WPI_TalonSRX(4);
    drive = new MecanumDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
  }

  public MecanumDrive getDrive() {
      return drive;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

}
