package com.bookly.bookly_back_end.response;

import lombok.Data;

import java.util.List;

@Data
public class GoogleBookResponse {
    private List<Item> items;

    @Data
    public static class Item {
        private VolumeInfo volumeInfo;
    }

    @Data
    public static class VolumeInfo {
        private String title;
        private List<String> authors;
        private String publisher;
        private String publishedDate;
        private String description;
        private ImageLinks imageLinks;
    }

    @Data
    public static class ImageLinks {
        private String thumbnail;
    }
}
