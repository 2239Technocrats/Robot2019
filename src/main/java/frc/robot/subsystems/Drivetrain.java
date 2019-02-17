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
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
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

  public boolean mode = true;
  public double speed = .75;

  public WPI_TalonSRX leftMotorM;
  public WPI_VictorSPX leftMotorS;
  public WPI_TalonSRX rightMotorM;
  public WPI_VictorSPX rightMotorS;
  public WPI_TalonSRX leftLift;
  public WPI_TalonSRX rightLift;
  public SpeedControllerGroup left;
  public SpeedControllerGroup right;
  public SpeedControllerGroup lift;
  public DifferentialDrive drive;


  // Drivetrain public objects
  public Drivetrain () {
    leftMotorM = new WPI_TalonSRX(1);
    leftMotorS = new WPI_VictorSPX(2);
    rightMotorM = new WPI_TalonSRX(3);
    rightMotorS = new WPI_VictorSPX(4);
    leftLift = new WPI_TalonSRX(5);
    rightLift = new WPI_TalonSRX(6);
    leftMotorM.setExpiration(0.5);
    leftMotorS.setExpiration(0.5);
    rightMotorM.setExpiration(0.5);
    rightMotorS.setExpiration(0.5);
    leftLift.setExpiration(0.5);
    rightLift.setExpiration(0.5);
    left = new SpeedControllerGroup(leftMotorM, leftMotorS);
    right = new SpeedControllerGroup(rightMotorM, rightMotorS);
    lift = new SpeedControllerGroup(leftLift, rightLift);
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

  public void setMode(boolean mode){
    this.mode = mode;
  }

  public void setSpeed(double speed){
    this.speed = speed;
  }

  public double getSpeed(){
    return speed;
  }
}
