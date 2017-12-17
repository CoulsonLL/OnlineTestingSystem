package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Manager", schema = "dbo", catalog = "OnlineTest")
public class ManagerEntity
{
    private int mgrId;
    private String mgrName;
    private String mgrPwd;

    @Id
    @Column(name = "MgrID", nullable = false)
    public int getMgrId()
    {
        return mgrId;
    }

    public void setMgrId(int mgrId)
    {
        this.mgrId = mgrId;
    }

    @Basic
    @Column(name = "MgrName", nullable = false, length = 20)
    public String getMgrName()
    {
        return mgrName;
    }

    public void setMgrName(String mgrName)
    {
        this.mgrName = mgrName;
    }

    @Basic
    @Column(name = "MgrPwd", nullable = false, length = 20)
    public String getMgrPwd()
    {
        return mgrPwd;
    }

    public void setMgrPwd(String mgrPwd)
    {
        this.mgrPwd = mgrPwd;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManagerEntity that = (ManagerEntity) o;

        if (mgrId != that.mgrId) return false;
        if (mgrName != null ? !mgrName.equals(that.mgrName) : that.mgrName != null) return false;
        if (mgrPwd != null ? !mgrPwd.equals(that.mgrPwd) : that.mgrPwd != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = mgrId;
        result = 31 * result + (mgrName != null ? mgrName.hashCode() : 0);
        result = 31 * result + (mgrPwd != null ? mgrPwd.hashCode() : 0);
        return result;
    }
}
