package org.firstinspires.ftc.teamcode.Teleops;

import com.arcrobotics.ftclib.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Libraries.MMLib.MMOpMode;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;

import java.util.Locale;

@TeleOp
public class ManualDrive extends MMOpMode {

    public ManualDrive() {
        super(OpModeType.NonCompetition.EXPERIMENTING);
    }

    @Override
    public void onInit() {
        MMRobot.getInstance().mmSystems.initDriveTrain();

    }

    @Override
    public void run() {
        super.run();
        MMRobot.getInstance().mmSystems.driveTrain.localizer.update();
        telemetry.addData("heading",
                Math.toDegrees(MMRobot.getInstance().mmSystems.driveTrain.localizer.getHeading())
        );

        telemetry.update();
    }
}
