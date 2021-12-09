package pojo;

public class RoleName {
    private String RoleName;
    private String RoleUri;
    private String Stars;

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getRoleUri() {
        return RoleUri;
    }

    public void setRoleUri(String roleUri) {
        RoleUri = roleUri;
    }

    public String getStars() {
        return Stars;
    }

    public void setStars(String stars) {
        Stars = stars;
    }

    public RoleName() {
    }

    @Override
    public String toString() {
        return "RoleName{" +
                "RoleName='" + RoleName + '\'' +
                ", RoleUri='" + RoleUri + '\'' +
                ", Stars='" + Stars + '\'' +
                '}';
    }
}
