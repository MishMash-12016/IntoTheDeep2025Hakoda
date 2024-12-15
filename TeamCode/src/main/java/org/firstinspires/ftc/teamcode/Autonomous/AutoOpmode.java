package org.firstinspires.ftc.teamcode.Autonomous;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.MMOpMode;
import org.firstinspires.ftc.teamcode.Libraries.RoadRunner.ActionCommand;
import org.firstinspires.ftc.teamcode.Libraries.RoadRunner.PinpointDrive;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;

import java.util.Collections;


@Autonomous
public class AutoOpmode extends MMOpMode {
    Pose2d initialPose = new Pose2d(0,0,0);

    PinpointDrive drive;

    public AutoOpmode() {
        super(OpModeType.NonCompetition.EXPERIMENTING_NO_EXPANSION );
    }


    @Override
    public void onInit() {
        drive = new PinpointDrive(MMRobot.getInstance().mmSystems.hardwareMap, initialPose);

        drive.setDrivePowers(new PoseVelocity2d(new Vector2d(1,0),0));

//        Command test = new ActionCommand( drive.actionBuilder(initialPose)
//                .lineToX(1000).build(), Collections.emptySet());
//        schedule(
//                new SequentialCommandGroup(
//                        test
//                )
//        );
    }
}


