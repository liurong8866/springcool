package com.springcool.cool.system.organize.manager.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springcool.cool.system.authority.mapper.SysRoleMapper;
import com.springcool.cool.system.organize.manager.ISysUserManager;
import com.springcool.cool.system.organize.mapper.SysUserMapper;
import com.springcool.cool.system.organize.mapper.merge.SysOrganizeRoleMergeMapper;
import com.springcool.cool.system.organize.mapper.merge.SysUserPostMergeMapper;
import com.springcool.cool.system.api.organize.domain.merge.SysOrganizeRoleMerge;
import com.springcool.cool.system.api.organize.domain.merge.SysUserPostMerge;
import com.springcool.cool.system.organize.mapper.SysDeptMapper;
import com.springcool.cool.system.organize.mapper.SysPostMapper;
import com.springcool.cool.common.core.constant.basic.SqlConstants;
import com.springcool.cool.common.security.utils.SecurityUtils;
import com.springcool.cool.common.web.entity.manager.impl.BaseManager;
import com.springcool.cool.system.api.authority.domain.model.SysRoleConverter;
import com.springcool.cool.system.api.organize.domain.dto.SysDeptDto;
import com.springcool.cool.system.api.organize.domain.dto.SysPostDto;
import com.springcool.cool.system.api.organize.domain.dto.SysUserDto;
import com.springcool.cool.system.api.organize.domain.model.SysDeptConverter;
import com.springcool.cool.system.api.organize.domain.model.SysPostConverter;
import com.springcool.cool.system.api.organize.domain.model.SysUserConverter;
import com.springcool.cool.system.api.organize.domain.po.SysUserPo;
import com.springcool.cool.system.api.organize.domain.query.SysUserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ???????????? ?????????????????????
 *
 * @author springcool
 */
@Component
public class SysUserManager extends BaseManager<SysUserQuery, SysUserDto, SysUserPo, SysUserMapper, SysUserConverter> implements ISysUserManager {

    @Autowired
    SysUserPostMergeMapper userPostMergeMapper;

    @Autowired
    SysOrganizeRoleMergeMapper organizeRoleMergeMapper;

    @Autowired
    SysPostMapper postMapper;

    @Autowired
    SysPostConverter postConverter;

    @Autowired
    SysDeptMapper deptMapper;

    @Autowired
    SysDeptConverter deptConverter;

    @Autowired
    SysRoleMapper roleMapper;

    @Autowired
    SysRoleConverter roleConverter;

    /**
     * ?????????????????? | ??????????????????
     *
     * @param userName ????????????
     * @param password ????????????
     * @return ????????????
     */
    @Override
    public SysUserDto userLogin(String userName, String password) {
        SysUserDto userDto = baseConverter.mapperDto(baseMapper.selectOne(
                Wrappers.<SysUserPo>query().lambda()
                        .eq(SysUserPo::getUserName, userName)));
        // check password is true
        if (ObjectUtil.isNull(userDto) || !SecurityUtils.matchesPassword(password, userDto.getPassword()))
            return null;

        // select posts in user && select depts in post
        List<SysUserPostMerge> userPostMerges = userPostMergeMapper.selectList(
                Wrappers.<SysUserPostMerge>query().lambda()
                        .eq(SysUserPostMerge::getUserId, userDto.getId()));

        List<Long> postIds = userPostMerges.stream().map(SysUserPostMerge::getPostId).collect(Collectors.toList());
        List<Long> deptIds = null;
        // if exist posts, must exist depts
        if (CollUtil.isNotEmpty(userPostMerges)) {
            userDto.setPosts(postConverter.mapperDto(postMapper.selectBatchIds(postIds)));
            if (CollUtil.isNotEmpty(userDto.getPosts())) {
                deptIds = userDto.getPosts().stream().map(SysPostDto::getDeptId).collect(Collectors.toList());
                List<SysDeptDto> depts = deptConverter.mapperDto(deptMapper.selectBatchIds(deptIds));
                for (SysDeptDto deptDto : depts) {
                    for (int i = 0; i < userDto.getPosts().size(); i++) {
                        if (ObjectUtil.equal(userDto.getPosts().get(i).getDeptId(), deptDto.getId())) {
                            userDto.getPosts().get(i).setDept(deptDto);
                            break;
                        }
                    }
                }
            }
        }
        // ????????????????????? ? ??????????????? : ??????????????????
        if (userDto.isAdmin()) {
            userDto.setRoles(new ArrayList<>());
        } else {
            // select roles in user
            List<Long> finalDeptIds = deptIds;
            List<SysOrganizeRoleMerge> organizeRoleMerges = organizeRoleMergeMapper.selectList(
                    Wrappers.<SysOrganizeRoleMerge>query().lambda()
                            .eq(SysOrganizeRoleMerge::getUserId, userDto.getId())
                            .func(i -> {
                                if (CollUtil.isNotEmpty(postIds))
                                    i.or().in(SysOrganizeRoleMerge::getPostId, postIds);
                            })
                            .func(i -> {
                                if (CollUtil.isNotEmpty(finalDeptIds))
                                    i.or().in(SysOrganizeRoleMerge::getDeptId, finalDeptIds);
                            }));
            userDto.setRoles(CollUtil.isNotEmpty(organizeRoleMerges)
                    ? roleConverter.mapperDto(roleMapper.selectBatchIds(organizeRoleMerges.stream().map(SysOrganizeRoleMerge::getRoleId).collect(Collectors.toList())))
                    : new ArrayList<>());
        }
        return userDto;
    }

    /**
     * ??????Id???????????????????????? | ????????????
     *
     * @param id Id
     * @return ????????????
     */
    @Override
    public SysUserDto selectByIdExtra(Serializable id) {
        SysUserDto user = baseConverter.mapperDto(baseMapper.selectById(id));
        if (ObjectUtil.isNotNull(user)) {
            List<SysUserPostMerge> userPostMerges = userPostMergeMapper.selectList(
                    Wrappers.<SysUserPostMerge>query().lambda()
                            .eq(SysUserPostMerge::getUserId, user.getId()));
            user.setPostIds(userPostMerges.stream().map(SysUserPostMerge::getPostId).toArray(Long[]::new));
        }
        return user;
    }

    /**
     * ??????????????????
     *
     * @param user ????????????
     * @return ??????
     */
    @Override
    @DSTransactional
    public int insert(SysUserDto user) {
        int row = baseMapper.insert(user);
        if (row > 0) {
            if (ArrayUtil.isNotEmpty(user.getPostIds())) {
                userPostMergeMapper.insertBatch(
                        Arrays.stream(user.getPostIds())
                                .map(postId -> new SysUserPostMerge(user.getId(), postId))
                                .collect(Collectors.toSet()));
            }
        }
        return row;
    }

    /**
     * ??????????????????
     *
     * @param user ????????????
     * @return ??????
     */
    @Override
    @DSTransactional
    public int update(SysUserDto user) {
        int row = baseMapper.updateById(user);
        if (row > 0) {
            // ?????????????????????????????????????????? ??? ??????/???????????? : ?????????
            List<SysUserPostMerge> userPostMerges = userPostMergeMapper.selectList(
                    Wrappers.<SysUserPostMerge>query().lambda()
                            .eq(SysUserPostMerge::getUserId, user.getId()));
            List<Long> delPostIds = userPostMerges.stream().map(SysUserPostMerge::getPostId).collect(Collectors.toList());

            if (ArrayUtil.isNotEmpty(user.getPostIds())) {
                List<Long> postIds = Arrays.asList(user.getPostIds());
                List<Long> addPostIds = CollUtil.subtractToList(postIds, delPostIds);
                delPostIds.removeAll(postIds);
                if (CollUtil.isNotEmpty(addPostIds)) {
                    userPostMergeMapper.insertBatch(
                            addPostIds.stream()
                                    .map(postId -> new SysUserPostMerge(user.getId(), postId))
                                    .collect(Collectors.toSet()));
                }
            }
            if (CollUtil.isNotEmpty(delPostIds)) {
                userPostMergeMapper.delete(
                        Wrappers.<SysUserPostMerge>update().lambda()
                                .in(SysUserPostMerge::getPostId, delPostIds)
                                .eq(SysUserPostMerge::getUserId, user.getId()));
            }
        }
        return row;
    }

    /**
     * ????????????????????????
     *
     * @param id       ??????Id
     * @param nickName ????????????
     * @param sex      ????????????
     * @param profile  ????????????
     * @return ??????
     */
    @Override
    public int updateUserProfile(Long id, String nickName, String sex, String profile) {
        return baseMapper.update(new SysUserDto(),
                Wrappers.<SysUserPo>update().lambda()
                        .set(SysUserPo::getNickName, nickName)
                        .set(SysUserPo::getSex, sex)
                        .set(SysUserPo::getProfile, profile)
                        .eq(SysUserPo::getId, id));
    }

    /**
     * ??????????????????
     *
     * @param id       ??????Id
     * @param userName ????????????
     * @return ??????
     */
    @Override
    public int updateUserName(Long id, String userName) {
        return baseMapper.update(new SysUserDto(),
                Wrappers.<SysUserPo>update().lambda()
                        .set(SysUserPo::getUserName, userName)
                        .eq(SysUserPo::getId, id));
    }

    /**
     * ??????????????????
     *
     * @param id    ??????Id
     * @param email ??????
     * @return ??????
     */
    @Override
    public int updateEmail(Long id, String email) {
        return baseMapper.update(new SysUserDto(),
                Wrappers.<SysUserPo>update().lambda()
                        .set(SysUserPo::getEmail, email)
                        .eq(SysUserPo::getId, id));
    }

    /**
     * ?????????????????????
     *
     * @param id    ??????Id
     * @param phone ?????????
     * @return ??????
     */
    @Override
    public int updatePhone(Long id, String phone) {
        return baseMapper.update(new SysUserDto(),
                Wrappers.<SysUserPo>update().lambda()
                        .set(SysUserPo::getPhone, phone)
                        .eq(SysUserPo::getId, id));
    }

    /**
     * ??????????????????
     *
     * @param id     ??????Id
     * @param avatar ????????????
     * @return ??????
     */
    @Override
    public int updateUserAvatar(Long id, String avatar) {
        return baseMapper.update(new SysUserDto(),
                Wrappers.<SysUserPo>update().lambda()
                        .set(SysUserPo::getAvatar, avatar)
                        .eq(SysUserPo::getId, id));
    }

    /**
     * ??????????????????
     *
     * @param id       ??????Id
     * @param password ??????
     * @return ??????
     */
    @Override
    public int resetUserPassword(Long id, String password) {
        return baseMapper.update(new SysUserDto(),
                Wrappers.<SysUserPo>update().lambda()
                        .set(SysUserPo::getPassword, password)
                        .eq(SysUserPo::getId, id));
    }

    /**
     * ??????Id??????????????????
     *
     * @param id Id
     * @return ??????
     */
    @Override
    @DSTransactional
    public int deleteById(Serializable id) {
        int row = baseMapper.deleteById(id);
        if (row > 0) {
            organizeRoleMergeMapper.delete(
                    Wrappers.<SysOrganizeRoleMerge>update().lambda()
                            .eq(SysOrganizeRoleMerge::getUserId, id));
            userPostMergeMapper.delete(
                    Wrappers.<SysUserPostMerge>update().lambda()
                            .eq(SysUserPostMerge::getUserId, id));
        }
        return row;
    }

    /**
     * ??????Id??????????????????????????????
     *
     * @param idList Id??????
     * @return ??????
     */
    @Override
    @DSTransactional
    public int deleteByIds(Collection<? extends Serializable> idList) {
        int rows = baseMapper.deleteBatchIds(idList);
        if (rows > 0) {
            organizeRoleMergeMapper.delete(
                    Wrappers.<SysOrganizeRoleMerge>update().lambda()
                            .in(SysOrganizeRoleMerge::getUserId, idList));
            userPostMergeMapper.delete(
                    Wrappers.<SysUserPostMerge>update().lambda()
                            .in(SysUserPostMerge::getUserId, idList));
        }
        return rows;
    }

    /**
     * ??????????????????????????????
     *
     * @param id   ??????Id
     * @param code ????????????
     * @return ????????????
     */
    @Override
    public SysUserDto checkUserCodeUnique(Long id, String code) {
        return baseConverter.mapperDto(baseMapper.selectOne(
                Wrappers.<SysUserPo>query().lambda()
                        .ne(SysUserPo::getId, id)
                        .eq(SysUserPo::getCode, code)
                        .last(SqlConstants.LIMIT_ONE)));
    }

    /**
     * ??????????????????????????????
     *
     * @param id       Id
     * @param userName ????????????
     * @return ?????? | true/false ??????/?????????
     */
    @Override
    public SysUserDto checkUserNameUnique(Serializable id, String userName) {
        return baseConverter.mapperDto(baseMapper.selectOne(
                Wrappers.<SysUserPo>query().lambda()
                        .ne(SysUserPo::getId, id)
                        .eq(SysUserPo::getUserName, userName)
                        .last(SqlConstants.LIMIT_ONE)));
    }

    /**
     * ??????????????????????????????
     *
     * @param id       ??????Id
     * @param userName ????????????
     * @return ????????????
     */
    @Override
    public SysUserDto checkNameUnique(Serializable id, String userName) {
        return baseConverter.mapperDto(baseMapper.selectOne(
                Wrappers.<SysUserPo>query().lambda()
                        .ne(SysUserPo::getId, id)
                        .eq(SysUserPo::getUserName, userName)
                        .last(SqlConstants.LIMIT_ONE)));
    }

    /**
     * ??????????????????????????????
     *
     * @param id    ??????Id
     * @param phone ????????????
     * @return ????????????
     */
    @Override
    public SysUserDto checkPhoneUnique(Long id, String phone) {
        return baseConverter.mapperDto(baseMapper.selectOne(
                Wrappers.<SysUserPo>query().lambda()
                        .ne(SysUserPo::getId, id)
                        .eq(SysUserPo::getPhone, phone)
                        .last(SqlConstants.LIMIT_ONE)));
    }

    /**
     * ??????email????????????
     *
     * @param id    ??????Id
     * @param email email
     * @return ????????????
     */
    @Override
    public SysUserDto checkEmailUnique(Long id, String email) {
        return baseConverter.mapperDto(baseMapper.selectOne(
                Wrappers.<SysUserPo>query().lambda()
                        .ne(SysUserPo::getId, id)
                        .eq(SysUserPo::getEmail, email)
                        .last(SqlConstants.LIMIT_ONE)));
    }
}
