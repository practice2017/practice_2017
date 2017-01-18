/**
 * Created by knnas on 18.01.2017.
 */
public class DataResult {

    private InitialData dt;
    private String inCorrectString;

    public DataResult(InitialData dt, String inCorrectString)
    {
        setInitialData(dt);
        setinCorrectString(inCorrectString);
    }

    public void setInitialData(InitialData dt)
    {
        this.dt = dt;
    }

    public void setinCorrectString(String inCorrectString)
    {
        this.inCorrectString = inCorrectString;
    }

    public InitialData getInitialData()
    {
        return dt;
    }

    public String getInCorrectString()
    {
        return inCorrectString;
    }
}
