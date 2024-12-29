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
import org.firstinspires.ftc.teamcode.SubSystems.ScoringArm;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringClaw;

public class ScoringCommand extends SequentialCommandGroup {
    public static Command PrepareHighSampleCommand(){
        return new ParallelCommandGroup(
        MMRobot.getInstance().mmSystems.elevator.moveToPose(Elevator.HIGH_Basket),
        new ScoringArmSetState(ScoringArm.State.SCORINGHIGH)
        );
    }
    public static Command PrepareLowSampleCommand() {
        return new ParallelCommandGroup(
                MMRobot.getInstance().mmSystems.elevator.moveToPose(Elevator.Low_Basket),
                new ScoringArmSetState(ScoringArm.State.SCORINGLOW)
        );
    }
    public static Command ScoreSampleCommand(){
        return new ParallelCommandGroup(
                new ScoringClawSetState(ScoringClaw.State.OPEN),
                new ScoringArmSetState(ScoringArm.State.IN),
                new WaitCommand(400),
                MMRobot.getInstance().mmSystems.elevator.moveToPose(Elevator.elevatorDown)
        );
    }
    public static Command PrepareScoreSpecimenCommand(){
        return new ParallelCommandGroup(
                MMRobot.getInstance().mmSystems.elevator.moveToPose(Elevator.specimenHIGH),
                new ScoringArmSetState(ScoringArm.State.SCORINGSPECIMEN))
    ;}
    public static Command ScoreSpecimenCommand(){
        return new ParallelCommandGroup(
                MMRobot.getInstance().mmSystems.elevator.moveToPose(Elevator.specimenHIGH-3),
                new WaitCommand(200),
                new ScoringClawSetState(ScoringClaw.State.OPEN),
                new ScoringArmSetState(ScoringArm.State.IN),
                new WaitCommand(400),
                MMRobot.getInstance().mmSystems.elevator.moveToPose(Elevator.elevatorDown)

        );
    }
    }

