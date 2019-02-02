
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.target.TargetData;
import frc.robot.target.TargetSource;

public abstract class TargetCmd extends Command
{
    /**
     *
     */

    public final double speed = 0.7;

    private TargetSource targetSource;
    private Drivetrain drivetrain;
    
    public TargetCmd(TargetSource targetSource, Drivetrain drivetrain){
        this.targetSource = targetSource;
        this.drivetrain = drivetrain;
    }

    @Override 
    protected void initialize(){

    }

    @Override
    protected void execute(){
        TargetData targetData = targetSource.getTargetData();
        float velocityOffset = getTargetVelocityOffset(targetData);
        velocityOffset += getAlignVelocityOffset(targetData);
        
        if(velocityOffset < 0) {
            drivetrain.drive(Drivetrain.MAX_VELOCITY * -velocityOffset, Drivetrain.MAX_VELOCITY);
        } else {
            drivetrain.drive(Drivetrain.MAX_VELOCITY, Drivetrain.MAX_VELOCITY * velocityOffset);
        }
    }

    @Override
    protected boolean isFinished(){
        TargetData data = targetSource.getTargetData();
        return data.width >= getFinishedWidth()
            && data.horizontalOffset > (-1 * getOffsetTolerance())
            && data.horizontalOffset < getOffsetTolerance();
    }

    protected abstract int getFinishedWidth();

    protected abstract int getOffsetTolerance();

    /**
     * returns the amount that is going to be subtracted from the overall speed to get horOff to 0
     * negative if turning left, positive if turning right
     */
    protected float getAlignVelocityOffset(TargetData data){
        return data.horizontalOffset;
    }

    protected float getTargetVelocityOffset(TargetData data) {
        return data.horizontalOffset;
    }

}