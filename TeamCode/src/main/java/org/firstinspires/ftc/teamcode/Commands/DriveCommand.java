package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.RunCommand;

import org.firstinspires.ftc.teamcode.MMRobot;

public class DriveCommand extends RunCommand {

    public DriveCommand() {
        super(
                () -> MMRobot.getInstance().mmSystems.driveTrain.fieldOrientedDrive(
                        -MMRobot.getInstance().mmSystems.gamepadEx1.getLeftX(),
                        -MMRobot.getInstance().mmSystems.gamepadEx1.getLeftY(),
                        -MMRobot.getInstance().mmSystems.gamepadEx1.getRightX()
                ),
                MMRobot.getInstance().mmSystems.driveTrain
        );
    }
}
