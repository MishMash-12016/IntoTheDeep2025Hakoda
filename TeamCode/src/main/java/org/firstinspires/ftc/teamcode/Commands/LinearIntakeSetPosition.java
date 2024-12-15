package org.firstinspires.ftc.teamcode.Commands;

import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeClaw;
import org.firstinspires.ftc.teamcode.SubSystems.LinearIntake;

public class LinearIntakeSetPosition {
    public LinearIntakeSetPosition(double position){
        super(()-> MMRobot.getInstance().mmSystems.linearIntake.getPosition(position));
    }
}

//good code!!! - by eyal
