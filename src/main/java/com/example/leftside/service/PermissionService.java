package com.example.leftside.service;

import com.example.leftside.entity.Permission;
import com.example.leftside.utils.Tree;

import java.util.List;
import java.util.Map;

public interface PermissionService {
    List<Permission> list(Map<String, Object> map);

    Tree<Permission> getTree();
}
