package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.target.*;

public class HatchAlignBay extends HatchAlign
{
    public final int FINISHED_WIDTH = 230;
    public final int OFFSET_TOLERANCE = 5;

    
    public HatchAlignBay(TargetSource targetSource, Drivetrain drivetrain){
        super(targetSource, drivetrain);
    }
}