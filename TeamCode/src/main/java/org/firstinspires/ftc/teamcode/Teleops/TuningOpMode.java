package org.firstinspires.ftc.teamcode.Teleops;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Libraries.MMLib.Examples.TeleOps.Comp.MMTeleOp;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.PID.MMPIDCommand;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;

public class TuningOpMode extends MMTeleOp {
    public TuningOpMode() {
        super(OpModeType.NonCompetition.EXPERIMENTING_NO_EXPANSION);
    }

    @Override
    public void onInit() {

        MMRobot.getInstance().mmSystems.initDriveTrain();

        MMRobot.getInstance().mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.Y).whenPressed(
                new MMPIDCommand(MMRobot.getInstance().mmSystems.arm,30)
        );

        MMRobot.getInstance().mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.B).whenPressed(
                new MMPIDCommand(MMRobot.getInstance().mmSystems.arm,15)
        );

    }



    @Override
    public void run() {
        super.run();

        MMRobot.getInstance().mmSystems.roller.setSpeed(gamepad1.right_trigger);
        MMRobot.getInstance().mmSystems.roller.setAngleRoller(gamepad1.left_trigger);

        MMRobot.getInstance().mmSystems.claw.setPosition(gamepad1.left_trigger);
    }
}
