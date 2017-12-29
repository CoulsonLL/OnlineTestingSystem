package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import entity.QuestionEntity;
import service.QuestionService;
import util.ReadExcelUtil;

@SuppressWarnings("ALL")
@RequestScoped
@Named
public class FileUploadBean
{
    private Part file;
    private String msg;

    public void upload()
    {
        try
        {
            InputStream stream = file.getInputStream();
            FileOutputStream fos = null;
            String path = null;
            String suffix = getFileName(file).substring(getFileName(file).lastIndexOf(".") + 1);
            if (suffix.equalsIgnoreCase("xls") || suffix.equalsIgnoreCase("xlsx"))
            {
                String newFilename = new Date().getTime() + "_" + getFileName(file);
                path = "d:\\" + newFilename;
                fos = new FileOutputStream(path);
                byte[] b = new byte[1024];
                while ((stream.read(b)) != -1)
                {
                    fos.write(b);
                }
                System.out.println(newFilename);
                fos.close();
                updateDatabase(path);
            }
            stream.close();
            msg = "Uploaded and Inserted! File=" + getFileName(file);
        }
        catch (Exception e)
        {
            msg = "Upload failed! Please check your file and upload again! File=" + getFileName(file);
        }
    }

    public void updateDatabase(String path) throws IOException
    {
        File file = new File(path);
        ArrayList<String[]> list = (ArrayList<String[]>) ReadExcelUtil.readExcel(file);
        file.delete();
        QuestionService questionService = new QuestionService();
        for (String[] strings : list)
        {
            int courseID = Integer.parseInt(strings[0]);
            String stem = strings[1];
            String a = strings[2];
            String b = strings[3];
            String c = strings[4];
            String d = strings[5];
            String answer = strings[6];
            BigDecimal score = BigDecimal.valueOf(Long.parseLong(strings[7]));
            QuestionEntity questionEntity = new QuestionEntity(courseID, a, b, c, d, answer, score, stem);
            questionService.addQuestion(questionEntity);
            System.out.println("uploaded:" + questionEntity);
        }

    }

    //取得上传文件名
    private String getFileName(Part part)
    {
        String header = part.getHeader("Content-Disposition");
        String fileName = header.substring(header.indexOf("filename=\"") + 10,
                header.lastIndexOf("\""));
        return fileName;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Part getFile()
    {
        return file;
    }

    public void setFile(Part file)
    {
        this.file = file;
    }
}
