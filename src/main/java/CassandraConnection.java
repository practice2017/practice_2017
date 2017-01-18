import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * Created by knnas on 18.01.2017.
 */


public class CassandraConnection {

    public static void insertDataToBD(InitialData dt, Session session)
    {
        String cmdInsert = "INSERT INTO practice_2017.practicetable" +
                "(pspaynum, account, errcode, errtext, flags, indate, instatus, parentpayid, payamount, paytype, servcode, servtype, termid, totalpayamount)" +
                "VALUES('"
                + dt.psPayNum +
                "', '" + dt.account +
                "', '" + dt.errCode +
                "', '" + dt.errText +
                "', '" + dt.flags +
                "', '" + dt.inDate +
                "', '" + dt.inStatus +
                "', '" + dt.parentPayId +
                "', '" + dt.payAmount +
                "', '" + dt.payType +
                "', '" + dt.servCode +
                "', '" + dt.servType +
                "', '" + dt.termId +
                "', '" + dt.totalPayAmount +
                "')";
        session.execute(cmdInsert);
    }

}
