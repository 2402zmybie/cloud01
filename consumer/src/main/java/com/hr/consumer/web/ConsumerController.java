package com.hr.consumer.web;

import com.hr.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        //设置另外一台服务器地址 (实现一台服务器调用另外一台服务器数据)
        String url = "http://localhost:8090/user/" + id;
        //远程查询 返回数据
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}
