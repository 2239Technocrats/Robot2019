package frc.robot.commands;

import frc.robot.target.*;
import frc.robot.subsystems.Drivetrain;
/**
 * aligns to the hatch panel on the rocket
 */
public class HatchAlignRocket extends HatchAlign{

    public final int FINISHED_WIDTH = 220;
    public final int OFFSET_TOLERANCE = 5;

    
    public HatchAlignRocket(TargetSource targetSource, Drivetrain drivetrain){
        super(targetSource, drivetrain);
    }
        
    
}