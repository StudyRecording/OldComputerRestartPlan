package computer.restart.plan.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import computer.restart.plan.constant.Constant;
import computer.restart.plan.mapper.MrUserMapper;
import computer.restart.plan.pojo.MrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @ClassName MrUserController
 * @Description 用户表的使用
 * @Author hpc
 * @Date 2021/2/14 18:45
 **/
@RestController
@RequestMapping("/user")
public class MrUserController {

    @Autowired
    private MrUserMapper mrUserMapper;

    /**
     * 添加用户
     * @param mrUser
     * @return
     */
    @PostMapping("/add")
    public Integer add(@RequestBody MrUser mrUser) {
        mrUser.setCreatedAt(LocalDateTime.now());
        mrUser.setUpdatedAt(LocalDateTime.now());
        return mrUserMapper.insert(mrUser);
    }

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public MrUser get(@PathVariable("id") Integer id) {
        return mrUserMapper.selectById(id);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/remove/{id}")
    public Integer remove(@PathVariable("id") Integer id) {
        return mrUserMapper.deleteById(id);
    }

    /**
     * 根据email查询用户
     * @param email
     * @return
     */
    @GetMapping("/loadUserByEmail/{email}")
    public MrUser loadUserByEmail(@PathVariable("email") String email) {
        QueryWrapper<MrUser> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .lambda()
                .eq(MrUser::getEmail, email)
                .eq(MrUser::getEnable, Constant.ENABLE);
        return mrUserMapper.selectOne(queryWrapper);
    }

    /**
     * 查询用户列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list/{page}/{size}")
    public PageInfo<Object> list(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return PageHelper.startPage(page, size)
                .doSelectPageInfo(() -> mrUserMapper.selectList(new QueryWrapper<>()));
    }

}
