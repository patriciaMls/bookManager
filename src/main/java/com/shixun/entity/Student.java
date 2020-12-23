package com.shixun.entity;

/**
 * @description:学生实体类
 * 实体类属性 —— 书籍表字段
 * stuId —— stu_id
 * stuNum —— stu_num
 * stuName —— stu_name
 * stuClass —— stu_class
 * stuUsername —— stu_username
 * stuPassword —— stu_password
 * @author: Patricia
 * @date: Created in 2020/12/23 15:40
 * @version: 1.0
 * @modified By:
 */
public class Student {
    private int stuId;
    private String stuNum;
    private String stuName;
    private String stuClass;
    private String stuUsername;
    private String stuPassword;

    public Student() {
    }

    public Student(int stuId, String stuNum, String stuName, String stuClass, String stuUsername, String stuPassword) {
        this.stuId = stuId;
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuClass = stuClass;
        this.stuUsername = stuUsername;
        this.stuPassword = stuPassword;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuUsername() {
        return stuUsername;
    }

    public void setStuUsername(String stuUsername) {
        this.stuUsername = stuUsername;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", stuUsername='" + stuUsername + '\'' +
                ", stuPassword='" + stuPassword + '\'' +
                '}';
    }
}
