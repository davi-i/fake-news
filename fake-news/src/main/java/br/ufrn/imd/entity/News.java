package br.ufrn.imd.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalText;
    private String formattedText;
    private String url;
    private LocalDateTime timestamp;

    public News(String originalText, String formattedText, String url, LocalDateTime timestamp) {
        this.originalText = originalText;
        this.formattedText = formattedText;
        this.url = url;
        this.timestamp = timestamp;
    }

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
