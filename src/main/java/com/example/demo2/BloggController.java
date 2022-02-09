package com.example.demo2;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;





    @RestController
    @RequestMapping(value = "api/v1/blog")
    public class BloggController {
       
        ArrayList<BloggPost> myBlogg;

       
        int latestBloggPostID;

        public BloggController() {
            myBlogg = new ArrayList<BloggPost>();
            latestBloggPostID = 0;
        }

    
  
        @RequestMapping(value = "create", method = RequestMethod.POST)
        public ResponseEntity<BloggPost> createBlogg(@RequestBody BloggPost Blogg) {
            if (Blogg.getTitle() == "") {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            } else {
              
                latestBloggPostID++;
                Blogg.setId(latestBloggPostID);
                myBlogg.add(Blogg);
                System.out.println("Lade till ett nytt inlägg: " + Blogg.getTitle());
                return new ResponseEntity<BloggPost>(Blogg, HttpStatus.CREATED);
            }
        }

        @RequestMapping(value = "clear", method = RequestMethod.DELETE)
        public void clearBloggposts() {
            myBlogg.clear();
            System.out.println("Rensade listan av inlägg");
        }

        // CRUD - Read
        // Lista alla filmer
        @RequestMapping(value = "list", method = RequestMethod.GET)
        public ArrayList<BloggPost> listBloggs() {
            System.out.println("Nu skickas listan av Blogginlägg till vår klient.");
            return myBlogg;
        }

        // CRUD - Read
        // Lista en specifik film
        @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
        public ResponseEntity<BloggPost> getBloggs(@PathVariable("id") int id) {
            System.out.println("Getting Blogg with id " + id);

            BloggPost fetchedBlogg = getBloggPostById(id);

            if (fetchedBlogg == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<BloggPost>(fetchedBlogg, HttpStatus.OK);
        }

        @RequestMapping(value = "delete/{id}" , method = RequestMethod.DELETE)
        public ResponseEntity<Void> deleteBloggsById(@PathVariable("id") int id){
            System.out.println("Deleting Bloggpost with id " + id);

             deleteBloggPostById(id);

            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
   
        @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
        public BloggPost listBloggPost(@PathVariable("id") int id, @RequestBody BloggPost BloggPostChanges) {
            System.out.println("Getting Blogg with id " + id);
            BloggPost BloggPostToUpdate = getBloggPostById(id);

            if (BloggPostChanges.getTitle() != null) {
                BloggPostToUpdate.setTitle(BloggPostChanges.getTitle());
            }
            if (BloggPostChanges.getMessage() != null) {
                BloggPostToUpdate.setMessage(BloggPostChanges.getMessage());
            }

            updateBloggPostById(id, BloggPostToUpdate);

            return BloggPostToUpdate;
        }


        private void deleteBloggPostById(int id) {
            System.out.println("Här ska detta inlägg tas bort");
            for  (int i = 0; i < myBlogg.size(); i++ ) {
                if (myBlogg.get(i).getId() == id) {
                    myBlogg.remove(i);
                }


            }
        }

        private BloggPost getBloggPostById(int id) {
            for (BloggPost currentBlogg : myBlogg) {
                if (currentBlogg.getId() == id) {
                    return currentBlogg;
                }
            }

            return null;
        }

       
        private BloggPost updateBloggPostById(int id, BloggPost updatedBlogg) {
            for (int i = 0; i < myBlogg.size(); i++) {
               BloggPost currentBlogg = myBlogg.get(i);
                if (currentBlogg.getId() == id) {
                    myBlogg.set(i, updatedBlogg);
                    return myBlogg.get(i);
                }
            }

            return null;
        }
    }


