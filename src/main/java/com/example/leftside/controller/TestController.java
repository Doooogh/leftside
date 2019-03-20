package com.example.leftside.controller;

import com.example.leftside.entity.Permission;
import com.example.leftside.service.PermissionService;
import com.example.leftside.utils.BuildTree;
import com.example.leftside.utils.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private PermissionService permissionService;



    @GetMapping("/list")
    @ResponseBody
    public List<Permission> list(Map<String,Object> map){
        return permissionService.list(map);
    }




    @GetMapping("/tree")
    @ResponseBody
    public List<Tree<Permission>>tree(){
       return permissionService.getTree().getChildren();
    }

    @GetMapping("/")
    public String tree1(Model model){
        List<Tree<Permission>> trees = permissionService.getTree().getChildren();
        model.addAttribute("trees",trees);
        return "index";
    }

    @GetMapping("/newOrder")
    public String newOrder(){
        return "newOrder";

    }

    @GetMapping("/order")
    public String order(){
        return "order";
    }
}
