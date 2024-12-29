package org.firstinspires.ftc.teamcode.CommandGroups;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.IntakeClawSetState;
import org.firstinspires.ftc.teamcode.Commands.IntakeRotatorSetState;
import org.firstinspires.ftc.teamcode.Commands.LinearIntakeSetPosition;
import org.firstinspires.ftc.teamcode.Commands.ScoringArmSetState;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeArm;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeClaw;
import org.firstinspires.ftc.teamcode.SubSystems.LinearIntake;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringArm;

import java.util.function.DoubleSupplier;

public class IntakeCommand extends SequentialCommandGroup {
    public static Command PrepareIntakeCommand(DoubleSupplier trigger) {
        return new ParallelCommandGroup(
                new LinearIntakeSetPosition(trigger.getAsDouble()),
                MMRobot.getInstance().mmSystems.intakeArm.setState(IntakeArm.PREPAREINTAKE),
                new IntakeClawSetState(IntakeClaw.State.OPEN),
                new IntakeRotatorSetState(IntakeClaw.angleintake)
        );
    }
    public static Command IntakeCommand(){
        return new SequentialCommandGroup(
                MMRobot.getInstance().mmSystems.intakeArm.setState(IntakeArm.COLLECT),
                new IntakeClawSetState(IntakeClaw.State.CLOSE),
                new WaitCommand(500),
                new LinearIntakeSetPosition(LinearIntake.closedpose),
                new IntakeRotatorSetState(IntakeClaw.angleintake),
                MMRobot.getInstance().mmSystems.intakeArm.setState(IntakeArm.IN)
                );

    }
    public static Command IntakeSpecimen(){
        return new SequentialCommandGroup(
                new ScoringArmSetState(ScoringArm.State.SCORINGSPECIMEN)
        )
    }
}
