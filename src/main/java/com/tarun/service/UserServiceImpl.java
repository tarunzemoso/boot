package com.tarun.service;

import com.tarun.dao.UserRepository;
import com.tarun.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theCourseRepository) {
        userRepository = theCourseRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAllByOrderByUserNameAsc();
    }

    @Override
    public User findByUserName(String theUserName) {
        Optional<User> result = userRepository.findById(theUserName);

        User theCourse = null;

        if (result.isPresent()) {
            theCourse = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theUserName);
        }

        return theCourse;
    }

    @Override
    public void save(User theCourse) {
        userRepository.save(theCourse);
    }


    @Override
    public void deleteByUserName(String theId) {
        userRepository.deleteById(theId);
    }



    @Override
    public void register(User user)  {
        User userEntity = new User();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity);
        userRepository.save(userEntity);
    }


    private void encodePassword(User userEntity){

    }
}
