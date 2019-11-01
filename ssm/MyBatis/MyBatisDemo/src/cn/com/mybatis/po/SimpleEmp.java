package cn.com.mybatis.po;

import java.io.Serializable;

public class SimpleEmp implements Serializable {
    private Integer empno;
    private String ename;
    private String job;
    public SimpleEmp(){};

    public Integer getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }

    public String getJob() {
        return job;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "EMPNO:{" + empno + "}|"+
                "ENAME:{" + ename + "}|"+
                "JOB:{" + job + "}|";
    }
}
