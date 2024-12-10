package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringClaw;

public class ClawSetState extends InstantCommand {

    public ClawSetState(ScoringClaw.State state){
        super(()-> MMRobot.getInstance().mmSystems.scoringClaw.setState(state.position));
    }

}
