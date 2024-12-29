package org.firstinspires.ftc.teamcode.Teleops;

import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.CommandGroups.IntakeCommand;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.MMOpMode;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;

@TeleOp
public class ScoringTeleOP extends MMOpMode {
    public ScoringTeleOP() {
        super(OpModeType.NonCompetition.EXPERIMENTING);
    }
    @Override
    public void onInit() {
        MMRobot.getInstance().mmSystems.initScoringArm();
        MMRobot.getInstance().mmSystems.initScoringClaw();

        Trigger lefttrigger = new Trigger(
                ()-> MMRobot.getInstance().mmSystems.gamepadEx1.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)> 0.05
        );
        lefttrigger.whenActive(
                IntakeCommand.PrepareIntakeCommand(()-> gamepad1.left_trigger)
        );

    }

    @Override
    public void run() {
        super.run();
    }
}

