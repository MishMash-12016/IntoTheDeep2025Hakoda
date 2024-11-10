package org.firstinspires.ftc.teamcode.Teleops;

import com.arcrobotics.ftclib.geometry.Pose2d;
import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.MMOpMode;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.Utils.MMPinPoint;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;

import java.util.Locale;
@TeleOp
public class PinPointTest extends MMOpMode {
    public PinPointTest() {
        super(OpModeType.NonCompetition.EXPERIMENTING_NO_EXPANSION);
    }

    public MMPinPoint localizer; // Declare OpMode member for the Odometry Computer
    double oldTime = 0;


    @Override
    public void onInit() {


        localizer = hardwareMap.get(MMPinPoint.class,"localizer");

        localizer.setOffsets(-84.0, -168.0); //these are tuned for 3110-0002-0001 Product Insight #1

        localizer.setEncoderResolution(MMPinPoint.GoBildaOdometryPods.goBILDA_SWINGARM_POD);

        localizer.setEncoderDirections(MMPinPoint.EncoderDirection.REVERSED, MMPinPoint.EncoderDirection.FORWARD);

        localizer.resetPosAndIMU();

    }

    @Override
    public void run() {
        super.run();
        localizer.update();
        Pose2d pos = localizer.getPosition();

        String data = String.format(Locale.US, "{X: %.3f, Y: %.3f, H: %.3f}", pos.getX(), pos.getY(), Math.toDegrees(pos.getHeading()));
        telemetry.addData("Position", data);


        telemetry.update();

    }
}
