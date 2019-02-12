// package frc.robot.commands;

// import edu.wpi.first.wpilibj.Solenoid;
// import edu.wpi.first.wpilibj.SolenoidBase;
// import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.subsystems.Pneumatics;
// import frc.robot.Robot;
// public class ToggleClaw extends Command{

//     public ToggleClaw(){
//         requires(Robot.pneumatics);
//     }

//     @Override
//     protected void initialize(){
        
//     }
// /**
//  * if(the solenoid is open){
//  *  close the solenoid();
//  * }else if (the solenoid is closed){
//  *  open the solenoid();
//  * }else{
//  *  System.out.println("something is wrong with the solenoid");
//  * }
//  * 
//  * example of a method
//  * 
//  * object.method(perameters);
//  * or
//  * literallyTheOnlySolenoidCuzOurRobotIsTrash.get();
//  * //returns a boolean value
//  * literallyTheOnlySolenoidCuzOurRobotIsTrash.set(true);
//  * //sets the solenoid  true = open, false = closed
//  * 
//  * 
//  * boolean foo = true;
//  * 
//  * !foo
//  * 
//  * is the same as 
//  * 
//  * foo != true
//  * 
//  * 
//  * if (infiniteCampus.student1.test1.getScorePersectage >= .895){
//  *  infiniteCampus.student1.setGrade('A');
//  *  System.out.println("You got an A");
//  * } else if (infiniteCampus.student1.test1.getScorePersectage >= .795) {
//  *  infiniteCampus.student1.setGrade('B');
//  *  System.out.println("you got a B");
//  * } else {
//  *  System.out.println("you didnt get an acceptable score");
//  * }
//  * 
//  */
//     protected void execute(){
//         if (Robot.pneumatics.getSolenoid(0).get()/*if it is open*/){
//             Robot.pneumatics.getSolenain(0).setSolenoid(false);   

//         }else if(){

//         }else{

//         }
//     }

//     @Override
//     protected boolean isFinished(){
//         return true;
//     }
    
//     @Override
//     protected void end() {

//     }

//     @Override
//     protected void interrupted() {
        
//     }
// }