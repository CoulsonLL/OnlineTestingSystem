package entity;

import java.util.Objects;

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
    @Column(name = "StuName", nullable = false, length = 20)
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return stuId == that.stuId &&
                stuAge == that.stuAge &&
                Objects.equals(stuName, that.stuName) &&
                Objects.equals(stuPwd, that.stuPwd) &&
                Objects.equals(stuSex, that.stuSex) &&
                Objects.equals(phoneNum, that.phoneNum);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(stuId, stuName, stuPwd, stuAge, stuSex, phoneNum);
    }
}
