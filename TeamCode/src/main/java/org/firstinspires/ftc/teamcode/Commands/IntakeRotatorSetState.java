package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.MMRobot;

public class IntakeRotatorSetState extends InstantCommand {
    public IntakeRotatorSetState(double angleintake) {
    }

    public static Command IntakeRotatorSetState(double state){
           return MMRobot.getInstance().mmSystems.intakeClaw.setAnglePosition(state);
        }
}
