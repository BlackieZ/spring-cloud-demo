/* https://github.com/orange1438 */
package com.blackie.soa.dal.test.read.mbg;

import com.blackie.soa.client.model.po.test.mbg.UserTest;
import com.blackie.soa.client.model.po.test.mbg.UserTestExample;
import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 */
public interface MBGUserTestReadDao {
    /** 
     * 查询数量
     * @param example 条件对象
     * @return 返回数据的数量
     */
    long countByExample(UserTestExample example);

    /** 
     * 根据条件查询（二进制大对象）
     * @param example 条件对象
     * @return 返回查询的结果
     */
    List<UserTest> selectByExample(UserTestExample example);

    /** 
     * 根据ID查询
     * @param id 主键ID
     * @return 返回查询的结果
     */
    UserTest selectByPrimaryKey(Integer id);
}