package org.firstinspires.ftc.teamcode.CommandGroups;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ScoringArmSetState;
import org.firstinspires.ftc.teamcode.Commands.ScoringClawSetState;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.PID.MMPIDCommand;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.Elevator;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeArm;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringArm;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringClaw;

public class ScoringCommand extends SequentialCommandGroup {
    public static Command PrepareHighSampleCommand(){
        return new SequentialCommandGroup(
            MMRobot.getInstance().mmSystems.intakeArm.setState(IntakeArm.midtransferpose),
            MMRobot.getInstance().mmSystems.elevator.moveToPose(Elevator.HIGH_Basket),
            new ScoringArmSetState(ScoringArm.State.SCORINGHIGH)
        );
    }
    public static Command PrepareLowSampleCommand() {
        return new SequentialCommandGroup(
                MMRobot.getInstance().mmSystems.intakeArm.setState(IntakeArm.midtransferpose),
                new MMPIDCommand(MMRobot.getInstance().mmSystems.elevator, Elevator.Low_Basket),
                new ScoringArmSetState(ScoringArm.State.SCORINGLOW)
        );
    }
    public static Command ScoreSampleCommand(){
        return new SequentialCommandGroup(
                new ScoringClawSetState(ScoringClaw.State.OPEN),
                new ScoringArmSetState(ScoringArm.State.IN),
                new WaitCommand(400),
                new MMPIDCommand(MMRobot.getInstance().mmSystems.elevator,Elevator.elevatorDown)
        );
    }
    public static Command PrepareScoreSpecimenCommand(){
        return new SequentialCommandGroup(
                new MMPIDCommand(MMRobot.getInstance().mmSystems.elevator, Elevator.specimenHIGH),
                new ScoringArmSetState(ScoringArm.State.SCORINGSPECIMEN))
    ;}
    public static Command ScoreSpecimenCommand(){
        return new SequentialCommandGroup(
                new WaitCommand(200),
                new ScoringClawSetState(ScoringClaw.State.OPEN),
                new ScoringArmSetState(ScoringArm.State.IN),
                new WaitCommand(400),
                MMRobot.getInstance().mmSystems.elevator.moveToPose(Elevator.elevatorDown)

        );
    }
    }

