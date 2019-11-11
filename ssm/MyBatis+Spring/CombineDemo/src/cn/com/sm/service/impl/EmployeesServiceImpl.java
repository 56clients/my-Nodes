package cn.com.sm.service.impl;

import cn.com.sm.mapper.EmployeesMapper;
import cn.com.sm.po.Employee;
import cn.com.sm.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements BaseService<Employee> {

    @Autowired
    private EmployeesMapper employeesMapper;
    @Override
    public List<Employee> findAll() throws Exception{
        return employeesMapper.findAll();
    }

    @Override
    public List<Employee> findById(String id) throws Exception{
        return employeesMapper.findById(id);
    }

    @Override
    public void insert(Employee employee) throws Exception{
        employeesMapper.insert(employee);
    }

    @Override
    public void update(Employee employee) throws Exception{
        employeesMapper.update(employee);
    }

    @Override
    public void delete(String... ids) throws Exception{
        for(String id:ids){
            employeesMapper.delete(id);
        }

    }
}
