
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public abstract class TargetCmd extends Command
{
    int targetWidth();
    int 
    
    public TargetCmd(){

    }

    @Override 
    protected void initialize(){

    }

    @Override
    protected void execute(){

    }

    @Override
    protected boolean isFinished(){
        return getTargetWidth() == getFinishedWidth();
    }

    protected double getTargetWidth(){
        return tx.getDouble;
    }

    protected abstract int getFinishedWidth();

    

}