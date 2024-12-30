package org.firstinspires.ftc.teamcode.SubSystems;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleServo;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class IntakeClaw extends SubsystemBase {

    public enum State {
        CLOSE(0), OPEN(0.7);
        public double position;

        State(double position){
            this.position = position;
        }
    }
    public static final double angleintake = 0;
    public static final double anglespecimantransfer = 0;
    public static final double anglesampletransfer = 0.5;
    public static final double angleintakeSpeciman = 0.5;

    public static final double angleintakeright = 0.8; //
    public static final double angleintakeleft = 0.2;

    public CuttleServo angleIntake;
    public CuttleServo claw;

    public IntakeClaw(){
        angleIntake = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.ANGLE_INTAKE_CLAW);
        claw = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub,Configuration.INTAKE_CLAW);
    }

    public void setState(double position){
        claw.setPosition(position);
    }

    public Command setAnglePosition(double anglepose){
        return new InstantCommand( ()-> {
                angleIntake.setPosition(anglepose);},
            this);

    }
    public double getAnglePosition() {
        return angleIntake.getPosition();
    }

}
