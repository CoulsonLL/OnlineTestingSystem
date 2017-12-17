package test;

import service.StudentService;

public class testLogin
{
    public static void main(String[] args)
    {
        StudentService studentService = new StudentService();
        System.out.println(studentService.login("18661661838","123123"));
    }
}
