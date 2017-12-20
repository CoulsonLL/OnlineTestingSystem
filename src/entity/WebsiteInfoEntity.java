package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WebsiteInfo", schema = "dbo", catalog = "OnlineTest")
public class WebsiteInfoEntity
{
    private int id;
    private Long viewCount;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "ViewCount", nullable = true)
    public Long getViewCount()
    {
        return viewCount;
    }

    public void setViewCount(Long viewCount)
    {
        this.viewCount = viewCount;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebsiteInfoEntity that = (WebsiteInfoEntity) o;

        if (id != that.id) return false;
        if (viewCount != null ? !viewCount.equals(that.viewCount) : that.viewCount != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (viewCount != null ? viewCount.hashCode() : 0);
        return result;
    }
}
