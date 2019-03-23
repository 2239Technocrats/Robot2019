package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.target.*;
import edu.wpi.first.wpilibj.command.*;
import frc.robot.Robot;

public class ToggleExtendoHatch extends Command
{
    public final int FINISHED_WIDTH = 230;
    public final int OFFSET_TOLERANCE = 5;

    public ToggleExtendoHatch(){
        requires(Robot.extendoHatch);
    }
    
    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
        boolean state = Robot.extendoHatch.getState();
        Robot.extendoHatch.setState(!state);
        System.out.println("execute on ToggleExtendoHatch, state: " + Robot.extendoHatch.getState());
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}