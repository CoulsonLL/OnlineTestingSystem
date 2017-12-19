package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Module", schema = "dbo", catalog = "OnlineTest")
public class ModuleEntity
{
    private int moduleId;
    private String moduleName;

    @Id
    @Column(name = "ModuleID", nullable = false)
    public int getModuleId()
    {
        return moduleId;
    }

    public void setModuleId(int moduleId)
    {
        this.moduleId = moduleId;
    }

    @Basic
    @Column(name = "ModuleName", nullable = false, length = 20)
    public String getModuleName()
    {
        return moduleName;
    }

    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuleEntity that = (ModuleEntity) o;

        if (moduleId != that.moduleId) return false;
        if (moduleName != null ? !moduleName.equals(that.moduleName) : that.moduleName != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = moduleId;
        result = 31 * result + (moduleName != null ? moduleName.hashCode() : 0);
        return result;
    }
}
