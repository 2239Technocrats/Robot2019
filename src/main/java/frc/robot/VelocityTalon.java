package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class VelocityTalon extends WPI_TalonSRX{
    public VelocityTalon(int id){
        super(id);
    }

    @Override
    public void set(double value){
        super.set(ControlMode.Velocity, value);
    }

    /**
     * 
     * @param velocity the velocity 
     */
    public void vSet(double velocity){

    }
}