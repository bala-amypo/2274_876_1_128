package com.example.demo.entity;
import com.example.demo.entity.enums.RoleType;
import jakarta.persistence.*;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    @Column(unique = true, nullable = false)
    private String ousername;

    @Column(unique = true, nullable = false)
    private String oemail;

    @Column(nullable = false)
    private String opassword;

    @Enumerated(EnumType.STRING)
    private RoleType orole;

    private Boolean oactive;

    
    public UserAccount() {
    }

    
    public UserAccount(Long oid,
                       String ousername,
                       String oemail,
                       String opassword,
                       RoleType orole,
                       Boolean oactive) {
        this.oid = oid;
        this.ousername = ousername;
        this.oemail = oemail;
        this.opassword = opassword;
        this.orole = orole;
        this.oactive = oactive;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getOusername() {
        return ousername;
    }

    public void setOusername(String ousername) {
        this.ousername = ousername;
    }

    public String getOemail() {
        return oemail;
    }

    public void setOemail(String oemail) {
        this.oemail = oemail;
    }

    public String getOpassword() {
        return opassword;
    }

    public void setOpassword(String opassword) {
        this.opassword = opassword;
    }

    public RoleType getOrole() {
        return orole;
    }

    public void setOrole(RoleType orole) {
        this.orole = orole;
    }

    public Boolean getOactive() {
        return oactive;
    }

    public void setOactive(Boolean oactive) {
        this.oactive = oactive;
    }
}
