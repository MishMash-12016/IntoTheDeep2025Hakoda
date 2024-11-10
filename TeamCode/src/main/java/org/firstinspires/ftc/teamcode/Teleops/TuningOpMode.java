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
//
//        MMRobot.getInstance().mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.Y).whenPressed(
//                new MMPIDCommand(MMRobot.getInstance().mmSystems.arm,30)
//        );
//
//        MMRobot.getInstance().mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.B).whenPressed(
//                new MMPIDCommand(MMRobot.getInstance().mmSystems.arm,15)
//        );

    }



    @Override
    public void run() {
        super.run();

        telemetry.addData("heading",MMRobot.getInstance().mmSystems.driveTrain.localizer.getPosition().getHeading());
        telemetry.update();
//        MMRobot.getInstance().mmSystems.roller.setSpeed(gamepad1.right_trigger);
//        MMRobot.getInstance().mmSystems.roller.setAngleRoller(gamepad1.left_trigger);
//
//        MMRobot.getInstance().mmSystems.claw.setPosition(gamepad1.left_trigger);
    }
}
