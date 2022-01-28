package com.example.demo2;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;





    @RestController
    @RequestMapping(value = "api/v1/movies")
    public class BloggController {
       
        ArrayList<BloggPost> myBlogg;

       
        int latestBloggPostID;

        public BloggController() {
            myBlogg = new ArrayList<BloggPost>();
            latestBloggPostID = 0;
        }

    
  
        @RequestMapping(value = "create", method = RequestMethod.POST)
        public ResponseEntity<BloggPost> createMovie(@RequestBody BloggPost movie) {
            if (movie.getTitle() == "") {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            } else {
              
                latestBloggPostID++;
                movie.setId(latestBloggPostID);
                myBlogg.add(movie);
                System.out.println("Lade till en film: " + movie.getTitle());
                return new ResponseEntity<BloggPost>(movie, HttpStatus.CREATED);
            }
        }

        @RequestMapping(value = "clear", method = RequestMethod.DELETE)
        public void clearMovies() {
            myBlogg.clear();
            System.out.println("Rensade listan av filmer");
        }

        // CRUD - Read
        // Lista alla filmer
        @RequestMapping(value = "list", method = RequestMethod.GET)
        public ArrayList<BloggPost> listMovies() {
            System.out.println("Nu skickas listan av filmer till vår klient.");
            return myBlogg;
        }

        // CRUD - Read
        // Lista en specifik film
        @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
        public ResponseEntity<BloggPost> getMovie(@PathVariable("id") int id) {
            System.out.println("Getting movie with id " + id);

            BloggPost fetchedMovie = getBloggPostByID(id);

            if (fetchedMovie == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<BloggPost>(fetchedMovie, HttpStatus.OK);
        }

        private BloggPost getBloggPostByID(int id) {

        }

   
        @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
        public BloggPost listBloggPost(@PathVariable("id") int id, @RequestBody BloggPost BloggPostChanges) {
            System.out.println("Getting movie with id " + id);
            BloggPost BloggPostToUpdate = getBloggPostByID(id);

            if (BloggPostChanges.getTitle() != null) {
                BloggPostToUpdate.setTitle(BloggPostChanges.getTitle());
            }
            if (BloggPostChanges.getRating() != 0) {
                BloggPostToUpdate.setRating(BloggPostChanges.getRating());
            }

            updateBloggPost(id, BloggPostToUpdate);

            return BloggPostToUpdate;
        }

        
        private BloggPost getBloggPostByIDByID(int id) {
            for (BloggPost currentMovie : myBlogg) {
                if (currentMovie.getId() == id) {
                    return currentMovie;
                }
            }

            return null;
        }

       
        private BloggPost updateBloggPostByid(int id, BloggPost updatedBlogg) {
            for (int i = 0; i < myBlogg.size(); i++) {
               BloggPost currentBlogg = myBlogg.get(i);
                if (currentBlogg.getId() == id) {
                    myBlogg.set(i, updatedBlogg);
                    return myBlogg.get(i);
                }
            }

            return new BloggPost();
        }
    }


