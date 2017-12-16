package com.shop.dao;

import com.shop.entity.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    /**
     * �����û�����ѯ�û�
     *
     * @param userName
     * @return
     */
    public User findByUsername(String userName);

    /**
     * �����û����������ѯ�û�
     *
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPassword(String username, String password);

    /**
     * ���ݼ������ѯ�û�
     *
     * @param code
     * @return
     */
    public User findByCode(String code);

    /**
     * ��ѯ�ж��ٸ��û�
     *
     * @return
     */
    public Integer countUser();

    /**
     * ��ҳ���������û�
     *
     * @param page
     * @return
     */
    public List<User> findAll(Integer page);

    /**
     * ���ҵ����û�
     *
     * @param uid
     * @return
     */
    public User findOne(Integer uid);

}
