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
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.buttons.POVButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  private final static int GROUND_POSITION = 0;
  private final static int ROCKET_POSITION = 1;
  private final static int CARGO_POSITION = 2;


  XboxController controller = new XboxController(0);
  Joystick testJoystick = new Joystick(1);
  JoystickButton b1 = new JoystickButton(controller, 1);
  JoystickButton b2 = new JoystickButton(controller, 2);
  JoystickButton b3 = new JoystickButton(controller, 3);
  JoystickButton b4 = new JoystickButton(controller, 4);
  JoystickButton b5 = new JoystickButton(controller, 5);
  JoystickButton b6 = new JoystickButton(controller, 6);
  JoystickButton b7 = new JoystickButton(controller, 7);
  JoystickButton b8 = new JoystickButton(controller, 8);
  JoystickButton b9 = new JoystickButton(controller, 9);
  JoystickButton b10 = new JoystickButton(controller, 10);
  JoystickButton b11 = new JoystickButton(controller, 11);
  JoystickButton b12 = new JoystickButton(controller, 12);
  JoystickButton j1 = new JoystickButton(testJoystick, 1);
  JoystickButton j2 = new JoystickButton(testJoystick, 2);
  JoystickButton j3 = new JoystickButton(testJoystick, 3);
  JoystickButton j4 = new JoystickButton(testJoystick, 4);
  JoystickButton j5 = new JoystickButton(testJoystick, 5);
  JoystickButton j6 = new JoystickButton(testJoystick, 6);
  JoystickButton j7 = new JoystickButton(testJoystick, 7);
  JoystickButton j8 = new JoystickButton(testJoystick, 8);
  JoystickButton j9 = new JoystickButton(testJoystick, 9);
  JoystickButton j10 = new JoystickButton(testJoystick, 10);
  JoystickButton j11 = new JoystickButton(testJoystick, 11);
  JoystickButton j12 = new JoystickButton(testJoystick, 12);
  POVButton up = new POVButton(controller, 0);
  POVButton upLeft = new POVButton(controller, 45);
  POVButton left = new POVButton(controller, 90);
  POVButton downLeft = new POVButton(controller, 135);
  POVButton down = new POVButton(controller, 180);
  POVButton downRight = new POVButton(controller, 225);
  POVButton right = new POVButton(controller, 270);
  POVButton upRight = new POVButton(controller, 315);

  POVButton up2 = new POVButton(testJoystick, 0);
  POVButton uL2 = new POVButton(testJoystick, 45);
  POVButton left2 = new POVButton(testJoystick, 90);
  POVButton dL2 = new POVButton(testJoystick, 135);
  POVButton down2 = new POVButton(testJoystick, 180);
  POVButton dR2 = new POVButton(testJoystick, 225);
  POVButton right2 = new POVButton(testJoystick, 270);
  POVButton uR2 = new POVButton(testJoystick, 315);

  DifferentialDrive drive;
  public int speed;
  public OI (Drivetrain drivetrain) {
    drive = drivetrain.getDrive();
    b1.whileHeld(new TurnToBall());
    b2.whileHeld(new DriveToHatch());
    b5.whenPressed(new ToggleHatchManipulator());
    b6.whenPressed(new ToggleHatchManipulator());
    b7.whenPressed(new ToggleDrivingMode());
    b8.whenPressed(new ToggleDrivingMode());

    j1.whileHeld(new BallWheels(1));
    j2.whileHeld(new BallWheels(-1));

    // j3.whenPressed(new setBMHeight(GROUND_POSITION));
    // j4.whenPressed(new setBMHeight(CARGO_POSITION));
    // j5.whenPressed(new setBMHeight(ROCKET_POSITION));

    j3.whileHeld(new SetBMSpeed(testJoystick.getRawAxis(1)));

    //speed controls
    up.whenPressed(new SetDriveSpeed(1.0));
    left.whenPressed(new SetDriveSpeed(.75));
    down.whenPressed(new SetDriveSpeed(.5));
    right.whenPressed(new SetDriveSpeed(.25));

  }

  public XboxController getXboxController(){
    return controller;
  }

  public Joystick getJoystick(){
    return testJoystick;
  }

  public int getSpeed(){
    return speed;
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