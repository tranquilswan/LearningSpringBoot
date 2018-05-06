package Controller;


import Models.Blog;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BlogControllerTest {

    //Here we test the BlogController

    BlogController blogCtrlTest = new BlogController();
    Blog returnedBlog;
    Map<String, String> mapForBlog = new HashMap<>();


    @Test
    public void show() throws Exception {
        String expecTitle, expecContent = null;
        expecTitle = "Go up, up and away with your Google Assistant";
        expecContent = "With holiday travel coming up, and 2018 just around the corner, ";

        returnedBlog = blogCtrlTest.show("1");

        assertEquals(expecTitle, returnedBlog.getTitle());
        assertEquals(expecContent, returnedBlog.getContent());
    }

    @Test
    public void search() throws Exception {
        //search google
        //count of 5
        mapForBlog.put("text","google");
        List<Blog> returnedBlogList = blogCtrlTest.search(mapForBlog);

        assertEquals(5, returnedBlogList.size());
    }

    @Test
    public void create() throws Exception {
        mapForBlog.put("id", "7");
        mapForBlog.put("title", "testBlog Yo");
        mapForBlog.put("content", "I am a test blog, short and sweet. Here are my content, my name is pete");

        returnedBlog = blogCtrlTest.create(mapForBlog);

        assertEquals(7, returnedBlog.getId());
        assertEquals("testBlog Yo", returnedBlog.getTitle());
        assertEquals("I am a test blog, short and sweet. Here are my content, my name is pete",
                returnedBlog.getContent());
    }

    @Test
    public void update() throws Exception {
        this.create();

        mapForBlog.put("title", "newTitle");
        mapForBlog.put("content", "newContent");

        returnedBlog = blogCtrlTest.update("7", mapForBlog);

        assertEquals("newTitle", returnedBlog.getTitle());
        assertEquals("newContent", returnedBlog.getContent());
    }

    @Test
    public void delete() throws Exception {
        this.create();

        assertEquals(true, blogCtrlTest.delete("7"));
    }


}
