package frc.robot.subsystems;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.commands.TurnToBall;
import edu.wpi.first.wpilibj.SPI;
import java.lang.Thread;
import java.util.Arrays;

public class Pixy extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private static final byte[] request = {(byte)0xc1,(byte)0xae,(byte)22,(byte)2,(byte)1,(byte)1};
    SPI PixyPort;
    int[] location = {0, 0};
    // Drivetrain public objects
    public Pixy() {
        PixyPort = new SPI(Port.kMXP);
        PixyPort.setMSBFirst();
    }

    public int[] getBallLocation() throws InterruptedException {
        //send request to pixy
        PixyPort.write(request, 6);
        Thread.sleep(20);
        //receive response
        byte[] dataReceived = new byte[18];
        PixyPort.read(false, dataReceived, 18);
        byte[] x = Arrays.copyOfRange(dataReceived,7,9);
        byte[] y = Arrays.copyOfRange(dataReceived,9,11);
        int[] parsedData = {(((int)x[0] << 8)|((int)x[1] & 0xFF)),(((int)y[0] << 8)|((int)y[1] & 0xFF))};
        return parsedData;
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TurnToBall());
    }
}
