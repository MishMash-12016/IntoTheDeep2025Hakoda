package org.firstinspires.ftc.teamcode.Teleops;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Libraries.MMLib.MMOpMode;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;
@TeleOp
public class ManualDrive extends MMOpMode {

    public ManualDrive() {
        super(OpModeType.NonCompetition.EXPERIMENTING_NO_EXPANSION);
    }

    @Override
    public void onInit() {
        MMRobot.getInstance().mmSystems.initDriveTrain();
        MMRobot.getInstance().mmSystems.initIntakeClaw();


    }

    @Override
    public void run() {
        super.run();
//        MMRobot.getInstance().mmSystems.expansionHub.pullBulkData();
        MMRobot.getInstance().mmSystems.intakeClaw.setAngle(gamepad1.left_trigger);
        telemetry.addData("meow",MMRobot.getInstance().mmSystems.intakeClaw.angleClaw.getPosition());
        telemetry.update();
    }
}
