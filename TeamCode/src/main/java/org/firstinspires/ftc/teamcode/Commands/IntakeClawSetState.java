package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeClaw;

public class IntakeClawSetState extends InstantCommand {

    public IntakeClawSetState(IntakeClaw.State state){
        super(()-> MMRobot.getInstance().mmSystems.intakeClaw.setState(state.position));

    }
}
