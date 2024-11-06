package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Libraries.MMLib.DriveTrain.Commands.ResetFieldOrientedCommand;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.MMOpMode;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;


@TeleOp
public class TeleopDrive extends MMOpMode {

    MMRobot robot = MMRobot.getInstance();

    public TeleopDrive(){
        super(OpModeType.NonCompetition.EXPERIMENTING);

    }

    @Override
    public void onInit() {
        MMRobot.getInstance().mmSystems.initDriveTrain();


        Trigger leftTriggerCondition = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx1.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.05
        );

        MMRobot.getInstance().mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(
                new ResetFieldOrientedCommand()
        );


    }

    @Override
    public void run() {
        super.run();
        MMRobot.getInstance().mmSystems.expansionHub.pullBulkData();
        telemetry.addData("imu: ", MMRobot.getInstance().mmSystems.imu.getYawInDegrees());
        telemetry.update();

    }

}