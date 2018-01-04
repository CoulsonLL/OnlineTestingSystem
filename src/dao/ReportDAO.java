package dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import entity.ExamLogEntity;
import entity.ReportEntity;
import util.HibernateUtil;

@SuppressWarnings("ALL")
public class ReportDAO
{
    public List<ReportEntity> getReportByExamLog(ExamLogEntity examLogEntity)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        Query query = session.createQuery("from ReportEntity where examLogId = ? order by questionId asc");
        query.setParameter(0, examLogEntity.getExamLogsId());
        list = query.list();
        tx.commit();
        session.close();
        return list;
    }
}
