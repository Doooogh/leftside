package com.example.leftside.service.impl;

import com.example.leftside.entity.Permission;
import com.example.leftside.mapper.PermissionMapper;
import com.example.leftside.service.PermissionService;
import com.example.leftside.utils.BuildTree;
import com.example.leftside.utils.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> list(Map<String, Object> map) {
        return permissionMapper.list(map);
    }

    @Override
    public Tree<Permission> getTree() {
        List<Permission> perList = permissionMapper.list(new HashMap<>());
        List<Tree<Permission>> trees = new ArrayList<Tree<Permission>>();
        for (Permission per : perList) {
            Tree<Permission> tree=new Tree<>();
            tree.setId(per.getId().toString());
            tree.setParentId(per.getParentId().toString());
            tree.setText(per.getName());
            Map<String, Object> state = new HashMap<>(16);
            Map<String, Object> attributes = new HashMap<>(16);
            attributes.put("url",per.getPermission());
            attributes.put("img",per.getImg());
            tree.setAttributes(attributes);
            Integer perId = per.getId();
            state.put("selected", false);
            tree.setState(state);
            trees.add(tree);
        }
        Tree<Permission> t = BuildTree.build(trees);
        return t;
    }
}
