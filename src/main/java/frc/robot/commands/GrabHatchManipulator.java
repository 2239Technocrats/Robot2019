package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.target.*;
import edu.wpi.first.wpilibj.command.*;
import frc.robot.Robot;

public class GrabHatchManipulator extends Command
{
    public final int FINISHED_WIDTH = 230;
    public final int OFFSET_TOLERANCE = 5;

    public GrabHatchManipulator(){
        requires(Robot.hatchManipulator);
    }
    
    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
        Robot.hatchManipulator.setState(true);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}