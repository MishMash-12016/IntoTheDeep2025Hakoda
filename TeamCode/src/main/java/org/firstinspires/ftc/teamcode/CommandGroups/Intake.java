package org.firstinspires.ftc.teamcode.CommandGroups;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.ParallelDeadlineGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.button.Trigger;

import org.firstinspires.ftc.teamcode.Commands.IntakeArmSetState;
import org.firstinspires.ftc.teamcode.Commands.IntakeClawSetAngle;
import org.firstinspires.ftc.teamcode.Commands.IntakeClawSetState;
import org.firstinspires.ftc.teamcode.Commands.LinearIntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.LinearIntakeSetPosition;
import org.firstinspires.ftc.teamcode.Commands.ScoringArmSetState;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeArm;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeClaw;

public class Intake extends ParallelDeadlineGroup {

    public Intake(Trigger trigger) {
        super(
                new LinearIntakeCommand(trigger),
                new IntakeArmSetState(IntakeArm.State.COLLECT),
                new IntakeClawSetState(IntakeClaw.State.CLOSE)
        );
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        CommandScheduler.getInstance().schedule(
                new IntakeArmSetState(IntakeArm.State.IN),
                new LinearIntakeSetPosition(0)
        );
    }
}
