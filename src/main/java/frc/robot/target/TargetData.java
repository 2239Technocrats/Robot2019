package frc.robot.target;

public class TargetData{

    public TargetData(){}

    //The Width of the targetting box
    public float width;

    //The horizontal offset of the center point of the camera to the center of the target box
    public float horizontalOffset;
    
    //The difference of (difference of bottom of vision tape and bottom of targetting box) for each target
    public float parralax;
}
