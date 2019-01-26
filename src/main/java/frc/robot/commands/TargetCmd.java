
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.target.TargetData;
import frc.robot.target.TargetSource;

public abstract class TargetCmd extends Command
{
    /**
     *
     */

    
    private TargetSource targetSource;
    
    public TargetCmd(TargetSource targetSource){
        this.targetSource = targetSource;
    }

    @Override 
    protected void initialize(){

    }

    @Override
    protected void execute(){
        if()
        drivetrain.left.
    }

    @Override
    protected boolean isFinished(){
        TargetData data = targetSource.getTargetData();
        return data.width == getFinishedWidth() 
            && data.horOff > (-1 * getOffsetTolerance())
            && data.horOff < getOffsetTolerance();
    }


    protected abstract int getFinishedWidth();

    protected abstract int getOffsetTolerance();

    /**
     * returns the 
     */
    protected double getAlignOffset(){
        
    }

}