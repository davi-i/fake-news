package br.ufrn.imd.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.ufrn.imd.string.StringProcessor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalText;
    private String formattedText;
    private String url;
    private LocalDateTime timestamp;

    public News() {
        super();
    }

    public News(String originalText, String url, LocalDateTime timestamp) {
        this.originalText = originalText;
        this.formattedText = StringProcessor.process(originalText);
        this.url = url;
        this.timestamp = timestamp;
    }

    public News(String[] data) {
        this.originalText = data[1];
        this.formattedText = StringProcessor.process(this.originalText);
        this.url = data[2];

        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.timestamp = LocalDateTime.parse(data[3], formatter);
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
