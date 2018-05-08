package Controller;


import Models.Blog;
import org.junit.Test;

import java.util.*;

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

    //Just playin' here. Of course this is not a real test.
    @Test
    public void testingHashsets() {
        Set<String> theGreats = new HashSet<String>();
        theGreats.add("Bill Hicks");
        theGreats.add("Chris Rock");
        theGreats.add("George Carlin");
        theGreats.add("Doug Stanhope");
        theGreats.add("Bill Hicks");  //this will not be added to the set because the values in the set must be unique
        theGreats.add("Bill hicks");

        System.out.println(theGreats);

        for (String name : theGreats){
            System.out.println(name + ", ");
        }

        //checking is something is in a set

        System.out.println("Is Louis CK one of the greats? " + theGreats.contains("Louis CK"));
        System.out.println("Is George Carlin one of the greats? " + theGreats.contains("George Carlin"));

        Set<String> actors = new HashSet<String>();
        actors.add("Clint Eastwood");
        actors.add("Daniel Craig");
        actors.add("Russel's Crowe"); //OMG ITS RUSSEL CROWE!
        actors.add("Roseanne");

        //merging two sets

        theGreats.addAll(actors);
        System.out.println("after merge: " + theGreats);

        theGreats.retainAll(actors);
        System.out.println("after retain: " + theGreats);
        System.out.println("theGreats will now hold the contents of actors due to the retain fuction" +
                "The retain function works by retaining the common elements in the two sets used in the operation");
        theGreats.removeAll(actors);
        System.out.println("theGreats after removing the actors: " + theGreats);
    }

    @Test
    public void testingHashmaps(){
        Map namesMap = new HashMap<Integer, String>();
        namesMap.put(1, "Dale");
        namesMap.put(2, "Hank");
        namesMap.put(3, "Boomhauer");
        namesMap.put(4, "Bill");
        //namesMap.put("cat", "1"); //you can get away with this
        System.out.println("list of names: " + namesMap);
//        for (int i = 0; i < namesMap.size()+1; i++){
//            System.out.println("(HashMap) Name at key " + i + " " + namesMap.get(i));
//        }

        //Compared to above, here we explicitly mention that the Map will be of <Integer, String> (no primitives)
        //This is because .put() method belongs to Map interface.
        //So, here we explicitly mention that "HEY! You can only put an Integer and String"
        //Whereas, in the above, section we employ a raw map. so anything goes.
//        Map<Integer, String> namesMap2 = new HashMap<Integer, String>();
//        namesMap2.put("cat", "1");
//        System.out.println("list of names: " + namesMap2);

        Map treeName = new TreeMap<Integer, String>(namesMap);
        System.out.println("TreeMap: " + treeName);
        //the thing about TreeMap is that it allows you to get the value at specific key. Not possible with a HashMap
        //FALSE, YOU CAN DO THIS WITH HASH(ish)MAP TOO!!!!
        for (int i = 0; i < treeName.size()+1; i++){
            System.out.println("(TreeMap) Name at key " + i + " " + treeName.get(i));
        }


    }

}
