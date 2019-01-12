/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.Drivetrain;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  XboxController testXbox = new XboxController(0);
  Joystick testJoystick = new Joystick(1);
  JoystickButton testButton1 = new JoystickButton(testJoystick, 1);
  JoystickButton testButton2 = new JoystickButton(testJoystick, 2);
  JoystickButton testButton3 = new JoystickButton(testJoystick, 3);
  JoystickButton testButton4 = new JoystickButton(testJoystick, 4);
  JoystickButton testButton5 = new JoystickButton(testJoystick, 5);
  DifferentialDrive drive;
  public OI (Drivetrain drivetrain) {
    testButton2.whenPressed(new MoveLiftMotor(-1.0));
    testButton2.whenReleased(new StopLiftMotor());
    testButton3.whenPressed(new MoveLiftMotor(1.0));
    testButton3.whenReleased(new StopLiftMotor());
    testButton5.whenPressed(new InvertGrabber());
    testButton4.whenPressed(new TestDriveChain(0.1));
    testButton4.whenReleased(new TestDriveChain(0));
    drive = drivetrain.getDrive();
  }

  public XboxController getXboxController(){
    return testXbox;
  }

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);
 
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());
  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
