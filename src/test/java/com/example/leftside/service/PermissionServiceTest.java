package com.example.leftside.service;

import com.example.leftside.entity.Permission;
import com.example.leftside.mapper.PermissionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionServiceTest {
    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    public void list() {
        List<Permission> list = permissionMapper.list(new HashMap<String, Object>());
        for (Permission permission : list) {
            System.out.println(permission);
        }
    }
}