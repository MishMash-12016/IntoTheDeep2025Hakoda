package org.firstinspires.ftc.teamcode.Teleops;

import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.CommandGroups.IntakeCommand;
import org.firstinspires.ftc.teamcode.CommandGroups.ScoringCommand;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.MMOpMode;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeClaw;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;

@TeleOp
public class GeneralTeleOp extends MMOpMode {
    public GeneralTeleOp() {
        super(OpModeType.NonCompetition.EXPERIMENTING);
    }
    @Override
    public void onInit() {
        MMRobot.getInstance().mmSystems.initIntakeClaw();
        MMRobot.getInstance().mmSystems.initIntakeArm();
        MMRobot.getInstance().mmSystems.initLinearIntake();

        Trigger leftTrigger = new Trigger(
                ()-> MMRobot.getInstance().mmSystems.gamepadEx1.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)> 0.05
        );
        Trigger dpadright= new Trigger(
                ()-> MMRobot.getInstance().mmSystems.gamepadEx1.getButton(GamepadKeys.Button.DPAD_RIGHT)
        );
        Trigger dpadleft= new Trigger(
                ()-> MMRobot.getInstance().mmSystems.gamepadEx1.getButton(GamepadKeys.Button.DPAD_LEFT)
        );
        Trigger intakeCondition= new Trigger(
                ()-> MMRobot.getInstance().mmSystems.gamepadEx1.getButton(GamepadKeys.Button.X)
        );
        Trigger ybutton = new Trigger(
                ()-> MMRobot.getInstance().mmSystems.gamepadEx1.getButton(GamepadKeys.Button.Y)
        );
        Trigger abutton = new Trigger(
                ()-> MMRobot.getInstance().mmSystems.gamepadEx1.getButton(GamepadKeys.Button.A)
        );
        leftTrigger.whileActiveOnce(
                IntakeCommand.PrepareIntakeCommand(()-> gamepad1.left_trigger)
       );
        dpadright.whenActive(
                MMRobot.getInstance().mmSystems.intakeClaw.setAnglePosition(IntakeClaw.angleintakeright)
        );
        dpadleft.whenActive(
                MMRobot.getInstance().mmSystems.intakeClaw.setAnglePosition(IntakeClaw.angleintakeleft)
        );
        intakeCondition.whenActive(
                IntakeCommand.IntakeCommand()
        );
        ybutton.whenActive(
                ScoringCommand.PrepareHighSampleCommand()
        );
        abutton.whenActive(
                ScoringCommand.PrepareLowSampleCommand()
        );

    }

    @Override
    public void run() {
    super.run();
    telemetry.addData("joystickl pose: ",MMRobot.getInstance().mmSystems.gamepadEx1.getButton(GamepadKeys.Button.RIGHT_STICK_BUTTON));
    }
    }

