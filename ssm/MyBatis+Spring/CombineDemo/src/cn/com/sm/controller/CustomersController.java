package cn.com.sm.controller;

import cn.com.sm.po.Customer;
import cn.com.sm.po.Result;
import cn.com.sm.service.impl.CustomersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *org.springframework.beans.factory.BeanCreationException:
 * Error creating bean with name 'customersController':
 * Injection of autowired dependencies failed; nested exception is org.springframework.beans.factory.
 * BeanCreationException: Could not autowire field: private cn.com.sm.service.impl.CustomersServiceImpl
 * cn.com.sm.controller.CustomersController.customersService;
 * nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException:
 * No qualifying bean of type [cn.com.sm.service.impl.CustomersServiceImpl] found for dependency:
 * expected at least 1 bean which qualifies as autowire candidate for this dependency.
 * Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
 */
@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomersServiceImpl customersService;

    @RequestMapping(value = "/detail",method = RequestMethod.GET,produces = "application/json")
    public List<Customer> findAll(){
        try {
            return customersService.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public List<Customer> findById(@RequestParam(value = "id",required = false)String id){
        try {
            return customersService.findById(id);
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Result insert(@RequestBody Customer customer){
        try{
            customersService.insert(customer);
            return new Result(true,"insert successfully");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"error from insert");
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody Customer customer){
        try{
            customersService.update(customer);
            return new Result(true,"update successfully");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"error from update");
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(@RequestBody String ...ids){
        //待解：无法正常将报错信息反馈到客户端
        //通过检查id的存在情况，返回删除信息
        try{
            customersService.delete(ids);
            return new Result(true,"delete successfully");
        }catch (Exception e){
            return new Result(false,"error from delete");
        }
    }
}
