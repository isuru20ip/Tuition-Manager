package modal.beans;

import java.io.Serializable;

/**
 *
 * @author isuru priyamantha
 */
public class Home implements Serializable{

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
     * @return the phone01
     */
    public String getPhone01() {
        return phone01;
    }

    /**
     * @param phone01 the phone01 to set
     */
    public void setPhone01(String phone01) {
        this.phone01 = phone01;
    }

    /**
     * @return the phone02
     */
    public String getPhone02() {
        return phone02;
    }

    /**
     * @param phone02 the phone02 to set
     */
    public void setPhone02(String phone02) {
        this.phone02 = phone02;
    }

    /**
     * @return the phone03
     */
    public String getPhone03() {
        return phone03;
    }

    /**
     * @param phone03 the phone03 to set
     */
    public void setPhone03(String phone03) {
        this.phone03 = phone03;
    }

    /**
     * @return the webLink
     */
    public String getWebLink() {
        return webLink;
    }

    /**
     * @param webLink the webLink to set
     */
    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

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

    public Home() {
    }

    public Home(String homeName, String line01, String line02, String City, String phone01, String phone02, String phone03, String webLink, String fax, String logo) {
        this.homeName = homeName;
        this.line01 = line01;
        this.line02 = line02;
        this.City = City;
        this.phone01 = phone01;
        this.phone02 = phone02;
        this.phone03 = phone03;
        this.webLink = webLink;
        this.fax = fax;
        this.logo = logo;
    }
    
    
    
    private String homeName;
    private String line01;
    private String line02;
    private String City;
    private String phone01;
    private String phone02;
    private String phone03;
    private String webLink;
    private String fax;
    private String logo;
    
}
