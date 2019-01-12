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
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.subsystems.Drivetrain;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  XboxController testXbox = new XboxController(0);
  Joystick testJoystick = new Joystick(1);
  JoystickButton b1 = new JoystickButton(testXbox, 1);
  JoystickButton b2 = new JoystickButton(testXbox, 2);
  JoystickButton b3 = new JoystickButton(testXbox, 3);
  JoystickButton b4 = new JoystickButton(testXbox, 4);
  JoystickButton b5 = new JoystickButton(testXbox, 5);
  JoystickButton b6 = new JoystickButton(testXbox, 6);
  JoystickButton b7 = new JoystickButton(testXbox, 7);
  JoystickButton b8 = new JoystickButton(testXbox, 8);
  JoystickButton b9 = new JoystickButton(testXbox, 9);
  JoystickButton b10 = new JoystickButton(testXbox, 10);
  JoystickButton b11 = new JoystickButton(testXbox, 11);
  JoystickButton b12 = new JoystickButton(testXbox, 12);
  MecanumDrive drive;
  public OI (Drivetrain drivetrain) {
    drive = drivetrain.getDrive();
    new MDrive();
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
