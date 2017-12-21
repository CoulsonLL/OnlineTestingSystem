package service;

import dao.ManagerDAO;
import entity.ManagerEntity;
import util.FacesUtil;

public class ManagerService
{
    ManagerDAO managerDAO = new ManagerDAO();

    /**
     * 修改管理员信息
     *
     * @param managerEntity 调用过setMgrPassword()的管理员实体对象
     * @return boolean
     */
    public boolean changeProfile(ManagerEntity managerEntity)
    {
        return managerDAO.updateManager(managerEntity);
    }

    /**
     * 登录
     *
     * @param MgrID    管理员ID
     * @param password 密码
     * @return boolean 登录成功返回true 失败返回false
     */
    public boolean login(Integer MgrID, String password)
    {
        ManagerEntity managerEntity = managerDAO.queryManagerById(MgrID);
        if (managerEntity != null && password != null && password.equals(managerEntity.getMgrPwd()))
        {
            FacesUtil.getSession().setAttribute("mgrInfo", managerEntity);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 退出登录
     */
    public void logout()
    {
        FacesUtil.getSession().removeAttribute("mgrInfo");
    }

    /**
     * 判断是否已经登录
     *
     * @return boolean
     */
    public boolean isLoggedIn()
    {
        if (FacesUtil.getSession().getAttribute("mgrInfo") != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
