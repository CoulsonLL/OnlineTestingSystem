package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student", schema = "dbo", catalog = "OnlineTest")
public class StudentEntity
{
    private int stuId;
    private String stuName;
    private String stuPwd;
    private int stuAge;
    private String stuSex;
    private String phoneNum;
    private String email;

    public StudentEntity()
    {

    }

    public StudentEntity(int stuId, String stuName, String stuPwd, int stuAge, String stuSex, String phoneNum, String email)
    {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuPwd = stuPwd;
        this.stuAge = stuAge;
        this.stuSex = stuSex;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    @Id
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
    @Column(name = "StuName", nullable = true, length = 20)
    public String getStuName()
    {
        return stuName;
    }

    public void setStuName(String stuName)
    {
        this.stuName = stuName;
    }

    @Basic
    @Column(name = "StuPwd", nullable = false, length = 20)
    public String getStuPwd()
    {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd)
    {
        this.stuPwd = stuPwd;
    }

    @Basic
    @Column(name = "StuAge", nullable = false)
    public int getStuAge()
    {
        return stuAge;
    }

    public void setStuAge(int stuAge)
    {
        this.stuAge = stuAge;
    }

    @Basic
    @Column(name = "StuSex", nullable = false, length = 1)
    public String getStuSex()
    {
        return stuSex;
    }

    public void setStuSex(String stuSex)
    {
        this.stuSex = stuSex;
    }

    @Basic
    @Column(name = "PhoneNum", nullable = true, length = 11)
    public String getPhoneNum()
    {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum)
    {
        this.phoneNum = phoneNum;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 50)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (stuId != that.stuId) return false;
        if (stuAge != that.stuAge) return false;
        if (stuName != null ? !stuName.equals(that.stuName) : that.stuName != null) return false;
        if (stuPwd != null ? !stuPwd.equals(that.stuPwd) : that.stuPwd != null) return false;
        if (stuSex != null ? !stuSex.equals(that.stuSex) : that.stuSex != null) return false;
        if (phoneNum != null ? !phoneNum.equals(that.phoneNum) : that.phoneNum != null)
        {
            return false;
        }
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = stuId;
        result = 31 * result + (stuName != null ? stuName.hashCode() : 0);
        result = 31 * result + (stuPwd != null ? stuPwd.hashCode() : 0);
        result = 31 * result + stuAge;
        result = 31 * result + (stuSex != null ? stuSex.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "StudentEntity{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuPwd='" + stuPwd + '\'' +
                ", stuAge=" + stuAge +
                ", stuSex='" + stuSex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
