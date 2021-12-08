package com.leguide.backoffice.karaf.models.lgbase.users;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_users", uniqueConstraints = {@UniqueConstraint(columnNames = {"usr_email"})})
@XmlRootElement(name = "Users")
@NamedNativeQueries({
        @NamedNativeQuery(name = Users.FIND_BY_EMAIL_AND_PASSWORD, query = "SELECT * FROM tb_users u WHERE u.usr_email = ? AND BINARY u.usr_password = ?", resultClass = Users.class)
})
@NamedQueries({
        @NamedQuery(name = Users.FIND_BY_USER_EMAIL, query = "Select u FROM Users u WHERE u.email = :email")
})
public class Users implements Serializable {

    private static final long serialVersionUID = 235846691246128303L;

    public static final String DELETE_BY_USERID = "Users.DELETE_BY_USERID";

    public static final String FIND_BY_USER_EMAIL = "Users.FIND_BY_USER_EMAIL";

    public static final String FIND_BY_EMAIL_AND_PASSWORD = "Users.FIND_BY_EMAIL_AND_PASSWORD";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long userId;

    @Column(name = "usr_email")
    private String email;

    @Column(name = "usr_password")
    private String password;

    @Column(name = "usr_civility")
    private Integer civility;

    @Column(name = "usr_firstname")
    private String firstname;

    @Column(name = "usr_lastname")
    private String lastname;

    @Column(name = "usr_phone_number")
    private String phone;

    @Column(name = "usr_mobile_number")
    private String mobile;

    @Column(name = "usr_fax_number")
    private String fax;

    @Column(name = "usr_service_id")
    private Integer serviceId;

    @Column(name = "usr_function_id")
    private Integer functionId;

    @Column(name = "usr_other_service")
    private String otherService;

    @Column(name = "usr_other_function")
    private String otherFunction;

    @Column(name = "usr_status")
    @Enumerated(EnumType.STRING)
    private UsersStatusEnum status;

    @Column(name = "usr_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "usr_last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Column(name = "usr_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;

    @Column(name = "usr_main_language")
    private String mainLanguage;

    // there is a trigger in DB setting the value before insert, and preventing updating. So no need to 
    // provide a setter, or include those fields in update script
    @Column(name = "opt_out_token_partner", insertable = false, updatable = false)
    private String optOutTokenPartner;

    @Column(name = "opt_out_token_leguide", insertable = false, updatable = false)
    private String optOutTokenLeguide;

	/*
     * List of Getters and Setters
	 */

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCivility() {
        return civility;
    }

    public void setCivility(Integer civility) {
        this.civility = civility;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public String getOtherService() {
        return otherService;
    }

    public void setOtherService(String otherService) {
        this.otherService = otherService;
    }

    public String getOtherFunction() {
        return otherFunction;
    }

    public void setOtherFunction(String otherFunction) {
        this.otherFunction = otherFunction;
    }

    public UsersStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UsersStatusEnum status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public void setMainLanguage(String mainLanguage) {
        this.mainLanguage = mainLanguage;
    }

    public String getOptOutTokenPartner() {
        return optOutTokenPartner;
    }

    public String getOptOutTokenLeguide() {
        return optOutTokenLeguide;
    }


}
