package entity;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course", schema = "dbo", catalog = "OnlineTest")
public class CourseEntity
{
    private int cCourseId;
    private String cName;
    private int cModule;
    private String cDetail;
    private Integer mgrId;
    private Timestamp modifyTime;
    private Integer viewCount;
    private String picture;

    public CourseEntity(int cCourseId, String cName)
    {
        this.cCourseId = cCourseId;
        this.cName = cName;
    }

    public CourseEntity()
    {
    }

    @Id
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
    @Column(name = "CName", nullable = false, length = 20)
    public String getcName()
    {
        return cName;
    }

    public void setcName(String cName)
    {
        this.cName = cName;
    }

    @Basic
    @Column(name = "CModule", nullable = false)
    public int getcModule()
    {
        return cModule;
    }

    public void setcModule(int cModule)
    {
        this.cModule = cModule;
    }

    @Basic
    @Column(name = "CDetail", nullable = true, length = 2147483647)
    public String getcDetail()
    {
        return cDetail;
    }

    public void setcDetail(String cDetail)
    {
        this.cDetail = cDetail;
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

    @Basic
    @Column(name = "ViewCount", nullable = true)
    public Integer getViewCount()
    {
        return viewCount;
    }

    public void setViewCount(Integer viewCount)
    {
        this.viewCount = viewCount;
    }

    @Basic
    @Column(name = "picture", nullable = true, length = 2147483647)
    public String getPicture()
    {
        return picture;
    }

    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseEntity that = (CourseEntity) o;

        if (cCourseId != that.cCourseId) return false;
        if (cModule != that.cModule) return false;
        if (cName != null ? !cName.equals(that.cName) : that.cName != null) return false;
        if (cDetail != null ? !cDetail.equals(that.cDetail) : that.cDetail != null) return false;
        if (mgrId != null ? !mgrId.equals(that.mgrId) : that.mgrId != null) return false;
        if (modifyTime != null ? !modifyTime.equals(that.modifyTime) : that.modifyTime != null)
        {
            return false;
        }
        if (viewCount != null ? !viewCount.equals(that.viewCount) : that.viewCount != null)
        {
            return false;
        }
        if (picture != null ? !picture.equals(that.picture) : that.picture != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = cCourseId;
        result = 31 * result + (cName != null ? cName.hashCode() : 0);
        result = 31 * result + cModule;
        result = 31 * result + (cDetail != null ? cDetail.hashCode() : 0);
        result = 31 * result + (mgrId != null ? mgrId.hashCode() : 0);
        result = 31 * result + (modifyTime != null ? modifyTime.hashCode() : 0);
        result = 31 * result + (viewCount != null ? viewCount.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "CourseEntity{" +
                "cCourseId=" + cCourseId +
                ", cName='" + cName + '\'' +
                ", cModule=" + cModule +
                ", cDetail='" + cDetail + '\'' +
                ", mgrId=" + mgrId +
                ", modifyTime=" + modifyTime +
                ", viewCount=" + viewCount +
                ", picture='" + picture + '\'' +
                '}';
    }
}
