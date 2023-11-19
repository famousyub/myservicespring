package com.journaldev.rediscachedemo;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v0")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CachePut(value = "users", key = "#user.id")
   // @Caching(evict = { @CacheEvict(value = "users", allEntries = true), }, put = {@CachePut(value = "users", key = "#userId") })
//    @Cacheable(value = "users",key = "#userId",unless = "#result.followers < 12000")
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody User userRequest)
    {
        Integer counter = userRepository.findAll().size();
        Long y = Long.parseLong(counter.toString());
        y++;
       // User u = new User();
        userRequest.setId(y);
      //  u.setUsername(userRequest.getUsername());
      //  u.setName(userRequest.getName());
        userRequest.setFollowers(Long.parseLong("1"));

        userRequest.setToken(userRequest.getToken());
        userRepository.save(userRequest);


        return ResponseEntity.ok().body(userRequest.getUsername());
    }

    @Cacheable(value = "users", key = "#userId", unless = "#result.followers < 12000")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userId) {
        LOG.info("Getting user with ID {}.", userId);

        try {

            User _u = userRepository.findOne(Long.valueOf(userId));



            return _u;
        }catch (Exception ex){
            return new User() ;
        }

    }

    @CachePut(value = "users", key = "#user.id")
    @PutMapping("/update")
    public User updatePersonByID(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @CacheEvict(value = "users", allEntries=true)
    @DeleteMapping("/{userId}")
    public void deleteUserByID(@PathVariable Long userId) {
        LOG.info("deleting person with id {}", userId);
        userRepository.delete(userId);
    }
}
