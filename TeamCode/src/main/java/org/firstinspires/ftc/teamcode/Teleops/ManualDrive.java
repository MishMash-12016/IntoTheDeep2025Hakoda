package org.firstinspires.ftc.teamcode.Teleops;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.command.button.Trigger;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.CommandGroups.Intake;
import org.firstinspires.ftc.teamcode.CommandGroups.Scoring;
import org.firstinspires.ftc.teamcode.Commands.IntakeArmSetState;
import org.firstinspires.ftc.teamcode.Commands.LinearIntakeSetPosition;
import org.firstinspires.ftc.teamcode.Commands.ScoringArmSetState;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.MMOpMode;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeArm;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringArm;
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
//        MMRobot.getInstance().mmSystems.initIntakeArm();
//        MMRobot.getInstance().mmSystems.initIntakeClaw();
//        MMRobot.getInstance().mmSystems.initLinearIntake();
        MMRobot.getInstance().mmSystems.initElevator();
        MMRobot.getInstance().mmSystems.initScoringArm();
        MMRobot.getInstance().mmSystems.initScoringClaw();

        addCommandsOnRun(
//                new LinearIntakeSetPosition(0),
//                new IntakeArmSetState(IntakeArm.State.IN),
                new ScoringArmSetState(ScoringArm.State.IN)
        );

        MMRobot.getInstance().mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.A).whenPressed(
                new ScoringArmSetState(ScoringArm.State.IN)
        );

        MMRobot.getInstance().mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.B).whenPressed(
                new ScoringArmSetState(ScoringArm.State.MIDD)
        );

        MMRobot.getInstance().mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.X).whenPressed(
                new ScoringArmSetState(ScoringArm.State.SCORING)
        );

        MMRobot.getInstance().mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.Y).whenPressed(
                new Scoring(30)
        );

    }

    @Override
    public void run() {
        super.run();


        telemetry.addData("pos",MMRobot.getInstance().mmSystems.scoringArm.getPosition());
        MMRobot.getInstance().mmSystems.driveTrain.localizer.update();
        MMRobot.getInstance().mmSystems.expansionHub.pullBulkData();
        telemetry.update();
    }







}
