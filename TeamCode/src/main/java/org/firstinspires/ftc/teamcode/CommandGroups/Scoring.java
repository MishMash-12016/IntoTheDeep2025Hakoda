package org.firstinspires.ftc.teamcode.CommandGroups;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.ScoringArmSetState;
import org.firstinspires.ftc.teamcode.Commands.ScoringClawSetState;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.PID.MMPIDCommand;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.Elevator;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringArm;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringClaw;

public class Scoring extends SequentialCommandGroup {
    public Scoring(double high){
        addCommands(
        new ScoringClawSetState(ScoringClaw.State.CLOSE),
        new MMPIDCommand(MMRobot.getInstance().mmSystems.elevator, high),
        new ScoringArmSetState(ScoringArm.State.SCORING)
        );
    }
}
