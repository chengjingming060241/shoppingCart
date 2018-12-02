package com.cheer.model;

public class Iocation {
    private int iocationId;
    private String iocation;
    private String iocationName;
    private String iocationPhone;
    private String UserName;

    public int getIocationId() {
        return iocationId;
    }

    public void setIocationId(int iocationId) {
        this.iocationId = iocationId;
    }

    public String getIocation() {
        return iocation;
    }

    public void setIocation(String iocation) {
        this.iocation = iocation;
    }

    public String getIocationName() {
        return iocationName;
    }

    public void setIocationName(String iocationName) {
        this.iocationName = iocationName;
    }

    public String getIocationPhone() {
        return iocationPhone;
    }

    public void setIocationPhone(String iocationPhone) {
        this.iocationPhone = iocationPhone;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Iocation{");
        sb.append("iocationId=").append(iocationId);
        sb.append(", iocation='").append(iocation).append('\'');
        sb.append(", iocationName='").append(iocationName).append('\'');
        sb.append(", iocationPhone='").append(iocationPhone).append('\'');
        sb.append(", iocationUserName=").append(UserName);
        sb.append('}');
        return sb.toString();
    }
}
