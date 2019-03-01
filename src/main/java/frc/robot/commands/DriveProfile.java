/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motion.*;
import frc.robot.Robot;
import frc.robot.Constants;

public class DriveProfile extends Command {

  TalonSRXConfiguration config = new TalonSRXConfiguration();
  BufferedTrajectoryPointStream pointStream = new BufferedTrajectoryPointStream();

  public DriveProfile() {
    requires(Robot.drivetrain);
    /* fill our buffer object with the excel points */
    initBuffer(MotionProfile.Points, MotionProfile.kNumPoints);

    /* _config the master specific settings */
    config.primaryPID.selectedFeedbackSensor = FeedbackDevice.QuadEncoder;
    config.neutralDeadband = Constants.kNeutralDeadband; /* 0.1 % super small for best low-speed control */
    config.slot0.kF = Constants.kGains_MotProf.kF;
    config.slot0.kP = Constants.kGains_MotProf.kP;
    config.slot0.kI = Constants.kGains_MotProf.kI;
    config.slot0.kD = Constants.kGains_MotProf.kD;
    config.slot0.integralZone = (int) Constants.kGains_MotProf.kIzone;
    config.slot0.closedLoopPeakOutput = Constants.kGains_MotProf.kPeakOutput;
    // _config.slot0.allowableClosedloopError // left default for this example
    // _config.slot0.maxIntegralAccumulator; // left default for this example
    // _config.slot0.closedLoopPeriod; // left default for this example
    _master.configAllSettings(_config);

    /* pick the sensor phase and desired direction */
    _master.setSensorPhase(true);
    _master.setInverted(false);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
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

  private void initBuffer(double[][] profile, int totalCnt) {

    boolean forward = true; // set to false to drive in opposite direction of profile (not really needed
                            // since you can use negative numbers in profile).

    TrajectoryPoint point = new TrajectoryPoint(); // temp for for loop, since unused params are initialized
                                                   // automatically, you can alloc just one

    /* clear the buffer, in case it was used elsewhere */
    pointStream.Clear();

    /* Insert every point into buffer, no limit on size */
    for (int i = 0; i < totalCnt; ++i) {

        double direction = forward ? +1 : -1;
        double positionRot = profile[i][0];
        double velocityRPM = profile[i][1];
        int durationMilliseconds = (int) profile[i][2];

        /* for each point, fill our structure and pass it to API */
        point.timeDur = durationMilliseconds;
        point.position = direction * positionRot * Constants.kSensorUnitsPerRotation; // Convert Revolutions to
                                                                                      // Units
        point.velocity = direction * velocityRPM * Constants.kSensorUnitsPerRotation / 600.0; // Convert RPM to
                                                                                              // Units/100ms
        point.auxiliaryPos = 0;
        point.auxiliaryVel = 0;
        point.profileSlotSelect0 = Constants.kPrimaryPIDSlot; /* which set of gains would you like to use [0,3]? */
        point.profileSlotSelect1 = 0; /* auxiliary PID [0,1], leave zero */
        point.zeroPos = (i == 0); /* set this to true on the first point */
        point.isLastPoint = ((i + 1) == totalCnt); /* set this to true on the last point */
        point.arbFeedFwd = 0; /* you can add a constant offset to add to PID[0] output here */

        pointStream.Write(point);
    }
}
}
