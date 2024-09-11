package org.codedevils.scraper.cd_scraper.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ScraperController {

    @GetMapping("/")
    public Index getMethodName(@RequestParam(defaultValue = "World") String param) {
        return new Index("Hello " + param);
    }

    @GetMapping("/all")
    public All getMethodName() {
        // NOTE: This is a temporary list of job postings
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            posts.add(new Post("title" + i, "url" + i));
        }

        return new All(posts);
    }

}
