package org.firstinspires.ftc.teamcode.Libraries.MMLib.DriveTrain;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Libraries.MMLib.DriveTrain.Commands.ResetFieldOrientedCommand;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.MMTeleOp;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;

/**
 * this class is all you need to run field-oriented drive.
 * <p>
 * <b>IMPORTANT:</b>
 * <p>
 * don't forget to change the ports at {@link org.firstinspires.ftc.teamcode.Utils.Configuration Configuration},
 * <p>
 * and reverse the motors at {@link org.firstinspires.ftc.teamcode.Libraries.MMLib.DriveTrain.Subsystem.MMDriveTrain MMDriveTrain}.
 */
@Disabled
@TeleOp
public class DriveTeleopExample extends MMTeleOp {
    public DriveTeleopExample() {
        super(OpModeType.NonCompetition.EXPERIMENTING_NO_EXPANSION);
    }

    @Override
    public void onInit() {
        MMRobot.getInstance().mmSystems.initDriveTrain();

        //you can also add a reset button:
        MMRobot.getInstance().mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.A).whenPressed(
                new ResetFieldOrientedCommand()
        );
    }
}
