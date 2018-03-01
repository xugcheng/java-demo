package com.xugc.demo.collections.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 自定义迭代器
 */
public class Users implements Iterable<User> {

    private List<User> userList;

    public Users(List<User> users) {
        this.userList = users;
    }

    @Override
    public Iterator<User> iterator() {
        return new UserIterator(userList);
    }

    class UserIterator implements Iterator<User> {

        private int index = 0;

        private List<User> userList;

        public UserIterator(List<User> userList) {
            this.userList = userList;
        }

        @Override
        public boolean hasNext() {
            return index++ < userList.size();
        }

        @Override
        public User next() {
            return userList.get(index - 1);
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] agrs) {

        List<User> userList = new ArrayList<>();
        userList.add(new User("张三", 19));
        userList.add(new User("李四", 20));
        userList.add(new User("王五", 21));

        Users users = new Users(userList);

        for (User user : users) {
            System.out.println(user.toString());
        }

        users.forEach(user -> user.setAge(user.getAge() * user.getAge()));

        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}
