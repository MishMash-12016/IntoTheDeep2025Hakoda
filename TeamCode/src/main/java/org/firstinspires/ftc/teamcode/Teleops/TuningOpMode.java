package org.firstinspires.ftc.teamcode.Teleops;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Libraries.MMLib.MMOpMode;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;
@TeleOp
public class TuningOpMode extends MMOpMode {
    public TuningOpMode() {
        super(OpModeType.NonCompetition.EXPERIMENTING_NO_EXPANSION);
    }

    @Override
    public void onInit() {

        MMRobot.getInstance().mmSystems.initDriveTrain();
        MMRobot.getInstance().mmSystems.initIntakeClaw();
        MMRobot.getInstance().mmSystems.initLinearIntake();
        MMRobot.getInstance().mmSystems.initScoringClaw();
        MMRobot.getInstance().mmSystems.initIntakeArm();
        MMRobot.getInstance().mmSystems.initScoringArm();


    }



    @Override
    public void run() {
        super.run();
        MMRobot.getInstance().mmSystems.intakeClaw.claw.setPosition(Math.abs(gamepad1.left_trigger));
        telemetry.update();
    }
}
