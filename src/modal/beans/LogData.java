package modal.beans;

import java.io.Serializable;
import java.util.Vector;

public class LogData implements Serializable{

    /**
     * @return the v
     */
    public Vector<String> getV() {
        return v;
    }

    /**
     * @param v the v to set
     */
    public void setV(Vector<String> v) {
        this.v = v;
    }

    public LogData() {
    }

    public LogData(Vector<String> v) {
        this.v = v;
    }
    
    
    
    private Vector<String> v;
}
