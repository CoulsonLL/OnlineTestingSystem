package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SC", schema = "dbo", catalog = "OnlineTest")
public class ScEntity
{
    private int stuId;
    private int cCourseId;
    private int cCourseState;
    private int scid;

    public ScEntity()
    {

    }

    public ScEntity(int stuId, int cCourseId, int cCourseState)
    {
        this.stuId = stuId;
        this.cCourseId = cCourseId;
        this.cCourseState = cCourseState;
    }

    @Basic
    @Column(name = "StuID", nullable = false)
    public int getStuId()
    {
        return stuId;
    }

    public void setStuId(int stuId)
    {
        this.stuId = stuId;
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
    @Column(name = "CCourseState", nullable = false)
    public int getcCourseState()
    {
        return cCourseState;
    }

    public void setcCourseState(int cCourseState)
    {
        this.cCourseState = cCourseState;
    }

    @Id
    @Column(name = "SCID", nullable = false)
    public int getScid()
    {
        return scid;
    }

    public void setScid(int scid)
    {
        this.scid = scid;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScEntity scEntity = (ScEntity) o;

        if (stuId != scEntity.stuId) return false;
        if (cCourseId != scEntity.cCourseId) return false;
        if (cCourseState != scEntity.cCourseState) return false;
        if (scid != scEntity.scid) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = stuId;
        result = 31 * result + cCourseId;
        result = 31 * result + cCourseState;
        result = 31 * result + scid;
        return result;
    }

    @Override
    public String toString()
    {
        return "ScEntity{" +
                "stuId=" + stuId +
                ", cCourseId=" + cCourseId +
                ", cCourseState=" + cCourseState +
                ", scid=" + scid +
                '}';
    }
}
