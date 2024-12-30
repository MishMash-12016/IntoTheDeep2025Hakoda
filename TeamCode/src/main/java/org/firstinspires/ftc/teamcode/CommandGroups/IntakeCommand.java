package org.firstinspires.ftc.teamcode.CommandGroups;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.IntakeClawSetState;
import org.firstinspires.ftc.teamcode.Commands.IntakeRotatorSetState;
import org.firstinspires.ftc.teamcode.Commands.LinearIntakeSetPosition;
import org.firstinspires.ftc.teamcode.Commands.ScoringArmSetState;
import org.firstinspires.ftc.teamcode.Commands.ScoringClawSetState;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.Elevator;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeArm;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeClaw;
import org.firstinspires.ftc.teamcode.SubSystems.LinearIntake;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringArm;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringClaw;

import java.util.function.DoubleSupplier;

public class IntakeCommand extends SequentialCommandGroup {
    public static Command PrepareIntakeCommand(DoubleSupplier trigger) {
        return new SequentialCommandGroup(
                new LinearIntakeSetPosition(trigger.getAsDouble()),
                MMRobot.getInstance().mmSystems.intakeArm.setState(IntakeArm.prepareSampleIntakePose),
                new IntakeClawSetState(IntakeClaw.State.OPEN),
                new IntakeRotatorSetState(IntakeClaw.anglesampletransfer)
        );
    }
    public static Command IntakeCommand(){
        return new SequentialCommandGroup(
                MMRobot.getInstance().mmSystems.intakeArm.setState(IntakeArm.intakeSamplePose),
                new IntakeClawSetState(IntakeClaw.State.CLOSE),
                new WaitCommand(500),
                new LinearIntakeSetPosition(LinearIntake.closedpose),
                new IntakeRotatorSetState(IntakeClaw.anglesampletransfer),
                MMRobot.getInstance().mmSystems.intakeArm.setState(IntakeArm.transferPose)
                );
    }
    public static Command TransferCommand(){
        return new SequentialCommandGroup(
                MMRobot.getInstance().mmSystems.intakeArm.setState(IntakeArm.transferPose),
                new WaitCommand(200),
                new LinearIntakeSetPosition(LinearIntake.closedpose),
                MMRobot.getInstance().mmSystems.elevator.moveToPose(Elevator.elevatorDown),
                new ScoringArmSetState(ScoringArm.State.IN),
                new ScoringClawSetState(ScoringClaw.State.OPEN),
                new WaitCommand(200),
                new ScoringClawSetState(ScoringClaw.State.CLOSE),
                new IntakeClawSetState(IntakeClaw.State.OPEN)
        );
    }
    public static Command PrepareIntakeSpecimen(){
        return new SequentialCommandGroup(
                MMRobot.getInstance().mmSystems.intakeArm.setState(IntakeArm.intakeSpecimenPose),
                MMRobot.getInstance().mmSystems.intakeClaw.setAnglePosition(IntakeClaw.angleintakeSpeciman),
                new IntakeClawSetState(IntakeClaw.State.OPEN)
        );
    }
    public static Command IntakeSpecimen(){
        return new SequentialCommandGroup(
                new IntakeClawSetState(IntakeClaw.State.CLOSE),
                new WaitCommand(500),
                MMRobot.getInstance().mmSystems.intakeClaw.setAnglePosition(IntakeClaw.anglespecimantransfer),
                MMRobot.getInstance().mmSystems.intakeArm.setState(IntakeArm.transferPose)
        );
    }
}
