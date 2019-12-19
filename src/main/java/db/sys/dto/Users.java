package db.sys.dto;

import java.util.Date;

public class Users {
    private String urid;
    private String id;
    private String password;
    private String status;
    private String createdby;
    private Date createdon;
    private String lastmodifiedby;
    private Date lastmodifiedon;
    private Integer rowversion;

    public String getUrid() {
        return urid;
    }

    public void setUrid(String urid) {
        this.urid = urid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public String getLastmodifiedby() {
        return lastmodifiedby;
    }

    public void setLastmodifiedby(String lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }

    public Date getLastmodifiedon() {
        return lastmodifiedon;
    }

    public void setLastmodifiedon(Date lastmodifiedon) {
        this.lastmodifiedon = lastmodifiedon;
    }

    public Integer getRowversion() {
        return rowversion;
    }

    public void setRowversion(Integer rowversion) {
        this.rowversion = rowversion;
    }

    @Override
    public String toString() {
        return "Users{" +
                "urid='" + urid + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", createdby='" + createdby + '\'' +
                ", createdon=" + createdon +
                ", lastmodifiedby='" + lastmodifiedby + '\'' +
                ", lastmodifiedon=" + lastmodifiedon +
                ", rowversion=" + rowversion +
                '}';
    }
}
