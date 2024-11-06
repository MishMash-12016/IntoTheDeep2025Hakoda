package org.firstinspires.ftc.teamcode.Libraries.MMLib.Examples.TeleOps.Comp;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.AllianceColor;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;

@Disabled
@TeleOp(name = "MMTeleOpBlue")
public class MMTeleOpBlue extends MMTeleOp {

    public MMTeleOpBlue() {
        super(OpModeType.NonCompetition.EXPERIMENTING);
    }

    @Override
    public void onInit() {
        addRunnableOnInit(
                () -> MMRobot.getInstance().mmSystems.shooterPID.setPower(0.5)
        );

        addCommandsOnRun(
                new InstantCommand(
                        () -> MMRobot.getInstance().mmSystems.shooterPID.stop()
                )
        );
    }

}
