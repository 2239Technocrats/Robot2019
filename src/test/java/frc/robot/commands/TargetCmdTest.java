// package frc.robot.commands;

// import static org.junit.Assert.*;

// import org.junit.Before;
// import org.junit.Test;

// import frc.robot.target.*;

// public class TargetCmdTest {

//     private TargetCmd cmd;
//     private MockSource source;

//     @Before
//     public void setUp() {
//         source = new MockSource();
//         cmd = new TargetCmd(source, null) {
//             protected int getFinishedWidth() {
//                 return 200;
//             }

//             protected int getOffsetTolerance() {
//                 return 0;
//             }
        
//         };
//     }

//     @Test
//     public void testGetAlignVelocityOffset() {
//         float result = cmd.getAlignVelocityOffset(new TargetData());
//         assertEquals("computed offset", 0.6f, result, 0.01);
//     }

// }
