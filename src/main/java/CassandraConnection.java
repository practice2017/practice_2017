import com.datastax.driver.core.*;

/**
 * Created by knnas on 18.01.2017.
 */


public class CassandraConnection {

    public static PreparedStatement preparedSt(Session session) {
        PreparedStatement prepared = session.prepare(
                "INSERT INTO practice_2017.practicetable (" +
                        "pspaynum, " +
                        "account, " +
                        "errcode, " +
                        "errtext, " +
                        "flags, " +
                        "indate, " +
                        "instatus, " +
                        "parentpayid, " +
                        "payamount, " +
                        "paytype, " +
                        "servcode, " +
                        "servtype, " +
                        "termid, " +
                        "totalpayamount" +
                        ") values (?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?) if not exists");
        return prepared;
    }

    public static void insertDataToBD(Session session, PreparedStatement prepared, InitialData dt)
    {
        session.execute(prepared.bind(dt.psPayNum, dt.account, dt.errCode, dt.errText, dt.flags, dt.inDate,
                dt.inStatus, dt.parentPayId, dt.payAmount, dt.payType, dt.servCode, dt.servType, dt.termId, dt.totalPayAmount));
    }


}
