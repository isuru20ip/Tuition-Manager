/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal.beans;

/**
 *
 * @author LenovoTLC
 */
public class ClassDay {
    private String ClassID;
    private String day;
    private String time;

    public ClassDay() {
    }

    public ClassDay(String ClassID, String day, String time) {
        this.ClassID = ClassID;
        this.day = day;
        this.time = time;
    }

    
    
    
    /**
     * @return the ClassID
     */
    public String getClassID() {
        return ClassID;
    }

    /**
     * @param ClassID the ClassID to set
     */
    public void setClassID(String ClassID) {
        this.ClassID = ClassID;
    }

    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }
}
