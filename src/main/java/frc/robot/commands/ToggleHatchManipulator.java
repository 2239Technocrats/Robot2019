package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.target.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
//Opens and closes the hatch
public class ToggleHatchManipulator extends Command
{
    public final int FINISHED_WIDTH = 230;
    public final int OFFSET_TOLERANCE = 5;

    public ToggleHatchManipulator(){
        requires(Robot.hatchManipulator);
    }
    
    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
        boolean state = Robot.hatchManipulator.getState();
        Robot.hatchManipulator.setState(!state);
        SmartDashboard.putBoolean("execute on ToggleHatchManipulator, state: ", Robot.hatchManipulator.getState());
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}