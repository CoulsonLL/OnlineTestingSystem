package entity;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Paper", schema = "dbo", catalog = "OnlineTest")
public class PaperEntity
{
    private int pid;
    private String pname;
    private int cCourseId;
    private Integer mgrId;
    private Timestamp modifyTime;

    @Id
    @Column(name = "PID", nullable = false)
    public int getPid()
    {
        return pid;
    }

    public void setPid(int pid)
    {
        this.pid = pid;
    }

    @Basic
    @Column(name = "Pname", nullable = false, length = 20)
    public String getPname()
    {
        return pname;
    }

    public void setPname(String pname)
    {
        this.pname = pname;
    }

    @Basic
    @Column(name = "CCourseID", nullable = false)
    public int getcCourseId()
    {
        return cCourseId;
    }

    public void setcCourseId(int cCourseId)
    {
        this.cCourseId = cCourseId;
    }

    @Basic
    @Column(name = "MgrID", nullable = true)
    public Integer getMgrId()
    {
        return mgrId;
    }

    public void setMgrId(Integer mgrId)
    {
        this.mgrId = mgrId;
    }

    @Basic
    @Column(name = "ModifyTime", nullable = true)
    public Timestamp getModifyTime()
    {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime)
    {
        this.modifyTime = modifyTime;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaperEntity that = (PaperEntity) o;

        if (pid != that.pid) return false;
        if (cCourseId != that.cCourseId) return false;
        if (pname != null ? !pname.equals(that.pname) : that.pname != null) return false;
        if (mgrId != null ? !mgrId.equals(that.mgrId) : that.mgrId != null) return false;
        if (modifyTime != null ? !modifyTime.equals(that.modifyTime) : that.modifyTime != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = pid;
        result = 31 * result + (pname != null ? pname.hashCode() : 0);
        result = 31 * result + cCourseId;
        result = 31 * result + (mgrId != null ? mgrId.hashCode() : 0);
        result = 31 * result + (modifyTime != null ? modifyTime.hashCode() : 0);
        return result;
    }
}
