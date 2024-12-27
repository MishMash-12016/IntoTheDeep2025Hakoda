package org.firstinspires.ftc.teamcode.Autonomous;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.IntakeArmSetState;
import org.firstinspires.ftc.teamcode.Commands.IntakeClawSetAngle;
import org.firstinspires.ftc.teamcode.Commands.IntakeClawSetState;
import org.firstinspires.ftc.teamcode.Commands.LinearIntakeSetPosition;
import org.firstinspires.ftc.teamcode.Commands.ScoringArmSetState;
import org.firstinspires.ftc.teamcode.Commands.ScoringClawSetState;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.MMOpMode;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.PID.MMPIDCommand;
import org.firstinspires.ftc.teamcode.Libraries.RoadRunner.ActionCommand;
import org.firstinspires.ftc.teamcode.Libraries.RoadRunner.MecanumDrive;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeArm;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeClaw;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringArm;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringClaw;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;

import java.util.Collections;

public class CloseRed extends MMOpMode {
    MMRobot robotInstance;
    public CloseRed(){
        super(OpModeType.NonCompetition.EXPERIMENTING);
    }

    @Override
    public void onInit() {
        MMRobot.getInstance().mmSystems.initDriveTrain();


        Pose2d StartPose = (new Pose2d(-15, -60, Math.toRadians(-90)));
        MecanumDrive drive = new MecanumDrive(hardwareMap, StartPose);

        TrajectoryActionBuilder ScorePreloadSpecimen = drive.actionBuilder(StartPose)
                 .setTangent(Math.toRadians(90))
                 .splineToConstantHeading(new Vector2d(-6,-35), Math.toRadians(90));
        TrajectoryActionBuilder CollectSample = ScorePreloadSpecimen.endTrajectory().fresh()
                .setTangent(Math.toRadians(180))
                .splineToSplineHeading(new Pose2d(new Vector2d(-60,-50),Math.toRadians(60)), Math.toRadians(180));
        TrajectoryActionBuilder ScoreSample = CollectSample.endTrajectory().fresh()
                .turn(Math.toRadians(190));
        TrajectoryActionBuilder CollectSecondSample = ScoreSample.endTrajectory().fresh()
                 .splineToSplineHeading(new Pose2d(-54.00, -55.21, Math.toRadians(50.00)),Math.toRadians(78.60));
        TrajectoryActionBuilder PickUpThirdSample =
                 CollectSecondSample.endTrajectory().fresh();

        new SequentialCommandGroup(
                new ScoringClawSetState(ScoringClaw.State.CLOSE),
                new ActionCommand(ScorePreloadSpecimen.build(), Collections.emptySet()),
                new WaitCommand(2000),
                new MMPIDCommand(MMRobot.getInstance().mmSystems.elevator,47),
                new WaitCommand(2000),
                new ScoringArmSetState(ScoringArm.State.SCORING),        //TODO: find correct position for Specimen
                new WaitCommand(2000),
                new MMPIDCommand(MMRobot.getInstance().mmSystems.elevator,0),
                new WaitCommand(2000),
                new ScoringArmSetState(ScoringArm.State.IN),
                new WaitCommand(2000),
                new ActionCommand(CollectSample.build(), Collections.emptySet()),
                new WaitCommand(2000),
                new LinearIntakeSetPosition(0.7),
                new WaitCommand(2000),
                new IntakeArmSetState(IntakeArm.State.COLLECT),
                new WaitCommand(2000),
                new IntakeClawSetState(IntakeClaw.State.OPEN),
                new WaitCommand(2000),
                new IntakeClawSetAngle(0.2),                       //TODO: find correct position for sample (60 degrees)
                new WaitCommand(2000),
                new IntakeClawSetState(IntakeClaw.State.CLOSE),
                new WaitCommand(2000),
                new IntakeClawSetAngle(0),
                new WaitCommand(2000),
                new IntakeArmSetState(IntakeArm.State.IN),
                new WaitCommand(2000),
                new ScoringClawSetState(ScoringClaw.State.OPEN),
                new WaitCommand(2000),
                new LinearIntakeSetPosition(0),
                new WaitCommand(2000),
                new ScoringClawSetState(ScoringClaw.State.CLOSE),
                new WaitCommand(2000),
                new ActionCommand(ScoreSample.build(), Collections.emptySet()),
                new WaitCommand(2000),
                new MMPIDCommand(MMRobot.getInstance().mmSystems.elevator,70),
                new WaitCommand(2000),
                new ScoringArmSetState(ScoringArm.State.SCORING),
                new WaitCommand(2000),
                new ScoringClawSetState(ScoringClaw.State.OPEN),
                new WaitCommand(2000),
                new ScoringArmSetState(ScoringArm.State.IN),
                new WaitCommand(2000),
                new MMPIDCommand(MMRobot.getInstance().mmSystems.elevator,0)
        );

    }
}