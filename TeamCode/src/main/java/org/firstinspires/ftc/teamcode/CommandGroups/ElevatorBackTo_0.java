package org.firstinspires.ftc.teamcode.CommandGroups;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ScoringArmSetState;
import org.firstinspires.ftc.teamcode.Commands.ScoringClawSetState;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.PID.MMPIDCommand;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringArm;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringClaw;

public class ElevatorBackTo_0 extends SequentialCommandGroup {

    public ElevatorBackTo_0() {
        super(
                new ScoringClawSetState(ScoringClaw.State.OPEN),
                new ScoringArmSetState(ScoringArm.State.IN),
                new WaitCommand(300),
                new MMPIDCommand(MMRobot.getInstance().mmSystems.elevator, 10),
                new WaitCommand(100),
                new MMPIDCommand(MMRobot.getInstance().mmSystems.elevator, 1)
        );
        addRequirements(
                MMRobot.getInstance().mmSystems.elevator,
                MMRobot.getInstance().mmSystems.scoringArm,
                MMRobot.getInstance().mmSystems.scoringClaw
        );

    }
}
