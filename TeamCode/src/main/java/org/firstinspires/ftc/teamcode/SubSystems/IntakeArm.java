package org.firstinspires.ftc.teamcode.SubSystems;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleServo;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class IntakeArm extends SubsystemBase {

    CuttleServo intakeArmRight;
    CuttleServo intakeArmLeft;
    public static final double prepareSampleIntakePose = 0.45;
    public static final double intakeSamplePose = 0.33;
    public static final double intakeSpecimenPose = 0.63; //not checked
    public static final double transferPose = 1 ;


    public IntakeArm() {
        intakeArmRight = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.INTAKEARM_RIGHT);
        intakeArmLeft = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.INTAKEARM_LEFT);
    }

    public Command setState(double position) {
        return new InstantCommand(() -> {
            intakeArmRight.setPosition(position);
            intakeArmLeft.setPosition(1 - position);
        },
                this);
    }


        public double getPosition () {
            return intakeArmRight.getPosition();
        }

    }
