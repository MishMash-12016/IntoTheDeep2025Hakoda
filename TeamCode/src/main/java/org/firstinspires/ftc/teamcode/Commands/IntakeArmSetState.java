package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeArm;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeClaw;

public class IntakeArmSetState extends InstantCommand {
    public IntakeArmSetState(IntakeArm.State state){
        super(
                ()-> MMRobot.getInstance().mmSystems.intakeArm.setState(state.getPosition()),
                MMRobot.getInstance().mmSystems.intakeArm
        );
    }
}
