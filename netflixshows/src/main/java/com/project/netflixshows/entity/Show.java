package com.project.netflixshows.entity;

import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;

@Entity
@Table
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "seasons")
    private int seasons;

    @Column(name = "streaming_platform")
    private String streamingPlatform;

    @Column(name = "rating")
    private int rating;


    //default constructor
    public Show(){

    }

    //para constructor
    public Show(String title, int seasons, String streamingPlatform, int rating){
        this.title = title;
        this.seasons = seasons;
        this.streamingPlatform = streamingPlatform;
        this.rating = rating;
    }

    //setters and getters
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public int getSeasons() {return seasons;}

    public void setSeasons(int seasons) {this.seasons = seasons;}

    public String getStreamingPlatform() {return streamingPlatform;}

    public void setStreamingPlatform(String streamingPlatform) {this.streamingPlatform = streamingPlatform;}

    public int getRating() {return rating;}

    public void setRating(int rating) {this.rating = rating;}


    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", seasons=" + seasons +
                ", streamingPlatform='" + streamingPlatform + '\'' +
                ", rating=" + rating +
                '}';
    }
}
