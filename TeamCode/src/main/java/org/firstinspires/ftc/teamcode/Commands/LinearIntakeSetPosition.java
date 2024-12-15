package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeClaw;
import org.firstinspires.ftc.teamcode.SubSystems.LinearIntake;

public class LinearIntakeSetPosition extends InstantCommand {
    public LinearIntakeSetPosition(double position){
        super(()-> MMRobot.getInstance().mmSystems.linearIntake.setPosition(position));
    }
}


//good code!!! - by eyal
