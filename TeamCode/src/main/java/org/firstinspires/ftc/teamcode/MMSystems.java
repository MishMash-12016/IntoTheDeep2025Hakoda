
package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import org.firstinspires.ftc.teamcode.Commands.DriveCommand;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.DriveTrain.Subsystem.MMDriveTrain;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.Examples.ElevatorPIDExample.ExampleElevator;
import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleRevHub;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.Utils.MMBattery;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.Examples.Subsystems.Shooter;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.Examples.Subsystems.ShooterIntake;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.Examples.Subsystems.ShooterPID;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.Examples.Subsystems.ShooterTurret;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.Utils.MMIMU;
import org.firstinspires.ftc.teamcode.SubSystems.Elevator;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeArm;
import org.firstinspires.ftc.teamcode.SubSystems.IntakeClaw;
import org.firstinspires.ftc.teamcode.SubSystems.LinearIntake;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringArm;
import org.firstinspires.ftc.teamcode.SubSystems.ScoringClaw;
import org.firstinspires.ftc.teamcode.SubSystems.DriveTrain;
import org.firstinspires.ftc.teamcode.Utils.AllianceColor;
import org.firstinspires.ftc.teamcode.Utils.AllianceSide;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;

/**
 * this class should contain all ur robot's attributes and systems
 */
public class MMSystems {

    //Attributes & Hardware
    public OpModeType opModeType;
    public AllianceColor allianceColor;
    public AllianceSide robotSide;
    public HardwareMap hardwareMap;
    public CuttleRevHub controlHub;
    public CuttleRevHub expansionHub;
    public GamepadEx gamepadEx1;
    public GamepadEx gamepadEx2;
    public Telemetry telemetry;
    public MMBattery battery;
    public MMIMU imu;


    //Subsystems
    public MMDriveTrain mmDriveTrain;
    public DriveTrain driveTrain;
    public ScoringClaw scoringClaw;
    public ScoringArm scoringArm;
    public IntakeClaw intakeClaw;
    public IntakeArm intakeArm;
    public LinearIntake linearIntake;
    public Elevator elevator;

    // exemple
    public Shooter shooter;
    public ShooterIntake shooterIntake;
    public ShooterPID shooterPID;
    public ShooterTurret shooterTurret;
    public ExampleElevator exampleElevator;


    public void initDriveTrain() {
        driveTrain = new DriveTrain();
        driveTrain.setDefaultCommand(
                new DriveCommand()
        );
    }

    public void initIntakeClaw(){
        intakeClaw = new IntakeClaw();
    }
    public void initScoringClaw(){
        scoringClaw = new ScoringClaw();
    }
    public void initLinearIntake(){
        linearIntake = new LinearIntake();
    }
    public void initIntakeArm(){
        intakeArm = new IntakeArm();
    }
    public void initScoringArm(){
        scoringArm = new ScoringArm();
    }

    public void initElevator(){
        elevator = new Elevator();
    }

    public void initShooterPID() {
        shooterPID = new ShooterPID();
    }

    public void initExampleElevator() {
        exampleElevator = new ExampleElevator();
    }



    public MMSystems(OpModeType type, HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2, Telemetry telemetry) {
        this.opModeType = type;
        this.hardwareMap = hardwareMap;
        this.controlHub = new CuttleRevHub(hardwareMap, CuttleRevHub.HubTypes.CONTROL_HUB);
        if(type != OpModeType.NonCompetition.EXPERIMENTING_NO_EXPANSION) {
            this.expansionHub = new CuttleRevHub(hardwareMap, "Expansion Hub 1");
        }
        this.gamepadEx1 = new GamepadEx(gamepad1);
        this.gamepadEx2 = new GamepadEx(gamepad2);
        this.telemetry = telemetry;
        this.battery = new MMBattery(hardwareMap);
        this.imu = new MMIMU(hardwareMap);
        CommandScheduler.getInstance().reset(); //reset the scheduler
    }
}
