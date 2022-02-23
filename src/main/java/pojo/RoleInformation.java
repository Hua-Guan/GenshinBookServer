package pojo;

public class RoleInformation {
     private String RoleUri;
     private String RoleName;
     private String Affiliation;
     private String Vision;
     private String WeaponType;
     private String Constellation;
     private String Birthday;
     private String Title;
     private String Introduction;

    public String getRoleUri() {
        return RoleUri;
    }

    public String getRoleName() {
        return RoleName;
    }

    public String getAffiliation() {
        return Affiliation;
    }

    public String getVision() {
        return Vision;
    }

    public String getWeaponType() {
        return WeaponType;
    }

    public String getConstellation() {
        return Constellation;
    }

    public String getBirthday() {
        return Birthday;
    }

    public String getTitle() {
        return Title;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setRoleUri(String roleUri) {
        RoleUri = roleUri;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public void setAffiliation(String affiliation) {
        Affiliation = affiliation;
    }

    public void setVision(String vision) {
        Vision = vision;
    }

    public void setWeaponType(String weaponType) {
        WeaponType = weaponType;
    }

    public void setConstellation(String constellation) {
        Constellation = constellation;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    @Override
    public String toString() {
        return "RoleInformation{" +
                "RoleUri='" + RoleUri + '\'' +
                ", RoleName='" + RoleName + '\'' +
                ", Affiliation='" + Affiliation + '\'' +
                ", Vision='" + Vision + '\'' +
                ", WeaponType='" + WeaponType + '\'' +
                ", Constellation='" + Constellation + '\'' +
                ", Birthday='" + Birthday + '\'' +
                ", Title='" + Title + '\'' +
                ", Introduction='" + Introduction + '\'' +
                '}';
    }
}
