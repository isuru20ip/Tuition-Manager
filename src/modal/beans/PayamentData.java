package modal.beans;

/**
 * @author Isuru Priyamantha
 */
public class PayamentData {

    /**
     * @return the ClassId
     */
    public String getClassId() {
        return ClassId;
    }

    /**
     * @param ClassId the ClassId to set
     */
    public void setClassId(String ClassId) {
        this.ClassId = ClassId;
    }

    /**
     * @return the fee
     */
    public String getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(String fee) {
        this.fee = fee;
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
     * @return the teacherNIC
     */
    public String getTeacherNIC() {
        return teacherNIC;
    }

    /**
     * @param teacherNIC the teacherNIC to set
     */
    public void setTeacherNIC(String teacherNIC) {
        this.teacherNIC = teacherNIC;
    }

    /**
     * @return the subjectID
     */
    public String getSubjectID() {
        return subjectID;
    }

    /**
     * @param subjectID the subjectID to set
     */
    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    /**
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @return the gradeID
     */
    public String getGradeID() {
        return gradeID;
    }

    /**
     * @param gradeID the gradeID to set
     */
    public void setGradeID(String gradeID) {
        this.gradeID = gradeID;
    }

    /**
     * @return the gradeName
     */
    public String getGradeName() {
        return gradeName;
    }

    /**
     * @param gradeName the gradeName to set
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    /**
     * @return the lastDue
     */
    public String getLastDue() {
        return lastDue;
    }

    /**
     * @param lastDue the lastDue to set
     */
    public void setLastDue(String lastDue) {
        this.lastDue = lastDue;
    }

    public PayamentData() {
    }

    public PayamentData(String ClassId, String fee, String hallFee, String teacherName, String teacherNIC, String subjectID, String subjectName, String gradeID, String gradeName, String lastDue) {
        this.ClassId = ClassId;
        this.fee = fee;
        this.hallFee = hallFee;
        this.teacherName = teacherName;
        this.teacherNIC = teacherNIC;
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.gradeID = gradeID;
        this.gradeName = gradeName;
        this.lastDue = lastDue;
    }
    
    private String ClassId;
    private String fee;
    private String hallFee;
    private String teacherName;
    private String teacherNIC;
    private String subjectID;
    private String subjectName;
    private String gradeID;
    private String gradeName;
    private String lastDue;
    
}
