package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class setBMHeight extends Command{

    private int position;
    private boolean finished;

    public setBMHeight(int position){
        this.position = position;
    }

    @Override
    protected void initialize(){

    }

    @Override
    protected void execute() {
        super.execute();
    }

    @Override
    protected boolean isFinished(){
        return finished;
    }
}