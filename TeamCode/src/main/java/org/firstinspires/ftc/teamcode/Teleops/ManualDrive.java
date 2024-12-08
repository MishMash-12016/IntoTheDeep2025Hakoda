package org.firstinspires.ftc.teamcode.Teleops;

import org.firstinspires.ftc.teamcode.Libraries.MMLib.MMOpMode;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;

public class ManualDrive extends MMOpMode {

    public ManualDrive() {
        super(OpModeType.NonCompetition.EXPERIMENTING_NO_EXPANSION);
    }

    @Override
    public void onInit() {
        MMRobot.getInstance().mmSystems.initDriveTrain();

//        MMRobot.getInstance().mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.Y).whenPressed(
//                new MMPIDCommand(MMRobot.getInstance().mmSystems.arm,MMRobot.getInstance().mmSystems.arm.HIGH_BASKET)
//        );
//
//        MMRobot.getInstance().mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.B).whenPressed(
//                new MMPIDCommand(MMRobot.getInstance().mmSystems.arm,MMRobot.getInstance().mmSystems.arm.LOW_BASCET)
//        );
//
//        MMRobot.getInstance().mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.A).whenPressed(
//                new ScoreAndBackTo_0()
//        );



    }

    @Override
    public void run() {
        super.run();
//        MMRobot.getInstance().mmSystems.expansionHub.pullBulkData();
    }
}
