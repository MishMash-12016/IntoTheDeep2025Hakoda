package org.firstinspires.ftc.teamcode.Teleops;

import org.firstinspires.ftc.teamcode.Libraries.MMLib.MMOpMode;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;

public class ManualDrive extends MMOpMode {

    public ManualDrive() {
        super(OpModeType.NonCompetition.EXPERIMENTING_NO_EXPANSION);
    }

    @Override
    public void onInit() {
        MMRobot.getInstance().mmSystems.initDriveTrain();



    }

    @Override
    public void run() {
        super.run();
//        MMRobot.getInstance().mmSystems.expansionHub.pullBulkData();
    }
}
