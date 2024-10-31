package modal.beans;

import java.time.YearMonth;

/**
 * @author isuru priyamantha
 */
public class classData {

    /**
     * @return the classId
     */
    public String getClassId() {
        return classId;
    }

    /**
     * @param classId the classId to set
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the teacherName
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName the teacherName to set
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * @return the dueMonth
     */
    public String getDueMonth() {
        return dueMonth;
    }

    /**
     * @param dueMonth the dueMonth to set
     */
    public void setDueMonth(String dueMonth) {
        this.dueMonth = dueMonth;
    }

    /**
     * @return the hallFee
     */
    public String getHallFee() {
        return hallFee;
    }

    /**
     * @param hallFee the hallFee to set
     */
    public void setHallFee(String hallFee) {
        this.hallFee = hallFee;
    }

    /**
     * @return the classFee
     */
    public String getClassFee() {
        return classFee;
    }

    /**
     * @param classFee the classFee to set
     */
    public void setClassFee(String classFee) {
        this.classFee = classFee;
    }

    public classData() {
    }

    public classData(String classId, String subject, String grade, String teacherName, String dueMonth, String hallFee, String classFee) {
        this.classId = classId;
        this.subject = subject;
        this.grade = grade;
        this.teacherName = teacherName;
        this.dueMonth = dueMonth;
        this.hallFee = hallFee;
        this.classFee = classFee;
    }
    
    

    private String classId;
    private String subject;
    private String grade;
    private String teacherName;
    private String dueMonth;
    private String hallFee;
    private String classFee;

}
