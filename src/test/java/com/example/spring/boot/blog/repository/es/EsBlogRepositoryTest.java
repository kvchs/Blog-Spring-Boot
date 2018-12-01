//package com.example.spring.boot.blog.repository.es;
//
//import com.example.spring.boot.blog.domain.es.EsBlog;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.reactive.server.JsonPathAssertions;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class EsBlogRepositoryTest {
//
//    @Autowired
//    private EsBlogRepository esBlogRepository;
//
//    @Before
//    public void initRepositoryData(){
//        // 清除所有数据
//        esBlogRepository.deleteAll();
//        esBlogRepository.save(new EsBlog("实例1", "实例1", "实例1"));
//        esBlogRepository.save(new EsBlog("实例2", "实例2", "实例2"));
//        esBlogRepository.save(new EsBlog("实例3", "实例3", "实例3"));
//    }
//
//    @Test
//    public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(){
//        Pageable pageable = new PageRequest(0, 20);
//        String title = "1";
//        String summary = "1";
//        String content = "1";
//
//        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
//
//        for (EsBlog blog: page.getContent()){
//            System.out.println(blog.toString());
//        }
//    }
//
//
//
//}
