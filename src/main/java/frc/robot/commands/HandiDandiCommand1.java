package frc.robot.commands;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class HandiDandiCommand1 extends CommandGroup{

    private final static double UNDECIDED = 1.0;


    public HandiDandiCommand1(){
        addSequential(new ToggleHatchManipulator());
        addSequential(new TimeDrive(.1, 1.0));
        addSequential(new TurnAround(UNDECIDED, .8));
    }



}