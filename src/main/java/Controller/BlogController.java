package Controller;

import Models.Blog;
import Models.BlogMockedData;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

    BlogMockedData blogMD = BlogMockedData.getInstance();

    @GetMapping("/blog")
    public List<Blog> index(){
        return blogMD.fetchBlogs();
    }

    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogMD.getBlogById(blogId);
    }

    //insted of the postmapping annotion, you could just do @RequestMapping(value="/blog/search" RequestMethod.POST)
    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return blogMD.searchBlogs(searchTerm);
    }

/*
    to test any of these request, use something like postman and make requests to the appropriate URL
    (or curl, if you're a god-damn animal)
    in the request body, set the payload to the appropriate key:val pairs
    eg: For blog/search
        {"text":"google"}
    eg: for blog/ (to create a blog-post)
        {"id":"45", "title":"This is a blog post.", "content":" about as insightful as any other blogpost"}

    the way this works is by taking the key:val pair collection, in the form of the map datatype for java, and
    sees if the key matches any of the types mentioned in the method (body.get("keyName"))
    ya'dig? Ooh man, the melatonin is starting to kick in

 */


    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body){
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String content = body.get("content");
        return blogMD.createBlog(id, title, content);
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
        int blogId = Integer.parseInt(id);
        String title = body.get("title");
        String content = body.get("content");
        return blogMD.updateBlog(blogId, title, content);
    }

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogMD.delete(blogId);
    }

}