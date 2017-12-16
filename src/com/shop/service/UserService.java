package com.shop.service;

import com.shop.entity.User;

public interface UserService {

    /**
     *
     * @param code
     * @return
     */
    public User active(String code);

    /**
     * ͨ���û�������������û�
     * @param user
     * @return
     */
    public User findUserByUsernameAndPassword(User user);

    /**
     * �����û����ж��û��Ƿ����
     * @param userName
     * @return
     */
    public User existUser(String userName);

    /**
     * ע���û�
     *
     * @param user
     */
    public void register(User user);

    /**
     *
     * @param user
     */
    public void update(User user);

    /**
     * �����û�uid��ֵ��ѯ�û�
     *
     * @param uid
     * @return
     */
    public User findByUid(Integer uid);
}