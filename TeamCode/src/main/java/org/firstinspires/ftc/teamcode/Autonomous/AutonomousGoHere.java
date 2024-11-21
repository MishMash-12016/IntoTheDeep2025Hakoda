package org.firstinspires.ftc.teamcode.Autonomous;
import org.firstinspires.ftc.teamcode.MMRobot;

@Config
@Autonomous(name = "BLUE_TEST", group = "Autonomous")
public class AutonomousGoHere extends LinearOpmode{
    @Override
    public void runOpMode() {
        TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
                .lineToYSplineHeading(33, Math.toRadians(0))
                .waitSeconds(2);
    }
}
