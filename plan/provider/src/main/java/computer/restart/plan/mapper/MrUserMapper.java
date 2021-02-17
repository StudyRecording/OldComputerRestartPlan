package computer.restart.plan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import computer.restart.plan.pojo.MrUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *@ClassName MrUserMapper
 *@Description 用户表关于数据库的操作
 *@Author hpc
 *@Date 2021/2/14 18:44
 **/
@Mapper
@Repository
public interface MrUserMapper extends BaseMapper<MrUser> {
}
