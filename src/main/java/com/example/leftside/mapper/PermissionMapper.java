package com.example.leftside.mapper;

import com.example.leftside.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author lilong
 * @email 1992lcg@163.com
 * @date 2019-03-11 15:04:00
 */
@Mapper
public interface PermissionMapper {


	List<Permission> list(Map<String, Object> map);

}
