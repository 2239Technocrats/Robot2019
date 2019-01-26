package frc.robot.subsystems;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.commands.TurnToBall;
import edu.wpi.first.wpilibj.SerialPort;

public class Arduino extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    SerialPort ArduinoPort;
    int[] location = {0, 0};
    // Drivetrain public objects
    public Arduino() {
        ArduinoPort = new SerialPort(115200, Port.kUSB);
        ArduinoPort.setReadBufferSize(3);
    }

    public int[] getBallLocation() {
        if (ArduinoPort.getBytesReceived() >= 30) {
            byte[] blockArray = ArduinoPort.read(3);
            if (blockArray[0] == 1) {
                location[0] = (int)blockArray[1];
                location[1] = (int)blockArray[2];
                System.out.println((int)blockArray[1]);
                System.out.println((int)blockArray[2]);
            }
        }
        return location;
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TurnToBall());
    }
}
