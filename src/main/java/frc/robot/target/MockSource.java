package frc.robot.target;

public class MockSource implements TargetSource{

    @Override
    public TargetData getTargetData(){
        return new TargetData();
    }

}