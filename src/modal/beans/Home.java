package modal.beans;

import java.io.Serializable;

/**
 *
 * @author isuru priyamantha
 */
public class Home implements Serializable{

    /**
     * @return the logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * @return the homeName
     */
    public String getHomeName() {
        return homeName;
    }

    /**
     * @param homeName the homeName to set
     */
    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    /**
     * @return the line01
     */
    public String getLine01() {
        return line01;
    }

    /**
     * @param line01 the line01 to set
     */
    public void setLine01(String line01) {
        this.line01 = line01;
    }

    /**
     * @return the line02
     */
    public String getLine02() {
        return line02;
    }

    /**
     * @param line02 the line02 to set
     */
    public void setLine02(String line02) {
        this.line02 = line02;
    }

    /**
     * @return the City
     */
    public String getCity() {
        return City;
    }

    /**
     * @param City the City to set
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     * @return the landLine
     */
    public String getLandLine() {
        return landLine;
    }

    /**
     * @param landLine the landLine to set
     */
    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public Home() {
    }

    public Home(String homeName, String line01, String line02, String City, String landLine, String mobile, String email,String logo) {
        this.homeName = homeName;
        this.line01 = line01;
        this.line02 = line02;
        this.City = City;
        this.landLine = landLine;
        this.mobile = mobile;
        this.email = email;
        this.logo = logo;
    }

    private String homeName;
    private String line01;
    private String line02;
    private String City;
    private String landLine;
    private String mobile;
    private String email;
    private String logo;
    
}
