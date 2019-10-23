package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class SpringAuditApplication {
    @Autowired
    private BookRepository repository;

    @PostMapping("/save")
    public String save(@RequestBody Book book) {
        repository.save(book);
        return "saved";
    }

    @PutMapping("/update/{id}/{pages}")
    public String update(@PathVariable int id, @PathVariable int pages) {
        Book book = repository.findById(id).get();
        book.setPages(pages);
        repository.save(book);
        return "updated..";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        repository.deleteById(id);
        return "deleted..";
    }

    @GetMapping("/test/{id}")
    public void test(@PathVariable int id) {
        System.out.println(repository.findLastChangeRevision(id));
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println(repository.findLastChangeRevision(id));
        System.out.println("+++++++++++++++++++++++++++++++++++++");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAuditApplication.class, args);
    }

}
