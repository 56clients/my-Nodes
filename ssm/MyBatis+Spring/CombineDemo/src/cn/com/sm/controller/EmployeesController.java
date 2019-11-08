package cn.com.sm.controller;

import cn.com.sm.po.Employee;
import cn.com.sm.po.Result;
import cn.com.sm.service.impl.EmployeesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标志该方法的返回值（更正，原文是return type，看起来应该是返回值）
 * 应该被直接写回到HTTP响应体中去（而不会被被放置到Model中或被解释为一个视图名）
 */
@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private  EmployeesServiceImpl employeesService;

    @RequestMapping(value = "/detail",method = RequestMethod.GET,produces = "application/json")
    public List<Employee> findAll(){
        return employeesService.findAll();
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public List<Employee> findById(@RequestParam(value = "id",required = false)String id){
        return employeesService.findById(id);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Result insert(@RequestBody Employee employee){
        try{
            employeesService.insert(employee);
            return new Result(true,"insert successfully");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"error from insert");
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody Employee employee){
        try{
            employeesService.update(employee);
            return new Result(true,"update successfully");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"error from update");
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(@RequestBody String... ids){
        try{
            employeesService.delete(ids);
            return new Result(true,"delete successfully");
        }catch (Exception e){
            return new Result(false,"error from delete");
        }
    }
}
