package org.firstinspires.ftc.teamcode.CommandGroup;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ClawSetState;
import org.firstinspires.ftc.teamcode.Commands.RollerByPower;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.PID.MMPIDCommand;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.Claw;

public class ScoreAndBackTo_0 extends SequentialCommandGroup{

    public ScoreAndBackTo_0(){
        super(
                new ClawSetState(Claw.State.OPEN),
                new RollerByPower(-0.5),
                new WaitCommand(400),
                new MMPIDCommand(MMRobot.getInstance().mmSystems.arm,0),
                new RollerByPower(0)
        );
        addRequirements(
                MMRobot.getInstance().mmSystems.arm,
                MMRobot.getInstance().mmSystems.roller,
                MMRobot.getInstance().mmSystems.claw
        );
    }
}
