/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// Subsystem system
import edu.wpi.first.wpilibj.command.Subsystem;
// Robot's compreser
import edu.wpi.first.wpilibj.Compressor;
// Motor controller
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// Solenoids
import edu.wpi.first.wpilibj.Solenoid;

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
  Compressor compressor;
  Solenoid grabber;
  // moves the lift motor
  public void moveLiftMotor(double amount) {
      lift.set(amount);
  }
  // initalizes compressor
  public void initalizeCompressor() {
    compressor.start();
    compressor.setClosedLoopControl(true);
  }
  // move grabber
  public void setGrabber(boolean state) {
      grabber.set(state);
  }
  // get grabber state
  public boolean getGrabber() {
      return grabber.get();
  }

  public void driveForwardLeft(double amount) {
      leftLeaderMotor.set(amount);
      leftFollowerMotor1.set(amount);
      leftFollowerMotor2.set(amount);
  }

  public void driveForwardRight(double amount) {
    rightLeaderMotor.set(amount);
    rightFollowerMotor1.set(amount);
    rightFollowerMotor2.set(amount);
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
    compressor = new Compressor();
    grabber = new Solenoid(14, 2);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
