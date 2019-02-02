package frc.robot.commands;

import frc.robot.target.*;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.command.*;

public class HatchAlign extends TargetCmd
{

    public final int FINISHED_WIDTH = 230;
    public final int OFFSET_TOLERANCE = 5;

    
    public HatchAlign(TargetSource targetSource, Drivetrain drivetrain){
        super(targetSource, drivetrain);
    }

    @Override
    protected int getFinishedWidth() {
        return FINISHED_WIDTH;
    }

    @Override
    protected int getOffsetTolerance() {
        return OFFSET_TOLERANCE;
    }


}