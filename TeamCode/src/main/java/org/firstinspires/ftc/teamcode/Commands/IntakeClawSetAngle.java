package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.MMRobot;

public class IntakeClawSetAngle extends InstantCommand {
    public IntakeClawSetAngle(double position){
        super(()-> MMRobot.getInstance().mmSystems.intakeClaw.setAngle(position));

    }

}
