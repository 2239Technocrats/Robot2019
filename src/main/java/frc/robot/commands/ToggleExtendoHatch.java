package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.target.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
//Extends and retracts the hatch
public class ToggleExtendoHatch extends Command
{

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
        SmartDashboard.putBoolean("execute on ToggleExtendoHatch, state: ", Robot.extendoHatch.getState());
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}