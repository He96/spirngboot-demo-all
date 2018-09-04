package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     *
     * 查询（根据主键ID查询）
     *
     **/
    User get(@Param("id") Long id);

    /**
     * 登录
     * @param map
     * @return
     */
    User login(Map<String, Object> map);

    /**
     *
     * 获取列表
     *
     **/
    List<User> getList(Map<String, Object> map);
    /**
     *
     * 分页获取列表
     *
     **/
    List<User>  getPageList(Map<String, Object> map);

    /**
     *
     * 删除（根据主键ID删除）
     *
     **/
    int delete(@Param("id") Long id);

    /**
     *
     * 添加
     *
     **/
    int addAndId(User data);

    /**
     *
     * 修改 （匹配有值的字段）
     *
     **/
    int update(Map<String, Object> map);

    /**
     *
     * 修改（根据主键ID修改）
     *
     **/
    int updateById(User data);

}
