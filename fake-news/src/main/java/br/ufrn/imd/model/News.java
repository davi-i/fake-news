package br.ufrn.imd.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class News {
    private String originalText;
    private String formattedText;
    private String url;
    private LocalDateTime timestamp;

    public News(String[] data) {
        this.originalText = data[1];
        this.formattedText = "";
        this.url = data[2];

        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.timestamp = LocalDateTime.parse(data[3], formatter);
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getFormattedText() {
        return formattedText;
    }

    public void setFormattedText(String formattedText) {
        this.formattedText = formattedText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String toString() {
        return "News {" +
            "originalText=" + originalText + "," + 
            "formattedText=" + formattedText + "," +
            "url=" + url + "," +
            "timestamp=" + timestamp.toString()
            + "}";
    }
}
