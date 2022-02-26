package genshinbook.dao;

import genshinbook.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User login(User user);
    public Integer register(User user);
    public String getPassword(String e_mail);
    public Integer updatePassword(User user);
}
