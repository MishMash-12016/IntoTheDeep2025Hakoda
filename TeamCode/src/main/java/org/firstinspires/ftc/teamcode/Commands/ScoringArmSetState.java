package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeClaw;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringArm;

public class ScoringArmSetState extends InstantCommand {
    public ScoringArmSetState(ScoringArm.State state){
        super(()-> MMRobot.getInstance().mmSystems.scoringArm.setState(state.position));

    }
}
