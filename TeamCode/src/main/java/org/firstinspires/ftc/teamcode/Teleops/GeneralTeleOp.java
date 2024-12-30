package org.firstinspires.ftc.teamcode.Teleops;

import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.CommandGroups.IntakeCommand;
import org.firstinspires.ftc.teamcode.CommandGroups.ScoringCommand;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.MMOpMode;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.Elevator;
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
        MMRobot.getInstance().mmSystems.initElevator();
        MMRobot.getInstance().mmSystems.initScoringClaw();
        MMRobot.getInstance().mmSystems.initScoringArm();

        Trigger leftTrigger = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx1.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.05
        );
        Trigger rightTrigger = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx1.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.05
        );
        Trigger leftTrigger2 = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx2.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.05
        );
        Trigger rightTrigger2 = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx2.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.05
        );
        Trigger dpadright = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx1.getButton(GamepadKeys.Button.DPAD_RIGHT)
        );
        Trigger dpadleft = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx1.getButton(GamepadKeys.Button.DPAD_LEFT)
        );
        Trigger intakeCondition = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx1.getButton(GamepadKeys.Button.X)
        );
        Trigger ybutton = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx1.getButton(GamepadKeys.Button.Y)
        );
        Trigger abutton = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx1.getButton(GamepadKeys.Button.A)
        );
        Trigger bbutton = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx1.getButton(GamepadKeys.Button.B)
        );
        Trigger rightBumper = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx1.getButton(GamepadKeys.Button.RIGHT_BUMPER)
        );
        Trigger leftBumper = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx1.getButton(GamepadKeys.Button.LEFT_BUMPER)
        );
        Trigger dpadup2 = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx2.getButton(GamepadKeys.Button.DPAD_UP)
        );
        Trigger dpaddown2 = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx2.getButton(GamepadKeys.Button.DPAD_DOWN)
        );
        Trigger dpadleft2 = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx2.getButton(GamepadKeys.Button.DPAD_LEFT)
        );
        Trigger aButton2 = new Trigger(
                () -> MMRobot.getInstance().mmSystems.gamepadEx2.getButton(GamepadKeys.Button.A)
        );
//        leftTrigger.whileActiveOnce(
//                IntakeCommand.PrepareIntakeCommand(() -> gamepad1.left_trigger)
//        );
//        dpadright.whenActive(
//                MMRobot.getInstance().mmSystems.intakeClaw.setAnglePosition(IntakeClaw.angleintakeright)
//        );
//        dpadleft.whenActive(
//                MMRobot.getInstance().mmSystems.intakeClaw.setAnglePosition(IntakeClaw.angleintakeleft)
//        );
//        intakeCondition.whenActive(
//                IntakeCommand.IntakeCommand() // button x
//        );
        dpadleft.whenActive(
            MMRobot.getInstance().mmSystems.linearIntake.settestPosition()
        );
//        ybutton.whenActive(
//                ScoringCommand.PrepareHighSampleCommand()
//        );
//        abutton.whenActive(
//                ScoringCommand.PrepareLowSampleCommand()
//       );
//        bbutton.whenActive(
//                ScoringCommand.PrepareScoreSpecimenCommand()
//        );
//        rightTrigger.whenActive(
//                ScoringCommand.ScoreSampleCommand()
//        );
//        rightBumper.whenActive(
//                ScoringCommand.ScoreSpecimenCommand()
//        );
//        dpadup2.whenActive(
//                IntakeCommand.PrepareIntakeSpecimen()
//        );
//        dpaddown2.whenActive(
//                IntakeCommand.IntakeSpecimen()
//        );
//           aButton2.whenActive(
//                ScoringCommand.PrepareScoreSpecimenCommand()
//        );
//        rightTrigger2.whenActive(
//                ScoringCommand.ScoreSpecimenCommand()
//        );
//        dpadleft2.whenActive(()->
//                MMRobot.getInstance().mmSystems.imu.resetYaw());


    }

    @Override
    public void run() {
        super.run();
        MMRobot.getInstance().mmSystems.expansionHub.pullBulkData();
        telemetry.addData("joystick:",MMRobot.getInstance().mmSystems.gamepadEx1.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER));
        telemetry.addData("current pose",MMRobot.getInstance().mmSystems.linearIntake.getPosition());
        telemetry.update();
    }
}

