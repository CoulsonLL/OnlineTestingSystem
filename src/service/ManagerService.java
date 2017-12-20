package service;

import dao.ManagerDAO;
import entity.ManagerEntity;

public class ManagerService
{
    /**
     * 修改管理员信息
     *
     * @param managerEntity 调用过setMgrPassword()的管理员实体对象
     * @return boolean
     */
    public boolean changeProfile(ManagerEntity managerEntity)
    {
        ManagerDAO managerDAO = new ManagerDAO();
        return managerDAO.updateManager(managerEntity);
    }
}
