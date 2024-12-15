package org.firstinspires.ftc.teamcode.CommandGroups;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.IntakeArmSetState;
import org.firstinspires.ftc.teamcode.Commands.IntakeClawSetAngle;
import org.firstinspires.ftc.teamcode.Commands.IntakeClawSetState;
import org.firstinspires.ftc.teamcode.Commands.LinearIntakeSetPosition;
import org.firstinspires.ftc.teamcode.Commands.ScoringArmSetState;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeArm;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeClaw;

public class Intake extends SequentialCommandGroup {
    public Intake(double trigger){
        addCommands(
                new LinearIntakeSetPosition(trigger),
                new IntakeArmSetState(IntakeArm.State.COLLECT),
                new IntakeClawSetState(IntakeClaw.State.OPEN),
                new IntakeClawSetAngle(0),
                new IntakeArmSetState(IntakeArm.State.IN),
                new LinearIntakeSetPosition(0)

        );
    }
}
