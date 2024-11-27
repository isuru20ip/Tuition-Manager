package modal.beans;

import java.io.Serializable;
import java.util.LinkedList;

public class LogData implements Serializable{

    /**
     * @return the logList
     */
    public LinkedList<String[]> getLogList() {
        return logList;
    }

    /**
     * @param logList the logList to set
     */
    public void setLogList(LinkedList<String[]> logList) {
        this.logList = logList;
    }

    public LogData() {
    }

    public LogData(LinkedList<String[]> logList) {
        this.logList = logList;
    }
    
    private LinkedList<String[]> logList;
}
